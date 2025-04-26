package me.voten.betonquestitemsadder.conditions;

import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.condition.nullable.NullableCondition;
import org.betonquest.betonquest.instruction.variable.Variable;
import org.bukkit.Location;

import javax.annotation.Nullable;

public class IsBlock implements NullableCondition {
    private final Variable<CustomStack> itemID;

    private final Variable<Location> location;

    public IsBlock(Variable<CustomStack> itemID, Variable<Location> location) {
        this.itemID = itemID;
        this.location = location;
    }

    @Override
    public boolean check(@Nullable Profile profile) throws QuestException {
        CustomBlock block = CustomBlock.byAlreadyPlaced(location.getValue(profile).getBlock());
        return block != null && block.getCustomStack().matchNamespacedID(itemID.getValue(profile));
    }
}
