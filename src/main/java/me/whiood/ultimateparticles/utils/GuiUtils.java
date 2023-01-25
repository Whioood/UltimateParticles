package me.whiood.ultimateparticles.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GuiUtils {

    @SuppressWarnings("all")
    public static ItemStack item(Material material, int amount, String displayName){
        ItemStack returnItem = new ItemStack(material, amount);
        ItemMeta returnItemMeta = returnItem.getItemMeta();
        returnItemMeta.setDisplayName(ChatUtils.Color(displayName));
        returnItem.setItemMeta(returnItemMeta);


        return returnItem;
    }

    @SuppressWarnings("ALL")
    public static ItemStack itemLore(Material material, int amount, String displayName, String... lore){
        ItemStack returnItem = new ItemStack(material, amount);
        ItemMeta returnItemMeta = returnItem.getItemMeta();
        returnItemMeta.setDisplayName(ChatUtils.Color(displayName));
        List<String> lores = new ArrayList<>();
        for (String s : lore)
            lores.add(ChatUtils.Color(s));

        returnItemMeta.setLore(lores);
        returnItem.setItemMeta(returnItemMeta);


        return returnItem;
    }

    @SuppressWarnings("ALL")
    public static Inventory getGui(){
        Inventory trailGui = Bukkit.createInventory(null, 4*9, ChatUtils.Color("&2&lTrails Menu"));
        for (int i=0; trailGui.getSize()>i; i++) {
            switch (i){
                case 10 -> trailGui.setItem(10, itemLore(Material.TOTEM_OF_UNDYING, 1, ChatUtils.Color("&aTotem Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));

                default -> {
                    trailGui.setItem(i,item(Material.GRAY_STAINED_GLASS_PANE,1,ChatUtils.Color("&7")));
                }
            }

        }
        return trailGui;
    }

    public static Particle GetParticle(int index){
        Particle particle = null;
        switch (index){
            case 10 -> particle = Particle.TOTEM;
        }
        return particle;
    }

}
