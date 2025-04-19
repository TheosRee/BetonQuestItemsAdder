package me.voten.betonquestitemsadder.objectives;

import me.voten.betonquestitemsadder.VariableCustomStack;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.api.CountingObjective;
import org.betonquest.betonquest.api.logger.BetonQuestLogger;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.variable.VariableNumber;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class BlockObjective extends CountingObjective implements Listener {
    protected final VariableCustomStack itemID;

    private final BetonQuestLogger log;

    public BlockObjective(Instruction instruction, VariableNumber targetAmount, String message, BetonQuestLogger log,
            VariableCustomStack itemID) throws QuestException {
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
            log.warn("Could not resolve Item Variable: " + e.getMessage(), e);
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
