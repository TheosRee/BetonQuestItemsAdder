package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.ItemsAdder;
import org.betonquest.betonquest.api.instruction.variable.Variable;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.api.quest.event.online.OnlineEvent;

public class PlayAnimation implements OnlineEvent {
    private final Variable<String> name;

    public PlayAnimation(Variable<String> animation) {
        this.name = animation;
    }

    @Override
    public void execute(OnlineProfile profile) throws QuestException {
        ItemsAdder.playTotemAnimation(profile.getPlayer(), name.getValue(profile));
    }
}
