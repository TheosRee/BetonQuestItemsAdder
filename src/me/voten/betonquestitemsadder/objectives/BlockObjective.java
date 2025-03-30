package me.voten.betonquestitemsadder.objectives;

import me.voten.betonquestitemsadder.VariableCustomStack;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.api.CountingObjective;
import org.betonquest.betonquest.api.logger.BetonQuestLogger;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.betonquest.betonquest.instruction.argument.VariableArgument;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class BlockObjective extends CountingObjective implements Listener {
    protected final VariableCustomStack itemID;

    private final BetonQuestLogger log;

    public BlockObjective(Instruction instruction, String notifyMessageName) throws QuestException {
        super(instruction, notifyMessageName);
        this.itemID = instruction.get(VariableCustomStack::new);
        this.targetAmount = instruction.get(instruction.getOptional("amount", "1"), VariableArgument.NUMBER_NOT_LESS_THAN_ONE);
        this.log = BetonQuest.getInstance().getLoggerFactory().create(getClass());
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
