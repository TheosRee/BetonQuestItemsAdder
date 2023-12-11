package me.voten.betonquestitemsadder.objectives;

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

public class BlockObjective extends CountingObjective implements Listener {
    protected final String itemID;

    public BlockObjective(Instruction instruction, String notifyMessageName) throws InstructionParseException {
        super(instruction, notifyMessageName);
        this.itemID = instruction.next();
        this.targetAmount = instruction.getVarNum();
    }

    protected void handle(String namespacedID, Player player, int amount) {
        if (itemID.equals(namespacedID)) {
            OnlineProfile profile = PlayerConverter.getID(player);
            if (containsPlayer(profile) && checkConditions(profile)) {
                getCountingData(profile).progress(amount);
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