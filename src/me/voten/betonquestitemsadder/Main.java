package me.voten.betonquestitemsadder;

import me.voten.betonquestitemsadder.conditions.HasItemInHand;
import me.voten.betonquestitemsadder.conditions.HasItems;
import me.voten.betonquestitemsadder.conditions.IsBlock;
import me.voten.betonquestitemsadder.conditions.WearItems;
import me.voten.betonquestitemsadder.events.ItemEvent;
import me.voten.betonquestitemsadder.events.PlayAnimation;
import me.voten.betonquestitemsadder.events.SetBlockAt;
import me.voten.betonquestitemsadder.objectives.*;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.kernel.registry.quest.ConditionTypeRegistry;
import org.betonquest.betonquest.kernel.registry.quest.EventTypeRegistry;
import org.betonquest.betonquest.kernel.registry.quest.ObjectiveTypeRegistry;
import org.betonquest.betonquest.kernel.registry.quest.QuestTypeRegistries;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static final int PLUGIN_METRICS_ID = 10973;

    @Override
    public void onDisable() {
        getLogger().info("Plugin Successful Disabled");
    }

    @Override
    public void onEnable() {
        new Metrics(this, PLUGIN_METRICS_ID);

        BetonQuest betonQuest = BetonQuest.getInstance();
        QuestTypeRegistries questRegistries = betonQuest.getQuestRegistries();

        ConditionTypeRegistry condition = questRegistries.condition();
        condition.register("iaitem", HasItems.class);
        condition.register("iawear", WearItems.class);
        condition.register("iahand", HasItemInHand.class);
        condition.register("iablockat", IsBlock.class);

        EventTypeRegistry event = questRegistries.event();
        event.register("iaitem", ItemEvent.class);
        event.register("iablockat", SetBlockAt.class);
        event.register("iaplayanimation", PlayAnimation.class);

        ObjectiveTypeRegistry objective = questRegistries.objective();
        objective.register("iacraft", CraftingItem.class);
        objective.register("iapickup", PickupItem.class);
        objective.register("iablockbreak", BlockBreak.class);
        objective.register("iablockplace", BlockPlace.class);
        objective.register("iaenchantitem", EnchantItem.class);
        objective.register("iasmeltingitems", SmeltingItem.class);

        getLogger().info("Plugin Successful Enabled");
    }
}
