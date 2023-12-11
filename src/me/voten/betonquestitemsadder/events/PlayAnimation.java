package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.ItemsAdder;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.QuestEvent;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.exceptions.QuestRuntimeException;

public class PlayAnimation extends QuestEvent {
    private final String name;
    
    public PlayAnimation(Instruction instruction) throws InstructionParseException {
        super(instruction, true);
        this.name = instruction.next();
    }

    @Override
    protected Void execute(Profile profile) throws QuestRuntimeException {
        ItemsAdder.playTotemAnimation(profile.getOnlineProfile().orElseThrow().getPlayer(), name);
        return null;
    }

}
