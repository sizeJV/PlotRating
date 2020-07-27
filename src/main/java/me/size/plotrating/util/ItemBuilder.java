package me.size.plotrating.util;

import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;


@NoArgsConstructor
public class ItemBuilder {

    public static ItemStack build(Material material, String displayName, String itemLore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(Collections.singletonList(itemLore));

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
