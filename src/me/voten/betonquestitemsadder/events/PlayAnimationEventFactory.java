package me.voten.betonquestitemsadder.events;

import org.betonquest.betonquest.api.instruction.Instruction;
import org.betonquest.betonquest.api.instruction.argument.Argument;
import org.betonquest.betonquest.api.instruction.variable.Variable;
import org.betonquest.betonquest.api.logger.BetonQuestLoggerFactory;
import org.betonquest.betonquest.api.quest.PrimaryServerThreadData;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.event.PlayerEvent;
import org.betonquest.betonquest.api.quest.event.PlayerEventFactory;
import org.betonquest.betonquest.api.quest.event.online.OnlineEventAdapter;
import org.betonquest.betonquest.api.quest.event.thread.PrimaryServerThreadEvent;

/**
 * Factory to {@link PlayAnimation}s from {@link Instruction}s.
 */
public class PlayAnimationEventFactory implements PlayerEventFactory {
    /**
     * Logger factory to create a logger for events.
     */
    private final BetonQuestLoggerFactory loggerFactory;

    /**
     * Data for primary server thread access.
     */
    private final PrimaryServerThreadData data;

    /**
     * Create the play animation event factory.
     *
     * @param loggerFactory logger factory to use
     * @param data          the data for primary server thread access
     */
    public PlayAnimationEventFactory(BetonQuestLoggerFactory loggerFactory, PrimaryServerThreadData data) {
        this.loggerFactory = loggerFactory;
        this.data = data;
    }

    @Override
    public PlayerEvent parsePlayer(Instruction instruction) throws QuestException {
        Variable<String> animation = instruction.get(Argument.STRING);
        return new PrimaryServerThreadEvent(new OnlineEventAdapter(
                new PlayAnimation(animation),
                loggerFactory.create(PlayAnimation.class),
                instruction.getPackage()
        ), data);
    }
}
