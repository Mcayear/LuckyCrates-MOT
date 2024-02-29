package angga7togk.luckycrates.language;

import angga7togk.luckycrates.LuckyCrates;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Languages {

    private final String lang;
    public Languages(){
        String lang = LuckyCrates.getInstance().getConfig().getString("language");
        if(lang.equalsIgnoreCase("id") || lang.equalsIgnoreCase("en") || lang.equalsIgnoreCase("cn")){
            this.lang = lang;
        }else{
            this.lang = "en";
        }
    }

    public Map<String, String> getLanguage() {
        Map<String, Map<String, String>> lang = new HashMap<>();

        Map<String, String> id = new HashMap<>();
        Map<String, String> en = new HashMap<>();
        Map<String, String> cn = new HashMap<>();

        // Bahasa Indonesia (id)
        id.put("crate-notfound", "§cCrate tidak ditemukan!");
        id.put("player-notfound", "§cPemain tidak ditemukan.");
        id.put("setmode", "§eSilakan hancurkan blok untuk mengubahnya menjadi Crates.");
        id.put("amount-number", "§cJumlah harus angka.");
        id.put("give-key", "§aBerhasil memberikan kunci {crate} sejumlah {amount} kepada {player}.");
        id.put("accept-key", "§aKamu menerima kunci {crate} sejumlah {amount}.");
        id.put("key-all", "§aBerhasil memberikan kunci {crate} sejumlah {amount} kepada semua pemain.");
        id.put("setted-crate", "§eBerhasil memasang crate {crate}");
        id.put("break-crate", "§cBerhasil menghancurkan crate {crate}");

        // Bahasa Inggris (en)
        en.put("crate-notfound", "§cCrate not found!");
        en.put("player-notfound", "§cPlayer not found.");
        en.put("setmode", "§ePlease break the block to change it into Crates.");
        en.put("amount-number", "§cAmount must be a number.");
        en.put("give-key", "§aSuccessfully gave {amount} {crate} key(s) to {player}.");
        en.put("accept-key", "§aYou accepted {amount} {crate} key(s).");
        en.put("key-all", "§aSuccessfully gave {amount} {crate} key(s) to all players.");
        en.put("setted-crate", "§eSuccessfully set up the {crate} crate.");
        en.put("break-crate", "§cSuccessfully broke the {crate} crate.");

        // Chinese (cn)
        cn.put("crate-notfound", "§c未找到箱子！");
        cn.put("player-notfound", "§c未找到玩家。");
        cn.put("setmode", "§e请打破方块以将其更改为箱子。");
        cn.put("amount-number", "§c数量必须是数字。");
        cn.put("give-key", "§a成功给予{amount}个{crate}钥匙给{player}。");
        cn.put("accept-key", "§a您接受了{amount}个{crate}钥匙。");
        cn.put("key-all", "§a成功给予所有玩家{amount}个{crate}钥匙。");
        cn.put("setted-crate", "§e成功设置{crate}箱子。");
        cn.put("break-crate", "§c成功打破{crate}箱子。");

        lang.put("id", id);
        lang.put("en", en);
        lang.put("cn", cn);

        return lang.get(this.lang);
    }
}
