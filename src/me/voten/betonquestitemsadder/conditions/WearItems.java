package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.exceptions.QuestRuntimeException;
import org.bukkit.inventory.ItemStack;

public class WearItems extends ItemCondition {
    public WearItems(Instruction instruction) throws InstructionParseException {
        super(instruction);
    }

    @Override
    protected Boolean execute(Profile profile) throws QuestRuntimeException {
        ItemStack[] armor = getPlayerInventory(profile).getArmorContents();
        for (ItemStack item : armor) {
            if (isItem(item)) {
                return true;
            }
        }
        return false;
    }

}
