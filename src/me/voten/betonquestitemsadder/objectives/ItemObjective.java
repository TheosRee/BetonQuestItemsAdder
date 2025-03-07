package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.api.CountingObjective;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.argument.VariableArgument;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemObjective extends CountingObjective implements Listener {
    protected final String itemID;

    public ItemObjective(Instruction instruction, String notifyMessageName) throws QuestException {
        super(instruction, notifyMessageName);
        this.itemID = Validator.existingID(instruction.next());
        this.targetAmount = instruction.get(instruction.getOptional("amount", "1"), VariableArgument.NUMBER_NOT_LESS_THAN_ONE);
    }

    protected void handle(@Nullable ItemStack itemStack, Player player) {
        CustomStack customStack = CustomStack.byItemStack(itemStack);
        if (customStack != null && itemID.equals(customStack.getNamespacedID())) {
            OnlineProfile profile = BetonQuest.getInstance().getProfileProvider().getProfile(player);
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
