package me.whiood.ultimateparticles.utils;

import me.whiood.ultimateparticles.UltimateParticles;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FileManager {

    File saveBin;

    public FileManager(){
        buildFiles();
    }

    @SuppressWarnings("all")
    private void buildFiles(){
        if (!UltimateParticles.getPlugin(UltimateParticles.class).getDataFolder().exists())
        {
            UltimateParticles.getPlugin(UltimateParticles.class).getDataFolder().mkdir();
            saveBin = new File(UltimateParticles.instance.getDataFolder(), "trails.bin");
            try {
                saveBin.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<TrailData> saveAndLoad(List<TrailData> trails){
        saveTrailData(trails);
        return loadTrailData();
    }

    public void saveTrailData(List<TrailData> trails){
        try {
            BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(Files.newOutputStream(saveBin.toPath())));
            out.writeObject(trails);
            out.close();
        } catch (IOException e){e.printStackTrace();}
    }

    @SuppressWarnings("all")
    public List<TrailData> loadTrailData(){
        List<TrailData> trailData = new ArrayList<>();
        try {
            BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(Files.newInputStream(saveBin.toPath())));
            trailData = (List<TrailData>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e){e.printStackTrace();}

        return trailData;
    }


}
