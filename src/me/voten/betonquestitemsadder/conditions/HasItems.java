package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.bukkit.inventory.ItemStack;

public class HasItems extends ItemCondition {
    public HasItems(String itemID, VariableNumber amount) {
        super(itemID, amount);
    }

    @Override
    public boolean check(OnlineProfile profile) throws QuestException {
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
