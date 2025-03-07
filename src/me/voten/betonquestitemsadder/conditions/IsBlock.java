package me.voten.betonquestitemsadder.conditions;

import dev.lone.itemsadder.api.CustomBlock;
import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.api.Condition;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.variable.location.VariableLocation;

public class IsBlock extends Condition {
    protected final String itemID;

    protected final VariableLocation location;

    public IsBlock(Instruction instruction) throws QuestException {
        super(instruction, true);
        staticness = true;
        persistent = true;
        this.itemID = Validator.existingID(instruction.next());
        this.location = instruction.get(VariableLocation::new);
    }

    @Override
    protected Boolean execute(Profile profile) throws QuestException {
        CustomBlock block = CustomBlock.byAlreadyPlaced(location.getValue(profile).getBlock());
        return block != null && block.getCustomStack().getNamespacedID().equals(itemID);
    }
}
