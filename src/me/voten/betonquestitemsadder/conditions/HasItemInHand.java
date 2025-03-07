package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.bukkit.inventory.ItemStack;

public class HasItemInHand extends ItemCondition {
    public HasItemInHand(Instruction instruction) throws QuestException {
        super(instruction);
    }

    @Override
    protected Boolean execute(Profile profile) throws QuestException {
        ItemStack hand = getPlayerInventory(profile).getItemInMainHand();

        if (isItem(hand)) {
            int neededAmount = amount.getValue(profile).intValue();
            return hand.getAmount() >= neededAmount;
        }

        return false;
    }
}
