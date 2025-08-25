package me.voten.betonquestitemsadder;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.instruction.argument.Argument;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.util.Utils;

/**
 * Parses a string to a {@link CustomStack}.
 */
public class CustomStackParser implements Argument<CustomStack> {
    /**
     * The default instance of {@link CustomStackParser}.
     */
    public static final CustomStackParser CUSTOM_STACK_PARSER = new CustomStackParser();

    @Override
    public CustomStack apply(String value) throws QuestException {
        return Utils.getNN(CustomStack.getInstance(value), "Invalid ItemsAdder Item: " + value);
    }
}
