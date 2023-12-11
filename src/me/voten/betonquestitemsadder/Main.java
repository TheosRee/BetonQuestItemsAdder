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
        betonQuest.registerConditions("hasitems", HasItems.class);
        betonQuest.registerConditions("wearitems", WearItems.class);
        betonQuest.registerConditions("hasiteminhand", HasItemInHand.class);
        betonQuest.registerConditions("isblock", IsBlock.class);
        //events
        betonQuest.registerEvents("removeitems", ItemEvent.class);
        betonQuest.registerEvents("setblockat", SetBlockAt.class);
        betonQuest.registerEvents("playanimation", PlayAnimation.class);
        //objectives
        betonQuest.registerObjectives("craftitems", CraftingItem.class);
        betonQuest.registerObjectives("pickupitems", PickupItem.class);
        betonQuest.registerObjectives("blockbreak", BlockBreak.class);
        betonQuest.registerObjectives("blockplace", BlockPlace.class);
        betonQuest.registerObjectives("enchantitem", EnchantItem.class);
        betonQuest.registerObjectives("smeltingitems", SmeltingItem.class);

        getLogger().info("Plugin Successful Enabled");
    }

}
