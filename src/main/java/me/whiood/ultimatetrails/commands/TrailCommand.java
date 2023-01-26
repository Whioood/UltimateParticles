package me.whiood.ultimatetrails.commands;

import me.whiood.ultimatetrails.UltimateTrails;
import me.whiood.ultimatetrails.utils.ChatUtils;
import me.whiood.ultimatetrails.utils.GuiUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TrailCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if (args.length != 0 && args[0].equalsIgnoreCase("reload") && p.hasPermission("trails.reload")){
            try {
                UltimateTrails.instance.getConfig().load(UltimateTrails.instance.getDataFolder() + "/config.yml");
            } catch (IOException | InvalidConfigurationException e) {
                throw new RuntimeException(e);
            }
            UltimateTrails.instance.saveConfig();
            p.sendMessage(ChatUtils.Color("&aSuccesfully reloaded UltimateTrails"));
            return true;
        }

        if (!p.hasPermission("trails.use")) {
            ChatUtils.NoPermMsg(p);
            return true;
        }

        try {
            p.openInventory(GuiUtils.getGui());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
