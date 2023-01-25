package me.whiood.ultimateparticles.utils;

import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.io.Serializable;

public class TrailData implements Serializable {
    Player p;
    Particle particle;

    public TrailData(Player p, Particle particle){
        this.p = p;
        this.particle = particle;
    }

    public void DoTask(){
        p.getWorld().spawnParticle(particle, p.getLocation(), 2);
    }

    public Player GetPlayer(){
        return p;
    }

}
