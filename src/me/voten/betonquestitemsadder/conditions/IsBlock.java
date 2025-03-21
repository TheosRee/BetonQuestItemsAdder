package me.voten.betonquestitemsadder.conditions;

import dev.lone.itemsadder.api.CustomBlock;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.condition.nullable.NullableCondition;
import org.betonquest.betonquest.instruction.variable.location.VariableLocation;

import javax.annotation.Nullable;

public class IsBlock implements NullableCondition {
    private final String itemID;

    private final VariableLocation location;

    public IsBlock(String itemID, VariableLocation location) {
        this.itemID = itemID;
        this.location = location;
    }

    @Override
    public boolean check(@Nullable Profile profile) throws QuestException {
        CustomBlock block = CustomBlock.byAlreadyPlaced(location.getValue(profile).getBlock());
        return block != null && block.getCustomStack().getNamespacedID().equals(itemID);
    }
}
