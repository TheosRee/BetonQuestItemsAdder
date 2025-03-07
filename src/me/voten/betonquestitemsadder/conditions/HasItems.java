package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.bukkit.inventory.ItemStack;

public class HasItems extends ItemCondition {
    public HasItems(Instruction instruction) throws QuestException {
        super(instruction);
    }

    @Override
    protected Boolean execute(Profile profile) throws QuestException {
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
