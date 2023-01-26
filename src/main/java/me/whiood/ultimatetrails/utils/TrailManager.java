package me.whiood.ultimatetrails.utils;

import me.whiood.ultimatetrails.UltimateTrails;
import org.bukkit.Particle;

import java.util.UUID;

public class TrailManager {

    public static void setTrail(UUID playerUUID, Particle trail){
        removeTrail(playerUUID);
        UltimateTrails.instance.trailMap.put(playerUUID, trail);
    }

    public static Particle getTrail(UUID playerUUID){
        return UltimateTrails.instance.trailMap.get(playerUUID);
    }

    public static void removeTrail(UUID playerUUID) {
        UltimateTrails.instance.trailMap.remove(playerUUID);
    }

}
