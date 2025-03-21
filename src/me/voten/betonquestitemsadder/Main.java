package me.voten.betonquestitemsadder;

import me.voten.betonquestitemsadder.conditions.HasItemInHandConditionFactory;
import me.voten.betonquestitemsadder.conditions.HasItemsConditionFactory;
import me.voten.betonquestitemsadder.conditions.IsBlockConditionFactory;
import me.voten.betonquestitemsadder.conditions.WearItemsConditionFactory;
import me.voten.betonquestitemsadder.events.ItemEventFactory;
import me.voten.betonquestitemsadder.events.PlayAnimationEventFactory;
import me.voten.betonquestitemsadder.events.SetBlockAtEventFactory;
import me.voten.betonquestitemsadder.objectives.*;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.api.logger.BetonQuestLoggerFactory;
import org.betonquest.betonquest.kernel.registry.quest.ConditionTypeRegistry;
import org.betonquest.betonquest.kernel.registry.quest.EventTypeRegistry;
import org.betonquest.betonquest.kernel.registry.quest.ObjectiveTypeRegistry;
import org.betonquest.betonquest.kernel.registry.quest.QuestTypeRegistries;
import org.betonquest.betonquest.quest.PrimaryServerThreadData;
import org.bukkit.Server;
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
        BetonQuestLoggerFactory loggerFactory = betonQuest.getLoggerFactory();
        Server server = betonQuest.getServer();
        PrimaryServerThreadData data = new PrimaryServerThreadData(server, server.getScheduler(), betonQuest);
        QuestTypeRegistries questRegistries = betonQuest.getQuestRegistries();

        ConditionTypeRegistry condition = questRegistries.condition();
        condition.register("iaitem", new HasItemsConditionFactory(loggerFactory, data));
        condition.register("iawear", new WearItemsConditionFactory(loggerFactory, data));
        condition.register("iahand", new HasItemInHandConditionFactory(loggerFactory, data));
        condition.registerCombined("iablockat", new IsBlockConditionFactory(data));

        EventTypeRegistry event = questRegistries.event();
        event.register("iaitem", new ItemEventFactory(loggerFactory, data));
        event.register("iablockat", new SetBlockAtEventFactory(data));
        event.register("iaplayanimation", new PlayAnimationEventFactory(loggerFactory, data));

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
