package me.voten.betonquestitemsadder;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.quest.QuestException;

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
     * @throws QuestException if ItemsAdder does not hat an item with the id
     */
    public static String existingID(String itemID) throws QuestException {
        CustomStack customStack = CustomStack.getInstance(itemID);
        if (customStack == null) {
            throw new QuestException("Invalid ItemsAdder stack: " + itemID);
        }
        return itemID;
    }
}
