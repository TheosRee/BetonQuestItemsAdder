package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.CustomStackParser;
import org.betonquest.betonquest.api.Objective;
import org.betonquest.betonquest.api.logger.BetonQuestLogger;
import org.betonquest.betonquest.api.logger.BetonQuestLoggerFactory;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.objective.ObjectiveFactory;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.argument.Argument;
import org.betonquest.betonquest.instruction.variable.Variable;

public class BlockBreakObjectiveFactory implements ObjectiveFactory {
    private final BetonQuestLoggerFactory loggerFactory;

    public BlockBreakObjectiveFactory(BetonQuestLoggerFactory loggerFactory) {
        this.loggerFactory = loggerFactory;
    }

    @Override
    public Objective parseInstruction(Instruction instruction) throws QuestException {
        Variable<CustomStack> itemID = instruction.get(CustomStackParser.CUSTOM_STACK_PARSER);
        Variable<Number> targetAmount = instruction.getValue("amount", Argument.NUMBER_NOT_LESS_THAN_ONE, 1);
        BetonQuestLogger log = loggerFactory.create(BlockObjective.class);
        return new BlockBreak(instruction, targetAmount, log, itemID);
    }
}
