package me.voten.betonquestitemsadder;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.item.QuestItem;
import org.betonquest.betonquest.kernel.registry.TypeFactory;

public class ItemFactory implements TypeFactory<QuestItem> {
    @Override
    public QuestItem parseInstruction(Instruction instruction) throws QuestException {
        String itemId = instruction.next();
        CustomStack customStack = CustomStack.getInstance(itemId);
        if (customStack == null) {
            throw new QuestException("Invalid ItemsAdder stack: " + itemId);
        }
        return new ItemsAdderQuestItem(itemId);
    }
}
