package me.whiood.ultimateparticles.utils;

import java.util.ArrayList;
import java.util.List;

public class TrailManager {

    FileManager fileManager;
    List<TrailData> trailData;

    public TrailManager(){
        trailData = new ArrayList<>();
        fileManager = new FileManager();
        LoadTrails();
    }

    public void LoadTrails(){
        trailData = fileManager.loadTrailData();
    }

    public void SaveTrails(){
        fileManager.saveTrailData(trailData);
    }

    public void DeleteTrail(TrailData trailData){
        this.trailData.remove(trailData);
    }

    public void AddTrail(TrailData trailData){
        for (TrailData data: this.trailData)
            if (data.GetPlayer().getUniqueId().equals(trailData.GetPlayer().getUniqueId()))
                this.trailData.remove(data);
        this.trailData.add(trailData);
    }

    public List<TrailData> getTrailData() {
        return trailData;
    }
}
