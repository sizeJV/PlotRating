package me.size.plotrating.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class SignConfig extends AbstractConfig {

    public static final String LINE1 = "line1";
    public static final String LINE2 = "line2";
    public static final String LINE3 = "line3";
    public static final String LINE4 = "line4";


    public SignConfig(JavaPlugin javaPlugin) {
        super(javaPlugin, "sign");
    }


    @Override
    public String getString(String key) {
        return getFileConfiguration().getString(key);
    }


    @Override
    protected void saveDefaultConfig(FileConfiguration config) {
        config.set(LINE1, "Bewertet von");
        config.set(LINE2, "&c%player%");
        config.set(LINE3, "-*-");
        config.set(LINE4, "&c%points%/25");
    }
}
