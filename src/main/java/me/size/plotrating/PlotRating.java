package me.size.plotrating;

import com.plotsquared.core.command.MainCommand;
import me.size.plotrating.command.RateCommand;
import me.size.plotrating.handler.Settings;
import me.size.plotrating.handler.SignHandler;
import me.size.plotrating.listener.InventoryListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class PlotRating extends JavaPlugin {

    public static PlotRating instance;


    @Override
    public void onEnable() {
        instance = this;
        Settings settings = new Settings(this);
        settings.load();
        SignHandler signHandler = new SignHandler(this);
        signHandler.load();

        Bukkit.getPluginManager().registerEvents(new InventoryListeners(), this);
        MainCommand.getInstance().register(new RateCommand());
        Bukkit.getConsoleSender().sendMessage("[Plot-Rating] successfully enabled plugin");
    }


    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("[Plot-Rating] successfully disabled plugin");
    }
}
