package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.Events.CustomBlockBreakEvent;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class BlockBreak extends BlockObjective {
    public BlockBreak(Instruction instruction) throws InstructionParseException {
        super(instruction, "blocks_to_break");
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onBlockBreak(CustomBlockBreakEvent event) {
        handle(event.getNamespacedID(), event.getPlayer(), 1);
    }

}
