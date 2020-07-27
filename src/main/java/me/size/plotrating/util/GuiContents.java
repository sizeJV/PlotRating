package me.size.plotrating.util;

import lombok.Getter;
import me.size.plotrating.handler.Settings;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;


public class GuiContents {

    @Getter
    private static final HashMap<ItemStack, Integer> defaultContents = new HashMap<>();

    static {
        //CATEGORIES

        defaultContents.put(Settings.ITEM1, 0);
        defaultContents.put(Settings.ITEM2, 9);
        defaultContents.put(Settings.ITEM3, 18);
        defaultContents.put(Settings.ITEM4, 27);
        defaultContents.put(Settings.ITEM5, 36);

        //CONFIRM / CANCEL

        defaultContents.put(ItemBuilder.build(Material.GREEN_CONCRETE, "§aBestätigen", "§eGebe deine Bewertung ab."), 48);
        defaultContents.put(ItemBuilder.build(Material.RED_CONCRETE, "§cAbbrechen", "§eBreche den Bewertungsprozess ab."), 50);
    }

    /**
     * @return = returns Clickable Buttons slots
     */
    public static int[] getGrid() {
        return new int[]{2, 3, 4, 5, 6, 11, 12, 13, 14, 15, 20, 21, 22, 23, 24, 29, 30, 31, 32, 33, 38, 39, 40, 41, 42};
    }


    /**
     * @param i: checked Slot
     * @return = returns Vertical Row
     */
    public static int getVertical(int i) {
        if (i == 2 || i == 11 || i == 20 || i == 29 || i == 38) {
            return 1;
        }
        else if (i == 3 || i == 12 || i == 21 || i == 30 || i == 39) {
            return 2;
        }
        else if (i == 4 || i == 13 || i == 22 || i == 31 || i == 40) {
            return 3;
        }
        else if (i == 5 || i == 14 || i == 23 || i == 32 || i == 41) {
            return 4;
        }
        else if (i == 6 || i == 15 || i == 24 || i == 33 || i == 42) {
            return 5;
        }
        return 0;
    }


    /**
     * @param row: Row of grid
     * @return = gets horizontal row slots
     */
    public static int[] horizontal(int row) {
        switch (row) {
            case 1:
                return new int[]{2, 3, 4, 5, 6};
            case 2:
                return new int[]{11, 12, 13, 14, 15};
            case 3:
                return new int[]{20, 21, 22, 23, 24};
            case 4:
                return new int[]{29, 30, 31, 32, 33};
            case 5:
                return new int[]{38, 39, 40, 41, 42};
            default:
                return new int[]{0};
        }
    }


    /**
     * @param i: checked Slot
     * @return = gets Horizontal row of Grid
     */
    public static int getHorizontal(int i) {
        if (i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
            return 1;
        }
        else if (i == 11 || i == 12 || i == 13 || i == 14 || i == 15) {
            return 2;
        }
        else if (i == 20 || i == 21 || i == 22 || i == 23 || i == 24) {
            return 3;
        }
        else if (i == 29 || i == 30 || i == 31 || i == 32 || i == 33) {
            return 4;
        }
        else if (i == 38 || i == 39 || i == 40 || i == 41 || i == 42) {
            return 5;
        }
        return 0;
    }
}
