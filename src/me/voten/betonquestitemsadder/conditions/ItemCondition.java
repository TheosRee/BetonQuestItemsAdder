package me.voten.betonquestitemsadder.conditions;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.VariableNumber;
import org.betonquest.betonquest.api.Condition;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public abstract class ItemCondition extends Condition {
    protected final String itemID;

    protected final VariableNumber amount;

    public ItemCondition(Instruction instruction) throws InstructionParseException {
        super(instruction, true);
        this.itemID = Validator.existingID(instruction.next());
        this.amount = Validator.notLessThanOne(instruction);
    }

    protected PlayerInventory getPlayerInventory(Profile profile) {
        return profile.getOnlineProfile().orElseThrow().getPlayer().getInventory();
    }

    protected boolean isItem(ItemStack itemStack) {
        CustomStack customStack = CustomStack.byItemStack(itemStack);
        return customStack.getNamespacedID().equals(itemID);
    }

}
