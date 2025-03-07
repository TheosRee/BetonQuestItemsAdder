package me.voten.betonquestitemsadder.objectives;

import dev.lone.itemsadder.api.CustomStack;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.api.Objective;
import org.betonquest.betonquest.api.profile.OnlineProfile;
import org.betonquest.betonquest.api.profile.Profile;
import org.betonquest.betonquest.api.quest.QuestException;
import org.betonquest.betonquest.instruction.Instruction;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

import java.util.List;
import java.util.Locale;

public class EnchantItem extends Objective implements Listener {
    private final String itemID;

    private final List<EnchantmentData> enchantments;

    public EnchantItem(Instruction instruction) throws QuestException {
        super(instruction);
        this.itemID = instruction.next();
        this.enchantments = instruction.getList(EnchantmentData::convert);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onEnchant(EnchantItemEvent event) {
        OnlineProfile profile = BetonQuest.getInstance().getProfileProvider().getProfile(event.getEnchanter());
        if (!containsPlayer(profile)) {
            return;
        }
        CustomStack customStack = CustomStack.byItemStack(event.getItem());
        if (customStack == null || !itemID.equals(customStack.getNamespacedID())) {
            return;
        }
        for (EnchantmentData enchant : enchantments) {
            if (!event.getEnchantsToAdd().containsKey(enchant.enchantment()) || event.getEnchantsToAdd()
                    .get(enchant.enchantment()) < enchant.level()) {
                return;
            }
        }
        if (checkConditions(profile)) {
            completeObjective(profile);
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

    @Override
    public String getDefaultDataInstruction() {
        return "";
    }

    @Override
    public String getProperty(String s, Profile profile) {
        return "";
    }

    public record EnchantmentData(Enchantment enchantment, int level) {

        public static EnchantmentData convert(String string) throws QuestException {
            String[] parts = string.split(":");
            if (parts.length != 2) {
                throw new QuestException("Could not parse enchantment: " + string);
            }
            @SuppressWarnings("deprecation") Enchantment enchantment = Enchantment.getByName(
                    parts[0].toUpperCase(Locale.ROOT));
            if (enchantment == null) {
                throw new QuestException("Enchantment type '" + parts[0] + "' does not exist");
            }
            try {
                return new EnchantmentData(enchantment, Integer.parseInt(parts[1]));
            } catch (NumberFormatException e) {
                throw new QuestException("Could not parse enchantment level: " + string, e);
            }
        }
    }
}
