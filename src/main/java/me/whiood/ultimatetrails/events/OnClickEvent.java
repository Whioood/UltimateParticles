package me.whiood.ultimatetrails.events;

import me.whiood.ultimatetrails.utils.ChatUtils;
import me.whiood.ultimatetrails.utils.GuiUtils;
import me.whiood.ultimatetrails.utils.TrailManager;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class OnClickEvent implements Listener {

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e){
        boolean IsTrailInventory = e.getView().getTitle().contains("Trails Menu");

        if (IsTrailInventory) {
            e.setCancelled(true);
            Particle particle = GuiUtils.getParticle(e.getSlot());
            UUID pUUID = e.getWhoClicked().getUniqueId();
            if (particle == Particle.BLOCK_MARKER) {
                e.getWhoClicked().sendMessage(ChatUtils.Color("&cSuccesfully disabled trail"));
                TrailManager.removeTrail(pUUID);
            } else if (!(particle == null))
                if (e.getWhoClicked().hasPermission("trails.use." + particle.toString().toLowerCase())){
                    e.getWhoClicked().sendMessage(ChatUtils.Color("&aSuccesfully selected trail"));
                    TrailManager.setTrail(pUUID, particle);
                } else ChatUtils.NoPermMsg((Player) e.getWhoClicked());


        }
    }

}
