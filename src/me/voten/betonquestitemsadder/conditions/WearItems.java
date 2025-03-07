package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.bukkit.inventory.ItemStack;

public class WearItems extends ItemCondition {
    public WearItems(Instruction instruction) throws QuestException {
        super(instruction);
    }

    @Override
    protected Boolean execute(Profile profile) throws QuestException {
        ItemStack[] armor = getPlayerInventory(profile).getArmorContents();
        for (ItemStack item : armor) {
            if (isItem(item)) {
                return true;
            }
        }
        return false;
    }
}
