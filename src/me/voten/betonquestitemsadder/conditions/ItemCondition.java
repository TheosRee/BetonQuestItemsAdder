package me.voten.betonquestitemsadder.conditions;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.condition.online.OnlineCondition;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class ItemCondition implements OnlineCondition {
    protected final String itemID;

    protected final VariableNumber amount;

    public ItemCondition(String itemID, VariableNumber amount) {
        this.itemID = itemID;
        this.amount = amount;
    }

    protected PlayerInventory getPlayerInventory(OnlineProfile profile) {
        return profile.getPlayer().getInventory();
    }

    protected boolean isItem(@Nullable ItemStack itemStack) {
        CustomStack customStack = CustomStack.byItemStack(itemStack);
        if (customStack == null) {
            return false;
        }
        return customStack.getNamespacedID().equals(itemID);
    }
}
