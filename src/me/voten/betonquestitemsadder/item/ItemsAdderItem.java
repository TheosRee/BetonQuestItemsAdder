package me.voten.betonquestitemsadder.item;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.item.QuestItem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemsAdderItem implements QuestItem {

    private final CustomStack stack;

    public ItemsAdderItem(CustomStack stack) {
        this.stack = stack;
    }

    @Override
    public ItemStack generate(int stackSize, @Nullable Profile profile) {
        ItemStack itemStack = stack.getItemStack().clone();
        itemStack.setAmount(stackSize);
        return itemStack;
    }

    @Override
    public boolean matches(@Nullable ItemStack item) {
        CustomStack customStack = CustomStack.byItemStack(item);
        if (customStack == null) {
            return false;
        }
        return customStack.getNamespacedID().equals(stack.getNamespacedID());
    }

    @Override
    public String getName() {
        return stack.getDisplayName();
    }

    @Override
    public List<String> getLore() {
        ItemStack itemStack = stack.getItemStack();
        if (itemStack.hasItemMeta()) {
            ItemMeta meta = itemStack.getItemMeta();
            if (meta.hasLore()) {
                return meta.getLore();
            }
        }
        return new ArrayList<>(0);
    }
}
