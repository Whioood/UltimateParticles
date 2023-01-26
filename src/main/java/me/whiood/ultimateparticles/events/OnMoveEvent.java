package me.whiood.ultimateparticles.events;

import me.whiood.ultimateparticles.utils.TrailManager;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnMoveEvent implements Listener {

    @EventHandler
    public void OnMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        Particle particle = TrailManager.getTrail(p.getUniqueId());
        if (particle != null){
            p.getWorld().spawnParticle(particle, p.getLocation(), 5, 0, 0, 0, 0);
        }
    }

}
