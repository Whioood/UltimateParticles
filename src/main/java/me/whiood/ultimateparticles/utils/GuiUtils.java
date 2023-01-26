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
                case 10 -> trailGui.setItem(i, itemLore(Material.BARRIER, 1, ChatUtils.Color("&cDisable particles"), ChatUtils.Color("&7"), ChatUtils.Color("&cLeft click to disable!")));
                case 11 -> trailGui.setItem(i, itemLore(Material.TOTEM_OF_UNDYING, 1, ChatUtils.Color("&aTotem Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 12 -> trailGui.setItem(i, itemLore(Material.DRAGON_EGG, 1, ChatUtils.Color("&aWitch Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 13 -> trailGui.setItem(i, itemLore(Material.IRON_SWORD, 1, ChatUtils.Color("&aCrit Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 14 -> trailGui.setItem(i, itemLore(Material.SOUL_CAMPFIRE, 1, ChatUtils.Color("&aSoul Fire Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 15 -> trailGui.setItem(i, itemLore(Material.INK_SAC, 1, ChatUtils.Color("&aSquid Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 16 -> trailGui.setItem(i, itemLore(Material.GLOW_INK_SAC, 1, ChatUtils.Color("&aGlow Squid Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 19 -> trailGui.setItem(i, itemLore(Material.SNOW_BLOCK, 1, ChatUtils.Color("&aSnow Flake Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 20 -> trailGui.setItem(i, itemLore(Material.FLINT_AND_STEEL, 1, ChatUtils.Color("&aFlame Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 21 -> trailGui.setItem(i, itemLore(Material.SCULK_CATALYST, 1, ChatUtils.Color("&aSculk Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 22 -> trailGui.setItem(i, itemLore(Material.OBSIDIAN, 1, ChatUtils.Color("&aPortal Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 23 -> trailGui.setItem(i, itemLore(Material.NAUTILUS_SHELL, 1, ChatUtils.Color("&aNautilus Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 24 -> trailGui.setItem(i, itemLore(Material.WHITE_WOOL, 1, ChatUtils.Color("&aCloud Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));
                case 25 -> trailGui.setItem(i, itemLore(Material.COMPOSTER, 1, ChatUtils.Color("&aComposter Particles"), ChatUtils.Color("&7"), ChatUtils.Color("&aLeft click to use!")));


                default -> {
                    trailGui.setItem(i,item(Material.GRAY_STAINED_GLASS_PANE,1,ChatUtils.Color("&7")));
                }
            }

        }
        return trailGui;
    }

    public static Particle getParticle(int index){
        Particle particle = null;
        switch (index){
            case 10 -> particle = Particle.BLOCK_MARKER;
            case 11 -> particle = Particle.TOTEM;
            case 12 -> particle = Particle.SPELL_WITCH;
            case 13 -> particle = Particle.CRIT;
            case 14 -> particle = Particle.SOUL_FIRE_FLAME;
            case 15 -> particle = Particle.SQUID_INK;
            case 16 -> particle = Particle.GLOW_SQUID_INK;
            case 19 -> particle = Particle.SNOWFLAKE;
            case 20 -> particle = Particle.FLAME;
            case 21 -> particle = Particle.SCULK_CHARGE_POP;
            case 22 -> particle = Particle.PORTAL;
            case 23 -> particle = Particle.NAUTILUS;
            case 24 -> particle = Particle.CLOUD;
            case 25 -> particle = Particle.COMPOSTER;
        }
        return particle;
    }

}
