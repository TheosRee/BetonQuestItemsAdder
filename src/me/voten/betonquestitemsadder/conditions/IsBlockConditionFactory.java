package me.voten.betonquestitemsadder.conditions;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.CustomStackParser;
import org.betonquest.betonquest.api.instruction.Instruction;
import org.betonquest.betonquest.api.instruction.argument.Argument;
import org.betonquest.betonquest.api.instruction.variable.Variable;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.condition.PlayerCondition;
import org.betonquest.betonquest.api.quest.condition.PlayerConditionFactory;
import org.betonquest.betonquest.api.quest.condition.PlayerlessCondition;
import org.betonquest.betonquest.api.quest.condition.PlayerlessConditionFactory;
import org.betonquest.betonquest.api.quest.condition.nullable.NullableConditionAdapter;
import org.betonquest.betonquest.quest.PrimaryServerThreadData;
import org.betonquest.betonquest.quest.condition.PrimaryServerThreadPlayerCondition;
import org.betonquest.betonquest.quest.condition.PrimaryServerThreadPlayerlessCondition;
import org.bukkit.Location;

/**
 * Factory to create {@link IsBlock}s from {@link Instruction}s.
 */
public class IsBlockConditionFactory implements PlayerConditionFactory, PlayerlessConditionFactory {

    /**
     * Data used for condition check on the primary server thread.
     */
    private final PrimaryServerThreadData data;

    /**
     * Create the is block condition factory.
     *
     * @param data the data used for checking the condition on the main thread
     */
    public IsBlockConditionFactory(PrimaryServerThreadData data) {
        this.data = data;
    }

    @Override
    public PlayerCondition parsePlayer(Instruction instruction) throws QuestException {
        return new PrimaryServerThreadPlayerCondition(new NullableConditionAdapter(parseInstruction(instruction)), data);
    }

    @Override
    public PlayerlessCondition parsePlayerless(Instruction instruction) throws QuestException {
        return new PrimaryServerThreadPlayerlessCondition(new NullableConditionAdapter(parseInstruction(instruction)), data);
    }

    private IsBlock parseInstruction(Instruction instruction) throws QuestException {
        Variable<CustomStack> itemID = instruction.get(CustomStackParser.CUSTOM_STACK_PARSER);
        Variable<Location> location = instruction.get(Argument.LOCATION);
        return new IsBlock(itemID, location);
    }
}
