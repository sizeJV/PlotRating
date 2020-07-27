package me.size.plotrating.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class SettingsConfig extends AbstractConfig {

    public static final String ITEM1 = "item1";
    public static final String ITEM2 = "item2";
    public static final String ITEM3 = "item3";
    public static final String ITEM4 = "item4";
    public static final String ITEM5 = "item5";


    public SettingsConfig(JavaPlugin javaPlugin) {
        super(javaPlugin, "settings");
    }


    @Override
    public String getString(String key) {
        return getFileConfiguration().getString(key);
    }


    @Override
    protected void saveDefaultConfig(FileConfiguration config) {

        config.set(ITEM1, "iron_door,&eKreativitaet,&abeispiel");
        config.set(ITEM2, "crafting_table,&eInovation,&abeispiel");
        config.set(ITEM3, "dandelion,&eAussehen,&abeispiel");
        config.set(ITEM4, "nether_star,&eAufbau,&abeispiel");
        config.set(ITEM5, "command_block,&eFunktion,&abeispiel");

        config.set("5", new String[]{"Dirt", "Dirt", "Dirt"});
        config.set("6", new String[]{"Dirt", "Iron_block", "Dirt"});
        config.set("7", new String[]{"Dirt", "Iron_block", "Dirt"});
        config.set("8", new String[]{"iron_block", "Dirt", "iron_block"});
        config.set("9", new String[]{"iron_block", "Dirt", "iron_block"});
        config.set("10", new String[]{"iron_block", "iron_block", "iron_block"});
        config.set("11", new String[]{"iron_block", "diamond_block", "iron_block"});
        config.set("12", new String[]{"iron_block", "diamond_block", "iron_block"});
        config.set("13", new String[]{"diamond_block", "iron_block", "diamond_block"});
        config.set("14", new String[]{"diamond_block", "iron_block", "diamond_block"});
        config.set("15", new String[]{"diamond_block", "diamond_block", "diamond_block"});
        config.set("16", new String[]{"diamond_block", "beacon", "diamond_block"});
        config.set("17", new String[]{"diamond_block", "beacon", "diamond_block"});
        config.set("18", new String[]{"beacon", "diamond_block", "beacon"});
        config.set("19", new String[]{"beacon", "diamond_block", "beacon"});
        config.set("20", new String[]{"beacon", "beacon", "beacon"});
        config.set("21", new String[]{"beacon", "Dragon_egg", "beacon"});
        config.set("22", new String[]{"beacon", "Dragon_egg", "beacon"});
        config.set("23", new String[]{"Dragon_egg", "beacon", "Dragon_egg"});
        config.set("24", new String[]{"Dragon_egg", "beacon", "Dragon_egg"});
        config.set("25", new String[]{"Dragon_egg", "Dragon_egg", "Dragon_egg"});
    }
}
