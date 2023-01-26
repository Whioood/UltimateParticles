package me.whiood.ultimatetrails.utils;

import me.whiood.ultimatetrails.UltimateTrails;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {

    public static String Color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void NoPermMsg(Player p){
        p.sendMessage(Color(UltimateTrails.instance.getConfig().getString("no-perm-msg")));
    }


}
