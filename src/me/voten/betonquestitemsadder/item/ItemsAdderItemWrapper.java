package me.voten.betonquestitemsadder.item;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.variable.Variable;
import org.betonquest.betonquest.item.QuestItem;
import org.betonquest.betonquest.item.QuestItemWrapper;

public class ItemsAdderItemWrapper implements QuestItemWrapper {
    private final Variable<CustomStack> itemId;

    public ItemsAdderItemWrapper(Variable<CustomStack> itemId) {this.itemId = itemId;}

    @Override
    public QuestItem getItem(Profile profile) throws QuestException {
        return new ItemsAdderItem(itemId.getValue(profile));
    }
}
