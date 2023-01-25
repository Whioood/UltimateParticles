package me.whiood.ultimateparticles.events;

import me.whiood.ultimateparticles.UltimateParticles;
import me.whiood.ultimateparticles.utils.GuiUtils;
import me.whiood.ultimateparticles.utils.TrailData;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class OnClickEvent implements Listener {

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e){
        boolean IsTrailInventory = false;
        try{
            IsTrailInventory = Objects.requireNonNull(e.getClickedInventory()).getType().defaultTitle().equals(GuiUtils.getGui().getType().defaultTitle());
        } catch (NullPointerException ignored){}

        if (IsTrailInventory){
            UltimateParticles.trailManager.AddTrail(new TrailData((Player) e.getWhoClicked(), GuiUtils.GetParticle(e.getSlot())));
            e.setCancelled(true);
        }

    }

}
