package me.size.plotrating.gui;

import lombok.NoArgsConstructor;
import me.size.plotrating.util.GuiContents;
import me.size.plotrating.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


@NoArgsConstructor
public class GuiInventory {

    public void openGUI(Player player) {

        Inventory inventory = Bukkit.createInventory(player, 9 * 6, "§aPlot-Bewertung");
        GuiContents.getDefaultContents().forEach((k, v) -> inventory.setItem(v, k));

        for (int i = GuiContents.getGrid().length - 1; i >= 0; i--) {
            if (GuiContents.getVertical(GuiContents.getGrid()[i]) == 1) {
                inventory.setItem(GuiContents.getGrid()[i], ItemBuilder.build(Material.LIME_DYE, "§c" +
                        GuiContents.getVertical(GuiContents.getGrid()[i]), "§ePunkt"));
            }
            else {
                inventory.setItem(GuiContents.getGrid()[i], ItemBuilder.build(Material.GRAY_DYE, "§c" +
                        GuiContents.getVertical(GuiContents.getGrid()[i]), "§ePunkte"));
            }
        }

        for (int i = 0; i < inventory.getContents().length; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, ItemBuilder.build(Material.GRAY_STAINED_GLASS_PANE, "-", "-"));
            }
        }

        player.openInventory(inventory);
    }
}
