package me.size.plotrating.handler;

import lombok.Getter;
import me.size.plotrating.config.SettingsConfig;
import me.size.plotrating.util.ItemBuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;


public class Settings {

    @Getter
    private final SettingsConfig config;


    public Settings(JavaPlugin javaPlugin) {
        config = new SettingsConfig(javaPlugin);
    }


    public static ItemStack ITEM1;
    public static ItemStack ITEM2;
    public static ItemStack ITEM3;
    public static ItemStack ITEM4;
    public static ItemStack ITEM5;

    public static HashMap<Integer, Object> ratings = new HashMap<>();


    /**
     * loads Config to local Objects
     */
    public void load() {
        FileConfiguration config = this.config.getFileConfiguration();

        ITEM1 = createFromString(config.getString(SettingsConfig.ITEM1));
        ITEM2 = createFromString(config.getString(SettingsConfig.ITEM2));
        ITEM3 = createFromString(config.getString(SettingsConfig.ITEM3));
        ITEM4 = createFromString(config.getString(SettingsConfig.ITEM4));
        ITEM5 = createFromString(config.getString(SettingsConfig.ITEM5));

        for (int i = 5; i <= 25; i++) {
            ratings.put(i, config.get(String.valueOf(i)));
            Bukkit.getConsoleSender().sendMessage(String.valueOf(ratings.get(i)));
        }
    }


    /**
     * @param input: Input String from Config
     * @return = Returns a ItemStack out of a String
     */
    public ItemStack createFromString(String input) {
        String[] compiled = new String[0];
        if (input != null) {
            compiled = input.split("\\s*,\\s*");
        }

        String mat = compiled[0];
        mat = mat.toUpperCase();

        Material material = Material.getMaterial(mat);
        if (material == null) {
            material = Material.BARRIER;
        }

        String name = compiled[1];
        name = ChatColor.translateAlternateColorCodes('&', name);
        String lore = compiled[2];
        lore = ChatColor.translateAlternateColorCodes('&', lore);

        return ItemBuilder.build(material, name, lore);
    }


    public static void setBlocks(Location block1, Location block2, Location block3, int score) {
        Block[] blocks = new Block[]{block1.getBlock(), block2.getBlock(), block3.getBlock()};
        blocksChangeMaterial(blocks, score);
    }


    /**
     * @param blocks : Block Array initialized in setBlocks()
     * @param score -> Key to Materials
     */
    public static void blocksChangeMaterial(Block[] blocks, int score) {

        String string = String.valueOf(ratings.get(score));

        String[] strings = string.split("\\s*,\\s*");

        for (int i = strings.length - 1; i >= 0; i--) {
            strings[i] = strings[i].replace("[", "");
            strings[i] = strings[i].replace("]", "");
            strings[i] = strings[i].toUpperCase();
        }

        Block block1 = blocks[0];
        Block block2 = blocks[1];
        Block block3 = blocks[2];

        Material mat1 = Material.getMaterial(strings[0]);
        Material mat2 = Material.getMaterial(strings[1]);
        Material mat3 = Material.getMaterial(strings[2]);

        if (mat1 == null) {
            mat1 = Material.COAL_BLOCK;
        }

        if (mat2 == null) {
            mat2 = Material.COAL_BLOCK;
        }

        if (mat3 == null) {
            mat3 = Material.COAL_BLOCK;
        }

        block1.setType(mat1);
        block2.setType(mat2);
        block3.setType(mat3);
    }
}
