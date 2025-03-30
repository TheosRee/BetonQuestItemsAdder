package me.voten.betonquestitemsadder;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.config.quest.QuestPackage;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.variable.Variable;
import org.betonquest.betonquest.kernel.processor.quest.VariableProcessor;
import org.betonquest.betonquest.util.Utils;

public class VariableCustomStack extends Variable<CustomStack> {
    /**
     * Resolves a string that may contain variables to a variable of the given type.
     *
     * @param variableProcessor the processor to create the variables
     * @param pack              the package in which the variable is used in
     * @param input             the string that may contain variables
     * @throws QuestException if the variables could not be created or resolved to the given type
     */
    public VariableCustomStack(VariableProcessor variableProcessor, QuestPackage pack, String input)
            throws QuestException {
        super(variableProcessor, pack, input, value -> Utils.getNN(CustomStack.getInstance(value),
                "Invalid ItemsAdder Item: " + value));
    }
}
