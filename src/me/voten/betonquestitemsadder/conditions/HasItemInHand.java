package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.exceptions.QuestRuntimeException;
import org.bukkit.inventory.ItemStack;

public class HasItemInHand extends ItemCondition {
    public HasItemInHand(Instruction instruction) throws InstructionParseException {
        super(instruction);
    }

    @Override
    protected Boolean execute(Profile profile) throws QuestRuntimeException {
        ItemStack hand = getPlayerInventory(profile).getItemInMainHand();

        if (isItem(hand)) {
            int neededAmount = amount.getValue(profile).intValue();
            return hand.getAmount() >= neededAmount;
        }

        return false;
    }

}
