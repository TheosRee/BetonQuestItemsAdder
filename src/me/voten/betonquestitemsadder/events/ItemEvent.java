package me.voten.betonquestitemsadder.events;

import dev.lone.itemsadder.api.CustomStack;
import me.voten.betonquestitemsadder.Validator;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.VariableNumber;
import org.betonquest.betonquest.api.QuestEvent;
import org.betonquest.betonquest.api.profiles.Profile;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.exceptions.QuestRuntimeException;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Map;

public class ItemEvent extends QuestEvent {
    private final String itemID;

    private final VariableNumber amount;

    private final Action action;

    public ItemEvent(Instruction instruction) throws InstructionParseException {
        super(instruction, true);
        this.action = instruction.getEnum(Action.class);
        this.itemID = Validator.existingID(instruction.next());
        this.amount = Validator.notLessThanOne(instruction);
    }

    @Override
    protected Void execute(Profile profile) throws QuestRuntimeException {
        CustomStack customStack = CustomStack.getInstance(itemID);
        if (customStack == null) {
            throw new QuestRuntimeException("Invalid ItemsAdder Item: " + itemID);
        }
        ItemStack itemStack = customStack.getItemStack();
        itemStack.setAmount(amount.getInt(profile));
        Player player = profile.getOnlineProfile().orElseThrow().getPlayer();
        PlayerInventory inventory = player.getInventory();
        switch (action) {
            case ADD -> {
                Map<Integer, ItemStack> tooMuch = inventory.addItem(itemStack);
                if (!tooMuch.isEmpty()) {
                    Location location = player.getLocation();
                    World world = location.getWorld();
                    for (Map.Entry<Integer, ItemStack> entry : tooMuch.entrySet()) {
                        ItemStack item = entry.getValue();
                        item.setAmount(entry.getKey());
                        world.dropItem(location, item);
                    }
                }
            }
            case REMOVE -> inventory.removeItem(itemStack);
            default -> throw new QuestRuntimeException("Unexpected value: " + action);
        }
        return null;
    }

    public enum Action {
        ADD, REMOVE
    }
}
