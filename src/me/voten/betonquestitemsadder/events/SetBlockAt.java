package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.QuestEvent;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.exceptions.QuestRuntimeException;
import org.betonquest.betonquest.utils.location.CompoundLocation;
import org.bukkit.Location;

public class SetBlockAt extends QuestEvent {
    private final String itemID;

    private final CompoundLocation location;

    public SetBlockAt(Instruction instruction) throws InstructionParseException {
        super(instruction, true);
        staticness = true;
        persistent = true;
        this.itemID = Validator.existingID(instruction.next());
        this.location = instruction.getLocation();
    }

    @Override
    protected Void execute(Profile profile) throws QuestRuntimeException {
        Location loc = location.getLocation(profile);
        CustomStack customStack = CustomStack.getInstance(itemID);
        if (customStack == null) {
            throw new QuestRuntimeException("Invalid ItemsAdder Item: " + itemID);
        }
        if (!customStack.isBlock()) {
            throw new QuestRuntimeException("ItemsAdder Item is not a block: " + itemID);
        }
        CustomBlock.place(customStack.getNamespacedID(), loc);
        return null;
    }

}
