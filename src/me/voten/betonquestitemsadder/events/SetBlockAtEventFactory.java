package me.voten.betonquestitemsadder.events;

import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.event.Event;
import org.betonquest.betonquest.api.quest.event.EventFactory;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.variable.location.VariableLocation;
import org.betonquest.betonquest.quest.PrimaryServerThreadData;
import org.betonquest.betonquest.quest.event.PrimaryServerThreadEvent;

/**
 * Factory to {@link SetBlockAt}s from {@link Instruction}s.
 */
public class SetBlockAtEventFactory implements EventFactory {
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
    public Event parseEvent(Instruction instruction) throws QuestException {
        String itemID = Validator.existingID(instruction.next());
        VariableLocation location = instruction.get(VariableLocation::new);
        return new PrimaryServerThreadEvent(new SetBlockAt(itemID, location), data);
    }
}
