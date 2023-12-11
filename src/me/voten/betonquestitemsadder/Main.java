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
        //conditions
        betonQuest.registerConditions("iaitem", HasItems.class);
        betonQuest.registerConditions("iawear", WearItems.class);
        betonQuest.registerConditions("iahand", HasItemInHand.class);
        betonQuest.registerConditions("iablockat", IsBlock.class);
        //events
        betonQuest.registerEvents("iaitem", ItemEvent.class);
        betonQuest.registerEvents("iablockat", SetBlockAt.class);
        betonQuest.registerEvents("iaplayanimation", PlayAnimation.class);
        //objectives
        betonQuest.registerObjectives("iacraft", CraftingItem.class);
        betonQuest.registerObjectives("iapickupitems", PickupItem.class);
        betonQuest.registerObjectives("iablockbreak", BlockBreak.class);
        betonQuest.registerObjectives("iablockplace", BlockPlace.class);
        betonQuest.registerObjectives("iaenchantitem", EnchantItem.class);
        betonQuest.registerObjectives("iasmeltingitems", SmeltingItem.class);

        getLogger().info("Plugin Successful Enabled");
    }

}
