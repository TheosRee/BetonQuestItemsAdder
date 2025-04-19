package me.voten.betonquestitemsadder.objectives;

import me.voten.betonquestitemsadder.VariableCustomStack;
import org.betonquest.betonquest.api.Objective;
import org.betonquest.betonquest.api.logger.BetonQuestLogger;
import org.betonquest.betonquest.api.logger.BetonQuestLoggerFactory;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.objective.ObjectiveFactory;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.argument.VariableArgument;
import org.betonquest.betonquest.instruction.variable.VariableNumber;

public class BlockBreakObjectiveFactory implements ObjectiveFactory {
    private final BetonQuestLoggerFactory loggerFactory;

    public BlockBreakObjectiveFactory(BetonQuestLoggerFactory loggerFactory) {
        this.loggerFactory = loggerFactory;
    }

    @Override
    public Objective parseInstruction(Instruction instruction) throws QuestException {
        VariableCustomStack itemID = instruction.get(VariableCustomStack::new);
        VariableNumber targetAmount = instruction.get(instruction.getOptional("amount", "1"), VariableArgument.NUMBER_NOT_LESS_THAN_ONE);
        BetonQuestLogger log = loggerFactory.create(BlockObjective.class);
        return new BlockBreak(instruction, targetAmount, log, itemID);
    }
}
