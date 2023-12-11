package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.CountingObjective;
import org.betonquest.betonquest.api.profiles.OnlineProfile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.utils.PlayerConverter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class ItemObjective extends CountingObjective implements Listener {
    protected final String itemID;

    public ItemObjective(Instruction instruction, String notifyMessageName) throws InstructionParseException {
        super(instruction, notifyMessageName);
        this.itemID = Validator.existingID(instruction.next());
        this.targetAmount = Validator.notLessThanOne(instruction);
    }

    protected void handle(ItemStack itemStack, Player player) {
        CustomStack customStack = CustomStack.byItemStack(itemStack);
        if (customStack != null && itemID.equals(customStack.getNamespacedID())) {
            OnlineProfile profile = PlayerConverter.getID(player);
            if (containsPlayer(profile) && checkConditions(profile)) {
                getCountingData(profile).progress(itemStack.getAmount());
                completeIfDoneOrNotify(profile);
            }
        }
    }

    @Override
    public void start() {
        Bukkit.getPluginManager().registerEvents(this, BetonQuest.getInstance());
    }

    @Override
    public void stop() {
        HandlerList.unregisterAll(this);
    }

}