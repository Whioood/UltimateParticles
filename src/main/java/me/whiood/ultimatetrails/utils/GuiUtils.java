package me.whiood.ultimatetrails.utils;

import me.whiood.ultimatetrails.UltimateTrails;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.configuration.MemorySection;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.FileNotFoundException;
import java.util.*;

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
    public static ItemStack itemLore(Material material, int amount, String displayName, List<String> lore){
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
    public static Inventory getGui() throws FileNotFoundException {
        MemorySection disableParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("disable-particles");
        MemorySection totemParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("totem-particles");
        MemorySection witchParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("witch-particles");
        MemorySection critParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("crit-particles");
        MemorySection soulfireParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("soul-fire-particles");
        MemorySection squidParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("squid-particles");
        MemorySection glowsquidParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("glow-squid-particles");
        MemorySection snowflakeParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("snow-flake-particles");
        MemorySection flameParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("flame-particles");
        MemorySection sculkParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("sculk-particles");
        MemorySection portalParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("portal-particles");
        MemorySection nautilusParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("nautilus-particles");
        MemorySection cloudParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("cloud-particles");
        MemorySection composterParticles = (MemorySection) UltimateTrails.instance.getConfig().getConfigurationSection("composter-particles");


        Inventory trailGui = Bukkit.createInventory(null, 4*9, ChatUtils.Color("&2&lTrails Menu"));
        for (int i=0; trailGui.getSize()>i; i++) {
            switch (i){
                case 10 -> trailGui.setItem(i, itemLore(Material.BARRIER, 1, ChatUtils.Color(disableParticles.getString("name")), disableParticles.getStringList("lore")));
                case 11 -> trailGui.setItem(i, itemLore(Material.TOTEM_OF_UNDYING, 1, ChatUtils.Color(totemParticles.getString("name")), totemParticles.getStringList("lore")));
                case 12 -> trailGui.setItem(i, itemLore(Material.DRAGON_EGG, 1, ChatUtils.Color(witchParticles.getString("name")), witchParticles.getStringList("lore")));
                case 13 -> trailGui.setItem(i, itemLore(Material.IRON_SWORD, 1, ChatUtils.Color(critParticles.getString("name")), critParticles.getStringList("lore")));
                case 14 -> trailGui.setItem(i, itemLore(Material.SOUL_CAMPFIRE, 1, ChatUtils.Color(soulfireParticles.getString("name")), soulfireParticles.getStringList("lore")));
                case 15 -> trailGui.setItem(i, itemLore(Material.INK_SAC, 1, ChatUtils.Color(squidParticles.getString("name")), squidParticles.getStringList("lore")));
                case 16 -> trailGui.setItem(i, itemLore(Material.GLOW_INK_SAC, 1, ChatUtils.Color(glowsquidParticles.getString("name")), glowsquidParticles.getStringList("lore")));
                case 19 -> trailGui.setItem(i, itemLore(Material.SNOW_BLOCK, 1, ChatUtils.Color(snowflakeParticles.getString("name")), snowflakeParticles.getStringList("lore")));
                case 20 -> trailGui.setItem(i, itemLore(Material.FLINT_AND_STEEL, 1, ChatUtils.Color(flameParticles.getString("name")), flameParticles.getStringList("lore")));
                case 21 -> trailGui.setItem(i, itemLore(Material.SCULK_CATALYST, 1, ChatUtils.Color(sculkParticles.getString("name")), sculkParticles.getStringList("lore")));
                case 22 -> trailGui.setItem(i, itemLore(Material.OBSIDIAN, 1, ChatUtils.Color(portalParticles.getString("name")), portalParticles.getStringList("lore")));
                case 23 -> trailGui.setItem(i, itemLore(Material.NAUTILUS_SHELL, 1, ChatUtils.Color(nautilusParticles.getString("name")), nautilusParticles.getStringList("lore")));
                case 24 -> trailGui.setItem(i, itemLore(Material.WHITE_WOOL, 1, ChatUtils.Color(cloudParticles.getString("name")), cloudParticles.getStringList("lore")));
                case 25 -> trailGui.setItem(i, itemLore(Material.COMPOSTER, 1, ChatUtils.Color(composterParticles.getString("name")), composterParticles.getStringList("lore")));


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
