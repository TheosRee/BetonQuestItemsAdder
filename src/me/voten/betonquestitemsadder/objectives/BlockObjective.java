package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.api.CountingObjective;
import org.betonquest.betonquest.api.instruction.Instruction;
import org.betonquest.betonquest.api.instruction.variable.Variable;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class BlockObjective extends CountingObjective implements Listener {
    protected final Variable<CustomStack> itemID;

    public BlockObjective(Instruction instruction, Variable<Number> targetAmount, String message,
            Variable<CustomStack> itemID) throws QuestException {
        super(instruction, targetAmount, message);
        this.itemID = itemID;
    }

    protected void handle(String namespacedID, Player player) {
        OnlineProfile profile = profileProvider.getProfile(player);
        qeHandler.handle(() -> {
            if (containsPlayer(profile) && itemID.getValue(profile).getNamespacedID().equals(namespacedID) && checkConditions(profile)) {
                getCountingData(profile).progress();
                completeIfDoneOrNotify(profile);
            }
        });
    }
}
