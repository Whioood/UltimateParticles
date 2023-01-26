package me.whiood.ultimateparticles.utils;

import me.whiood.ultimateparticles.UltimateParticles;
import org.bukkit.Particle;

import java.util.UUID;

public class TrailManager {

    public static void setTrail(UUID playerUUID, Particle trail){
        removeTrail(playerUUID);
        UltimateParticles.instance.trailMap.put(playerUUID, trail);
    }

    public static Particle getTrail(UUID playerUUID){
        return UltimateParticles.instance.trailMap.get(playerUUID);
    }

    public static void removeTrail(UUID playerUUID) {
        UltimateParticles.instance.trailMap.remove(playerUUID);
    }

}
