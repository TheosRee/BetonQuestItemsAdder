package me.voten.betonquestitemsadder.item;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.CustomStackParser;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.variable.Variable;
import org.betonquest.betonquest.item.QuestItemWrapper;
import org.betonquest.betonquest.kernel.registry.TypeFactory;

public class ItemFactory implements TypeFactory<QuestItemWrapper> {
    @Override
    public QuestItemWrapper parseInstruction(Instruction instruction) throws QuestException {
        Variable<CustomStack> itemId = instruction.get(CustomStackParser.CUSTOM_STACK_PARSER);
        return new ItemsAdderItemWrapper(itemId);
    }
}
