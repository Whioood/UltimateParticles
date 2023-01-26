package me.whiood.ultimatetrails;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.whiood.ultimatetrails.commands.TrailCommand;
import me.whiood.ultimatetrails.events.OnClickEvent;
import me.whiood.ultimatetrails.events.OnMoveEvent;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public final class UltimateTrails extends JavaPlugin {
    public static UltimateTrails instance;
    public HashMap<UUID, Particle> trailMap = new HashMap<>();

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("trails")).setExecutor(new TrailCommand());
        getServer().getPluginManager().registerEvents(new OnClickEvent(), this);
        getServer().getPluginManager().registerEvents(new OnMoveEvent(), this);

        instance = this;

        loadData();

        getConfig().options().copyDefaults(true);
        saveConfig();



    }

    @Override
    public void onDisable() {
        try {
            saveData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @SuppressWarnings("ALL")
    public void saveData() throws IOException {
        Gson gson = new Gson();
        File file = new File(getDataFolder(), "traildata.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        Writer writer = new FileWriter(file, false);
        gson.toJson(trailMap, writer);
        writer.flush();
        writer.close();
    }

    public void loadData() {
        Gson gson = new Gson();
        try {
            String json = new String(Files.readAllBytes(Paths.get(getDataFolder() + "/traildata.json")));
            trailMap = gson.fromJson(json, new TypeToken<HashMap<UUID, Particle>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
