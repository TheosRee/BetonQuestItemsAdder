package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.ItemsAdder;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.event.online.OnlineEvent;
import org.betonquest.betonquest.instruction.variable.VariableString;

public class PlayAnimation implements OnlineEvent {
    private final VariableString name;

    public PlayAnimation(VariableString animation) {
        this.name = animation;
    }

    @Override
    public void execute(OnlineProfile profile) throws QuestException {
        ItemsAdder.playTotemAnimation(profile.getPlayer(), name.getValue(profile));
    }
}
