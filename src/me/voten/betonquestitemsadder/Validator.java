package me.voten.betonquestitemsadder;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.exceptions.InstructionParseException;

/**
 * Util class to get checked values from instruction.
 */
public final class Validator {
    private Validator() {

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
