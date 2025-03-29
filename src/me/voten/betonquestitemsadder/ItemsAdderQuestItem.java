package me.voten.betonquestitemsadder;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.item.QuestItem;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.List;

public class ItemsAdderQuestItem implements QuestItem {

    private final String itemID;

    public ItemsAdderQuestItem(String itemID) {this.itemID = itemID;}

    @Override
    public String getName() {
        return CustomStack.getInstance(itemID).getDisplayName();
    }

    @Override
    public List<String> getLore() {
        return CustomStack.getInstance(itemID).getItemStack().getItemMeta().getLore();
    }

    @Override
    public ItemStack generate(int stackSize, @Nullable Profile profile) {
        ItemStack itemStack = CustomStack.getInstance(itemID).getItemStack();
        itemStack.setAmount(stackSize);
        return itemStack;
    }

    @Override
    public boolean matches(@Nullable ItemStack item) {
        CustomStack customStack = CustomStack.byItemStack(item);
        if (customStack == null) {
            return false;
        }
        return customStack.getNamespacedID().equals(itemID);
    }
}
