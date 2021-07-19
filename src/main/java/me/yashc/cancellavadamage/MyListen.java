package me.yashc.cancellavadamage;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.persistence.PersistentDataType;

public class MyListen implements Listener {

    private final Main main;

    public MyListen(Main main){
        this.main = main;
    }
    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event)
    {
        System.out.println("In onBucketEmpty() event");


        if(event.getBucket() == Material.LAVA_BUCKET)
        {
            Player playerPlacer = event.getPlayer();
            for (Entity nearbyEntities : playerPlacer.getNearbyEntities(4,8,4)) {
                if (nearbyEntities instanceof Player) {
                    if (nearbyEntities.getPersistentDataContainer().get(new NamespacedKey(main.getPlugin(), "whatIsPvp"), PersistentDataType.INTEGER) == 1){
                        nearbyEntities.sendMessage(ChatColor.RED +""+ playerPlacer.getDisplayName() + " tried to place lava on you");
                        playerPlacer.sendMessage(ChatColor.RED + "Ayo! Don't try to kill " + ((Player) nearbyEntities).getDisplayName()+" with lava, he has turned lavadamage off.");
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
