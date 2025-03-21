package me.voten.betonquestitemsadder.conditions;

import org.betonquest.betonquest.api.logger.BetonQuestLoggerFactory;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.betonquest.betonquest.quest.PrimaryServerThreadData;

/**
 * Factory to create {@link WearItems}'.
 */
public class WearItemsConditionFactory extends ItemConditionFactory {
    /**
     * Create the wear items factory.
     *
     * @param loggerFactory the logger factory
     * @param data          the data used for checking the condition on the main thread
     */
    public WearItemsConditionFactory(BetonQuestLoggerFactory loggerFactory, PrimaryServerThreadData data) {
        super(loggerFactory, data);
    }

    @Override
    protected ItemCondition getCondition(String itemID, VariableNumber amount) {
        return new WearItems(itemID, amount);
    }
}
