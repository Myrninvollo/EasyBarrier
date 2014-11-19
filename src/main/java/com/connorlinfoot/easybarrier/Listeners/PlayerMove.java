package com.connorlinfoot.easybarrier.Listeners;

import com.connorlinfoot.easybarrier.EasyBarrier;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        String mat = EasyBarrier.getPlugin().getConfig().getString("Barrier Block");
        player.sendMessage("Event is being called");
        player.sendMessage(mat);
        player.sendMessage(String.valueOf(event.getTo().getBlock().getType()));
        if (event.getTo().getBlock().getType() == Material.getMaterial(mat) && event.getTo().add(0, 1, 0).getBlock().getType() == Material.getMaterial(mat)) {
            event.setCancelled(true);
        }
    }

}
