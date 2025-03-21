package me.voten.betonquestitemsadder.events;

import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.api.logger.BetonQuestLoggerFactory;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.event.Event;
import org.betonquest.betonquest.api.quest.event.EventFactory;
import org.betonquest.betonquest.api.quest.event.online.OnlineEventAdapter;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.argument.VariableArgument;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.betonquest.betonquest.quest.PrimaryServerThreadData;
import org.betonquest.betonquest.quest.event.PrimaryServerThreadEvent;

/**
 * Factory to create {@link ItemEvent}s from {@link Instruction}s.
 */
public class ItemEventFactory implements EventFactory {
    /**
     * Logger factory to create a logger for events.
     */
    private final BetonQuestLoggerFactory loggerFactory;

    /**
     * Data for primary server thread access.
     */
    private final PrimaryServerThreadData data;

    /**
     * Create the item event factory.
     *
     * @param loggerFactory logger factory to use
     * @param data          the data for primary server thread access
     */
    public ItemEventFactory(BetonQuestLoggerFactory loggerFactory, PrimaryServerThreadData data) {
        this.loggerFactory = loggerFactory;
        this.data = data;
    }

    @Override
    public Event parseEvent(Instruction instruction) throws QuestException {
        ItemEvent.Action action = instruction.getEnum(ItemEvent.Action.class);
        String itemID = Validator.existingID(instruction.next());
        VariableNumber amount = instruction.get(instruction.getOptional("amount", "1"), VariableArgument.NUMBER_NOT_LESS_THAN_ONE);
        return new PrimaryServerThreadEvent(new OnlineEventAdapter(
                new ItemEvent(itemID, amount, action),
                loggerFactory.create(ItemEvent.class),
                instruction.getPackage()
        ), data);
    }
}
