package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.CustomStack;
import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import org.betonquest.betonquest.api.logger.BetonQuestLogger;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.variable.Variable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class BlockPlace extends BlockObjective {
    public BlockPlace(Instruction instruction, Variable<Number> targetAmount, BetonQuestLogger log, Variable<CustomStack> itemID)
            throws QuestException {
        super(instruction, targetAmount, "blocks_to_place", log, itemID);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlaceBlock(CustomBlockPlaceEvent event) {
        handle(event.getNamespacedID(), event.getPlayer());
    }
}
