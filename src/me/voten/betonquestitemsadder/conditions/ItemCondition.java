package me.voten.betonquestitemsadder.conditions;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.api.Condition;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.argument.VariableArgument;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class ItemCondition extends Condition {
    protected final String itemID;

    protected final VariableNumber amount;

    public ItemCondition(Instruction instruction) throws QuestException {
        super(instruction, true);
        this.itemID = Validator.existingID(instruction.next());
        this.amount = instruction.get(instruction.getOptional("amount", "1"), VariableArgument.NUMBER_NOT_LESS_THAN_ONE);
    }

    protected PlayerInventory getPlayerInventory(Profile profile) {
        return profile.getOnlineProfile().orElseThrow().getPlayer().getInventory();
    }

    protected boolean isItem(@Nullable ItemStack itemStack) {
        CustomStack customStack = CustomStack.byItemStack(itemStack);
        if (customStack == null) {
            return false;
        }
        return customStack.getNamespacedID().equals(itemID);
    }
}
