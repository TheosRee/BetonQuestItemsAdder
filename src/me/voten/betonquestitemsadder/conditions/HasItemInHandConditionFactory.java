package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.api.logger.BetonQuestLoggerFactory;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.betonquest.betonquest.quest.PrimaryServerThreadData;

/**
 * Factory to create {@link HasItemInHand}s.
 */
public class HasItemInHandConditionFactory extends ItemConditionFactory {

    /**
     * Create the item in hand condition factory.
     *
     * @param loggerFactory the logger factory
     * @param data          the data used for checking the condition on the main thread
     */
    public HasItemInHandConditionFactory(BetonQuestLoggerFactory loggerFactory, PrimaryServerThreadData data) {
        super(loggerFactory, data);
    }

    @Override
    protected ItemCondition getCondition(String itemID, VariableNumber amount) {
        return new HasItemInHand(itemID, amount);
    }
}
