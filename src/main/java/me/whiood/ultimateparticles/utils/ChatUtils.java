package me.whiood.ultimateparticles.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ChatUtils {

    public static String Color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void NoPermMsg(Player p){
        p.sendMessage(Color("&cYou do not have the required permission. &6&l/Buy"));
    }


}
