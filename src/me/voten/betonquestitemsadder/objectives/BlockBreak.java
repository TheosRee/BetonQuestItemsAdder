package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.CustomStack;
import dev.lone.itemsadder.api.Events.CustomBlockBreakEvent;
import org.betonquest.betonquest.api.instruction.Instruction;
import org.betonquest.betonquest.api.instruction.variable.Variable;
import org.betonquest.betonquest.api.quest.QuestException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class BlockBreak extends BlockObjective {

    public BlockBreak(Instruction instruction, Variable<Number> targetAmount,
            Variable<CustomStack> itemID) throws QuestException {
        super(instruction, targetAmount, "blocks_to_break", itemID);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onBlockBreak(CustomBlockBreakEvent event) {
        handle(event.getNamespacedID(), event.getPlayer());
    }
}
