package me.size.plotrating.handler;

import lombok.Getter;
import me.size.plotrating.config.SignConfig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.data.Directional;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class SignHandler {

    @Getter
    private final SignConfig config;


    public SignHandler(JavaPlugin javaPlugin) {
        config = new SignConfig(javaPlugin);
    }


    private static String LINE1;
    private static String LINE2;
    private static String LINE3;
    private static String LINE4;


    /**
     * loads Config to local Objects
     */
    public void load() {
        FileConfiguration config = this.config.getFileConfiguration();

        LINE1 = config.getString("line1");
        LINE2 = config.getString("line2");
        LINE3 = config.getString("line3");
        LINE4 = config.getString("line4");
    }


    public static void setSign(Player player, Location location, int score) {

        String[] strings = new String[]{LINE1, LINE2, LINE3, LINE4};

        for (int i = strings.length - 1; i >= 0; i--) {

            String string = strings[i];

            if (string.contains("&")) {
                ChatColor chatColor = ChatColor.getByChar(string.substring(string.lastIndexOf("&") + 1, 2));

                string = ChatColor.translateAlternateColorCodes('&', string);
            }

            string = string.replace("%player%", player.getName());
            string = string.replace("%points%", String.valueOf(score));

            strings[i] = string;
        }

        String line1 = strings[0];
        String line2 = strings[1];
        String line3 = strings[2];
        String line4 = strings[3];

        Block signBlock = location.getBlock();
        signBlock.setType(Material.OAK_WALL_SIGN);
        BlockState signState = signBlock.getState();
        Sign sign = (Sign) signState;

        Directional wallSignData = (Directional) signBlock.getBlockData();
        wallSignData.setFacing(BlockFace.SOUTH);
        signBlock.setBlockData(wallSignData);

        sign.setLine(0, line1);
        sign.setLine(1, line2);
        sign.setLine(2, line3);
        sign.setLine(3, line4);

        sign.update();
    }
}
