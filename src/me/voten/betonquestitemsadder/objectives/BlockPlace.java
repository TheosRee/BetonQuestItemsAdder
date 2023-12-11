package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class BlockPlace extends BlockObjective {
    public BlockPlace(Instruction instruction) throws InstructionParseException {
        super(instruction, "blocks_to_place");
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlaceBlock(CustomBlockPlaceEvent event) {
        handle(event.getNamespacedID(), event.getPlayer(), 1);
    }

}
