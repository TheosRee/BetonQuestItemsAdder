package me.voten.betonquestitemsadder;

import me.voten.betonquestitemsadder.conditions.IsBlockConditionFactory;
import me.voten.betonquestitemsadder.events.PlayAnimationEventFactory;
import me.voten.betonquestitemsadder.events.SetBlockAtEventFactory;
import me.voten.betonquestitemsadder.item.ItemFactory;
import me.voten.betonquestitemsadder.item.ItemSerializer;
import me.voten.betonquestitemsadder.objectives.BlockBreakObjectiveFactory;
import me.voten.betonquestitemsadder.objectives.BlockPlaceObjectiveFactory;
import org.betonquest.betonquest.BetonQuest;
import org.betonquest.betonquest.api.logger.BetonQuestLoggerFactory;
import org.betonquest.betonquest.kernel.registry.feature.ItemTypeRegistry;
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
        ItemTypeRegistry item = betonQuest.getFeatureRegistries().item();
        item.register("ia", new ItemFactory());
        item.registerSerializer("ia", new ItemSerializer());
        condition.registerCombined("iablockat", new IsBlockConditionFactory(data));

        EventTypeRegistry event = questRegistries.event();
        event.register("iablockat", new SetBlockAtEventFactory(data));
        event.register("iaplayanimation", new PlayAnimationEventFactory(loggerFactory, data));

        ObjectiveTypeRegistry objective = questRegistries.objective();
        objective.register("iablockbreak", new BlockBreakObjectiveFactory());
        objective.register("iablockplace", new BlockPlaceObjectiveFactory());

        getLogger().info("Plugin Successful Enabled");
    }
}
