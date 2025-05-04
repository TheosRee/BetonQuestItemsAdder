package me.voten.betonquestitemsadder.item;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.item.QuestItemSerializer;
import org.bukkit.inventory.ItemStack;

public class ItemSerializer implements QuestItemSerializer {
    @Override
    public String serialize(ItemStack itemStack) throws QuestException {
        if (!itemStack.hasItemMeta()) {
            throw new QuestException("The item is not a ItemsAdder Item!");
        }
        CustomStack customStack = CustomStack.byItemStack(itemStack);
        if (customStack == null) {
            throw new QuestException("The item is not a ItemsAdder Item!");
        }
        return customStack.getNamespacedID();
    }
}
