package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.event.Event;
import org.betonquest.betonquest.instruction.variable.location.VariableLocation;
import org.bukkit.Location;

public class SetBlockAt implements Event {
    private final String itemID;

    private final VariableLocation location;

    public SetBlockAt(String itemID, VariableLocation location) {
        this.itemID = itemID;
        this.location = location;
    }

    @Override
    public void execute(Profile profile) throws QuestException {
        Location loc = location.getValue(profile);
        CustomStack customStack = CustomStack.getInstance(itemID);
        if (customStack == null) {
            throw new QuestException("Invalid ItemsAdder Item: " + itemID);
        }
        if (!customStack.isBlock()) {
            throw new QuestException("ItemsAdder Item is not a block: " + itemID);
        }
        CustomBlock.place(customStack.getNamespacedID(), loc);
    }
}
