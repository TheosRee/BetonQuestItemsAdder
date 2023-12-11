package me.voten.betonquestitemsadder.conditions;

import dev.lone.itemsadder.api.CustomBlock;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.Condition;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.exceptions.QuestRuntimeException;
import org.betonquest.betonquest.utils.location.CompoundLocation;

public class IsBlock extends Condition {
    protected final String itemID;

    protected final CompoundLocation location;

    public IsBlock(Instruction instruction) throws InstructionParseException {
        super(instruction, true);
        staticness = true;
        persistent = true;
        this.itemID = instruction.next();
        this.location = instruction.getLocation();
    }

    @Override
    protected Boolean execute(Profile profile) throws QuestRuntimeException {
        CustomBlock block = CustomBlock.byAlreadyPlaced(location.getLocation(profile).getBlock());
        if (block != null) {
            return block.getCustomStack().getNamespacedID().equals(itemID);
        }

        return false;
    }

}
