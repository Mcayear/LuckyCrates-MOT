package angga7togk.luckycrates.crates;

import angga7togk.luckycrates.LuckyCrates;
import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.nbt.tag.CompoundTag;

import java.util.Objects;

public class Keys{
    private final String id;
    private final int meta;
    private final String name;
    private final String lore;
    public Keys(){
        this.id = LuckyCrates.getInstance().getConfig().getString("keys.id", "minecraft:stone");
        this.meta = LuckyCrates.getInstance().getConfig().getInt("keys.meta", 0);
        this.name = LuckyCrates.getInstance().getConfig().getString("keys.name", "{crate} Key");
        this.lore = LuckyCrates.getInstance().getConfig().getString("keys.lore", "Claim rewards from a {crate} Crate");
    }

    public boolean isKeys(Item item) {
        String id = item.getNamespaceId();
        int meta = item.getDamage();
        CompoundTag nameTag = item.hasCompoundTag() ? item.getNamedTag() : null;
        
        return id.equals(LuckyCrates.getInstance().getConfig().getString("keys.id", "minecraft:tripwire_hook"))
                && meta == LuckyCrates.getInstance().getConfig().getInt("keys.meta", 0)
                && nameTag != null
                && nameTag.contains("isKeys");
    }

    public String getCrateName(Item item){
        if(isKeys(item)){
            return item.getNamedTag().getString("crateName");
        }
        return null;
    }

    public boolean crateExists(String crateName) {
        return LuckyCrates.crates.exists(crateName);
    }

    public boolean giveKey(Player player, String crateName, int amount){
        if (crateExists(crateName)){
            String customName = this.name.replace("{crate}", crateName);
            String lore = this.lore.replace("{crate}", crateName);
            Item item = Item.fromString(this.id)
                    .setNamedTag(new CompoundTag()
                            .putBoolean("isKeys", true)
                            .putString("crateName", crateName));
            item.setDamage(this.meta);
            item.setCount(amount);
            item.addEnchantment(Enchantment.getEnchantment(Enchantment.ID_BINDING_CURSE));
            if(isKeys(item)){
                player.getInventory().addItem(item.setCustomName(customName).setLore(lore));
                return true;
            }
        }
        return false;
    }
}