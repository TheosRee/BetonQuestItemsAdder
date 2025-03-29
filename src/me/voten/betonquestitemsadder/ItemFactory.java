package me.voten.betonquestitemsadder;

import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.item.QuestItem;
import org.betonquest.betonquest.kernel.registry.TypeFactory;

public class ItemFactory implements TypeFactory<QuestItem> {
    @Override
    public QuestItem parseInstruction(Instruction instruction) throws QuestException {
        return new ItemsAdderQuestItem(Validator.existingID(instruction.next()));
    }
}
