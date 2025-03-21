package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.ItemsAdder;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.quest.event.online.OnlineEvent;

public class PlayAnimation implements OnlineEvent {
    private final String name;

    public PlayAnimation(String animation) {
        this.name = animation;
    }

    @Override
    public void execute(OnlineProfile profile) {
        ItemsAdder.playTotemAnimation(profile.getPlayer(), name);
    }
}
