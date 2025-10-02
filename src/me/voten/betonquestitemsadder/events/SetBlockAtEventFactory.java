package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.CustomStackParser;
import org.betonquest.betonquest.api.instruction.Instruction;
import org.betonquest.betonquest.api.instruction.argument.Argument;
import org.betonquest.betonquest.api.instruction.variable.Variable;
import org.betonquest.betonquest.api.quest.PrimaryServerThreadData;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.event.PlayerEvent;
import org.betonquest.betonquest.api.quest.event.PlayerEventFactory;
import org.betonquest.betonquest.api.quest.event.thread.PrimaryServerThreadEvent;
import org.bukkit.Location;

/**
 * Factory to {@link SetBlockAt}s from {@link Instruction}s.
 */
public class SetBlockAtEventFactory implements PlayerEventFactory {
    /**
     * Data for primary server thread access.
     */
    private final PrimaryServerThreadData data;

    /**
     * Create the set block at event factory.
     *
     * @param data the data for primary server thread access
     */
    public SetBlockAtEventFactory(PrimaryServerThreadData data) {
        this.data = data;
    }

    @Override
    public PlayerEvent parsePlayer(Instruction instruction) throws QuestException {
        Variable<CustomStack> itemID = instruction.get(CustomStackParser.CUSTOM_STACK_PARSER);
        Variable<Location> location = instruction.get(Argument.LOCATION);
        return new PrimaryServerThreadEvent(new SetBlockAt(itemID, location), data);
    }
}
