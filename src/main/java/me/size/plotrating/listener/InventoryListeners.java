package me.size.plotrating.listener;

import me.size.plotrating.handler.ActionHandler;
import me.size.plotrating.handler.PostRating;
import me.size.plotrating.util.GuiContents;
import me.size.plotrating.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;


public class InventoryListeners implements Listener {

    private final ActionHandler action = new ActionHandler();


    @EventHandler
    public void onInteract(InventoryInteractEvent event) {
        if (!event.getView().getTitle().equalsIgnoreCase("§aPlot-Rating")) {
            return;
        }
        event.setCancelled(true);
    }


    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equalsIgnoreCase("§aPlot-Rating") || event.getClickedInventory() == null
                || event.getClickedInventory() == event.getWhoClicked().getInventory()) {
            return;
        }

        event.setCancelled(true);
        switch (action.getConfirmation(Objects.requireNonNull(event.getCurrentItem()).getType())) {
            case APPLY: {
                int score = 0;
                for (int i = event.getClickedInventory().getContents().length - 1; i > 0; i--) {
                    if (event.getClickedInventory().getContents()[i].getType() == Material.LIME_DYE) {
                        score = score + Integer.parseInt((Objects.requireNonNull(event.getClickedInventory()
                                .getContents()[i].getItemMeta())).getDisplayName().replaceAll("§c", ""));
                    }
                }
                PostRating postRating = new PostRating();
                postRating.setScore((Player) event.getWhoClicked(), score);
                event.getWhoClicked().closeInventory();
                return;
            }
            case NONE:

            case ACTIVE:

                return;

            case CLOSE:
                event.getWhoClicked().closeInventory();
                return;
            case INACTIVE:
                event.getClickedInventory().setContents(setActive(event.getClickedInventory(), event.getSlot()).getContents());

                event.getClickedInventory().setItem(event.getSlot(), ItemBuilder.build(Material.LIME_DYE, "§c" +
                        GuiContents.getVertical(event.getSlot()), "§eScore"));
        }
    }


    /**
     * @param inventory = GUI inventory
     * @param slot = Slot to be Activated
     * @return = returns changed inventory
     */
    public Inventory setActive(Inventory inventory, int slot) {
        int[] row = GuiContents.horizontal(GuiContents.getHorizontal(slot));

        for (int i = row.length - 1; i >= 0; i--) {
            if (action.getConfirmation(Objects.requireNonNull(inventory.getItem(row[i])).getType()) == ActionHandler.Action.ACTIVE) {
                inventory.setItem(row[i], ItemBuilder.build(Material.GRAY_DYE, "§c" +
                        GuiContents.getVertical(row[i]), "§eScore"));
            }
        }
        return inventory;
    }
}
