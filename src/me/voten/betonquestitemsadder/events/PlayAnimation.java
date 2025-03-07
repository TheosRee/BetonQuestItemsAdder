package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.ItemsAdder;
import org.betonquest.betonquest.api.QuestEvent;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;

public class PlayAnimation extends QuestEvent {
    private final String name;

    public PlayAnimation(Instruction instruction) throws QuestException {
        super(instruction, true);
        this.name = instruction.next();
    }

    @Override
    protected Void execute(Profile profile) throws QuestException {
        ItemsAdder.playTotemAnimation(profile.getOnlineProfile().orElseThrow().getPlayer(), name);
        return null;
    }
}
