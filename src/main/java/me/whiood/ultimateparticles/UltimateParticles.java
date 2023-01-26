package me.whiood.ultimateparticles;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.whiood.ultimateparticles.commands.TrailCommand;
import me.whiood.ultimateparticles.events.OnClickEvent;
import me.whiood.ultimateparticles.events.OnMoveEvent;
import org.bukkit.OfflinePlayer;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class UltimateParticles extends JavaPlugin {
    public static UltimateParticles instance;

    public HashMap<UUID, Particle> trailMap = new HashMap<>();

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("trails")).setExecutor(new TrailCommand());
        getServer().getPluginManager().registerEvents(new OnClickEvent(), this);
        getServer().getPluginManager().registerEvents(new OnMoveEvent(), this);

        instance = this;

        loadData();
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
        File file = new File(getDataFolder() + "/traildata.json");
        file.mkdir();
        file.createNewFile();
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
