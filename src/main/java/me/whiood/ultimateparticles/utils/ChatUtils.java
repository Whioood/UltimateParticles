package me.whiood.ultimateparticles.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {

    public static String Color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void NoPermMsg(Player p){
        p.sendMessage(Color("&cYou do not have the required permission."));
    }

}
