package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.api.QuestEvent;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.variable.location.VariableLocation;
import org.bukkit.Location;

public class SetBlockAt extends QuestEvent {
    private final String itemID;

    private final VariableLocation location;

    public SetBlockAt(Instruction instruction) throws QuestException {
        super(instruction, true);
        staticness = true;
        persistent = true;
        this.itemID = Validator.existingID(instruction.next());
        this.location = instruction.get(VariableLocation::new);
    }

    @Override
    protected Void execute(Profile profile) throws QuestException {
        Location loc = location.getValue(profile);
        CustomStack customStack = CustomStack.getInstance(itemID);
        if (customStack == null) {
            throw new QuestException("Invalid ItemsAdder Item: " + itemID);
        }
        if (!customStack.isBlock()) {
            throw new QuestException("ItemsAdder Item is not a block: " + itemID);
        }
        CustomBlock.place(customStack.getNamespacedID(), loc);
        return null;
    }
}
