package me.size.plotrating.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public abstract class AbstractConfig {

    public File configFile;


    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }


    public FileConfiguration fileConfiguration;
    public final JavaPlugin javaPlugin;


    public AbstractConfig(JavaPlugin javaPlugin, String fileName) {
        this.javaPlugin = javaPlugin;
        createFile(fileName);
        save();
    }


    public void createFile(String fileName) {
        boolean doDefaultSave = false;
        configFile = new File(javaPlugin.getDataFolder() + "/" + fileName + ".yml");

        if (!configFile.exists()) {
            doDefaultSave = true;
        }

        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);

        if (doDefaultSave) {
            saveDefaultConfig(fileConfiguration);
        }
    }


    public void save() {

        try {
            fileConfiguration.save(configFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
    }


    public int getInt(String path) {
        return fileConfiguration.getInt(path);
    }


    public String getString(String path) {
        return fileConfiguration.getString(path);
    }


    public String getConfigPath() {
        return configFile.getPath();
    }


    protected abstract void saveDefaultConfig(FileConfiguration config);
}

