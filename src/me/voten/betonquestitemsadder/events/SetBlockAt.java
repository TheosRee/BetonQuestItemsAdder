package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.VariableCustomStack;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.event.PlayerEvent;
import org.betonquest.betonquest.instruction.variable.location.VariableLocation;
import org.bukkit.Location;

public class SetBlockAt implements PlayerEvent {
    private final VariableCustomStack itemID;

    private final VariableLocation location;

    public SetBlockAt(VariableCustomStack itemID, VariableLocation location) {
        this.itemID = itemID;
        this.location = location;
    }

    @Override
    public void execute(Profile profile) throws QuestException {
        Location loc = location.getValue(profile);
        CustomStack customStack = itemID.getValue(profile);
        if (!customStack.isBlock()) {
            throw new QuestException("ItemsAdder Item is not a block: " + itemID);
        }
        CustomBlock.place(customStack.getNamespacedID(), loc);
    }
}
