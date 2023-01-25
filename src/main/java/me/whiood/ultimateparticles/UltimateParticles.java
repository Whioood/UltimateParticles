package me.whiood.ultimateparticles;

import me.whiood.ultimateparticles.commands.TrailCommand;
import me.whiood.ultimateparticles.events.OnClickEvent;
import me.whiood.ultimateparticles.utils.TrailManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class UltimateParticles extends JavaPlugin {

    public static TrailManager trailManager;
    public static UltimateParticles instance;

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("trails")).setExecutor(new TrailCommand());
        getServer().getPluginManager().registerEvents(new OnClickEvent(), this);

        instance = this;
        trailManager = new TrailManager();
    }

}
