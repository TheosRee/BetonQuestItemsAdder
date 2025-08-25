package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.api.CountingObjective;
import org.betonquest.betonquest.api.instruction.Instruction;
import org.betonquest.betonquest.api.instruction.variable.Variable;
import org.betonquest.betonquest.api.logger.BetonQuestLogger;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class BlockObjective extends CountingObjective implements Listener {
    protected final Variable<CustomStack> itemID;

    private final BetonQuestLogger log;

    public BlockObjective(Instruction instruction, Variable<Number> targetAmount, String message, BetonQuestLogger log,
            Variable<CustomStack> itemID) throws QuestException {
        super(instruction, targetAmount, message);
        this.log = log;
        this.itemID = itemID;
    }

    protected void handle(String namespacedID, Player player) {
        OnlineProfile profile = BetonQuest.getInstance().getProfileProvider().getProfile(player);
        try {
            if (containsPlayer(profile) && itemID.getValue(profile).getNamespacedID().equals(namespacedID) && checkConditions(profile)) {
                getCountingData(profile).progress();
                completeIfDoneOrNotify(profile);
            }
        } catch (QuestException e) {
            log.warn("Could not resolve Item Variable in objective '" + instruction.getID() + "': " + e.getMessage(), e);
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
