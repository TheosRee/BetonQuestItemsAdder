package me.voten.betonquestitemsadder;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.VariableNumber;
import org.betonquest.betonquest.exceptions.InstructionParseException;

/**
 * Util class to get checked values from instruction.
 */
public final class Validator {
    private Validator() {

    }

    /**
     * Gets a new variable number with "amount" as key
     *
     * @param instruction to get value from
     * @return the new number
     * @throws InstructionParseException if number is explicit less than one
     */
    public static VariableNumber notLessThanOne(Instruction instruction) throws InstructionParseException {
        VariableNumber number = instruction.getVarNum(instruction.getOptional("amount", "1"));
        if (number.isExplicitLessThanOne()) {
            throw new InstructionParseException("Amount cannot be less than 1");
        }
        return number;
    }

    /**
     * Checks if the given id represents a valid ItemsAdder item
     *
     * @param itemID to check
     * @return the id
     * @throws InstructionParseException if ItemsAdder does not hat an item with the id
     */
    public static String existingID(String itemID) throws InstructionParseException {
        CustomStack customStack = CustomStack.getInstance(itemID);
        if (customStack == null) {
            throw new InstructionParseException("Invalid ItemsAdder stack: " + itemID);
        }
        return itemID;
    }
}
