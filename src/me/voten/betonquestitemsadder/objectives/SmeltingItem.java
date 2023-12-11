package me.voten.betonquestitemsadder.objectives;

import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.profiles.OnlineProfile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.utils.PlayerConverter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class SmeltingItem extends ItemObjective implements Listener {
    public SmeltingItem(Instruction instruction) throws InstructionParseException {
        super(instruction, "items_to_smelt");
    }

    @EventHandler
    public void onItemGet(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }
        if (!event.getInventory().getType().equals(InventoryType.FURNACE) && !event.getInventory()
                .getType()
                .equals(InventoryType.BLAST_FURNACE)) {
            return;
        }
        if (event.getRawSlot() != 2) {
            return;
        }
        handle(event.getCurrentItem(), player);
    }

    @EventHandler(ignoreCancelled = true)
    public void onShiftSmelting(InventoryClickEvent event) {
        if (event.getInventory().getType().equals(InventoryType.FURNACE) && event.getRawSlot() == 2 && event.getClick()
                .equals(ClickType.SHIFT_LEFT) && event.getWhoClicked() instanceof Player player) {
            OnlineProfile profile = PlayerConverter.getID(player);
            if (containsPlayer(profile)) {
                event.setCancelled(true);
            }
        }
    }

}
