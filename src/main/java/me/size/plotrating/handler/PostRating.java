package me.size.plotrating.handler;

import com.plotsquared.core.location.Location;
import com.plotsquared.core.plot.Plot;
import lombok.NoArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


@NoArgsConstructor
public class PostRating {

    /**
     * @param player = Player who Rated
     * @param score = Score plot received
     */
    public void setScore(Player player, int score) {
        Location plotLoc = new Location(player.getWorld().getName(),
                player.getLocation().getBlockX(),
                player.getLocation().getBlockY(),
                player.getLocation().getBlockZ());
        Plot plot = plotLoc.getPlot();
        Location home = plot.getDefaultHomeSynchronous(true);

        org.bukkit.Location block1 = new org.bukkit.Location(Bukkit.getWorld(home.getWorld()),
                home.getX() + 2,
                home.getY() - 1,
                home.getZ());
        org.bukkit.Location block2 = new org.bukkit.Location(Bukkit.getWorld(home.getWorld()),
                home.getX() + 3,
                home.getY() - 1,
                home.getZ());
        org.bukkit.Location block3 = new org.bukkit.Location(Bukkit.getWorld(home.getWorld()),
                home.getX() + 4,
                home.getY() - 1,
                home.getZ());

        Settings.setBlocks(block1, block2, block3, score);

        org.bukkit.Location sign = block1.add(0, 0, -1);
        SignHandler.setSign(player, sign, score);
    }
}