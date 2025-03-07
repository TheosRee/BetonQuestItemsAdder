package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class BlockPlace extends BlockObjective {
    public BlockPlace(Instruction instruction) throws QuestException {
        super(instruction, "blocks_to_place");
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlaceBlock(CustomBlockPlaceEvent event) {
        handle(event.getNamespacedID(), event.getPlayer());
    }
}
