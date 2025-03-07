package me.voten.betonquestitemsadder.objectives;

import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class PickupItem extends ItemObjective {
    public PickupItem(Instruction instruction) throws QuestException {
        super(instruction, "items_to_pickup");
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        ItemStack itemStack = event.getItem().getItemStack();
        handle(itemStack, player);
    }
}
