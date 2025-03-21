package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.bukkit.inventory.ItemStack;

public class HasItemInHand extends ItemCondition {

    public HasItemInHand(String itemID, VariableNumber amount) {
        super(itemID, amount);
    }

    @Override
    public boolean check(OnlineProfile profile) throws QuestException {
        ItemStack hand = getPlayerInventory(profile).getItemInMainHand();

        if (isItem(hand)) {
            int neededAmount = amount.getValue(profile).intValue();
            return hand.getAmount() >= neededAmount;
        }

        return false;
    }
}
