package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingItem extends ItemObjective implements Listener {

    public CraftingItem(Instruction instruction) throws QuestException {
        super(instruction, "items_to_craft");
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCrafting(CraftItemEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }
        OnlineProfile profile = BetonQuest.getInstance().getProfileProvider().getProfile(player);
        if (!containsPlayer(profile)) {
            return;
        }
        CustomStack customStack = CustomStack.byItemStack(event.getRecipe().getResult());
        if (customStack != null && itemID.equals(customStack.getNamespacedID()) && checkConditions(profile)) {
            int absoluteCreations = countPossibleCrafts(event);
            int remainingSpace = countRemainingSpace(player, customStack.getItemStack());
            getCountingData(profile).progress(Math.min(remainingSpace, absoluteCreations));
            completeIfDoneOrNotify(profile);
        }
    }

    private int countPossibleCrafts(CraftItemEvent event) {
        int possibleCreations = 1;
        if (event.isShiftClick()) {
            possibleCreations = Integer.MAX_VALUE;
            for (ItemStack item : event.getInventory().getMatrix()) {
                if (item != null && !item.getType().equals(Material.AIR)) {
                    possibleCreations = Math.min(possibleCreations, item.getAmount());
                }
            }
        }
        return possibleCreations * event.getRecipe().getResult().getAmount();
    }

    private int countRemainingSpace(Player player, ItemStack item) {
        int remainingSpace = 0;
        for (ItemStack i : player.getInventory().getStorageContents()) {
            if (i == null || i.getType().equals(Material.AIR)) {
                remainingSpace += item.getMaxStackSize();
            } else if (i.equals(item)) {
                remainingSpace += item.getMaxStackSize() - i.getAmount();
            }
        }
        return remainingSpace;
    }
}
