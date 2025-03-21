package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.bukkit.inventory.ItemStack;

public class WearItems extends ItemCondition {

    public WearItems(String itemID, VariableNumber amount) {
        super(itemID, amount);
    }

    @Override
    public boolean check(OnlineProfile profile) {
        ItemStack[] armor = getPlayerInventory(profile).getArmorContents();
        for (ItemStack item : armor) {
            if (isItem(item)) {
                return true;
            }
        }
        return false;
    }
}
