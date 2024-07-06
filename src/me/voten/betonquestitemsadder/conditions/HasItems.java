package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.exceptions.QuestRuntimeException;
import org.bukkit.inventory.ItemStack;

public class HasItems extends ItemCondition {
    public HasItems(Instruction instruction) throws InstructionParseException {
        super(instruction);
    }

    @Override
    protected Boolean execute(Profile profile) throws QuestRuntimeException {
        ItemStack[] inventoryItems = getPlayerInventory(profile).getContents();
        int neededAmount = amount.getValue(profile).intValue();
        int actualAmount = 0;

        for (ItemStack item : inventoryItems) {
            if (isItem(item)) {
                actualAmount += item.getAmount();
                if (actualAmount >= neededAmount) {
                    return true;
                }
            }
        }
        return false;
    }

}
