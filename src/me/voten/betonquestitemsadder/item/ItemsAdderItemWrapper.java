package me.voten.betonquestitemsadder.item;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.variable.Variable;
import org.betonquest.betonquest.item.QuestItem;
import org.betonquest.betonquest.item.QuestItemWrapper;

import javax.annotation.Nullable;

public class ItemsAdderItemWrapper implements QuestItemWrapper {
    private final Variable<CustomStack> stack;

    public ItemsAdderItemWrapper(Variable<CustomStack> stack) {
        this.stack = stack;
    }

    @Override
    public QuestItem getItem(@Nullable Profile profile) throws QuestException {
        return new ItemsAdderItem(stack.getValue(profile));
    }
}
