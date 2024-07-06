package me.voten.betonquestitemsadder.conditions;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.Condition;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class ItemCondition extends Condition {
    protected final String itemID;

    protected final VariableNumber amount;

    public ItemCondition(Instruction instruction) throws InstructionParseException {
        super(instruction, true);
        this.itemID = Validator.existingID(instruction.next());
        this.amount = instruction.getVarNum(instruction.getOptional("amount", "1"), VariableNumber.NOT_LESS_THAN_ONE_CHECKER);
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
