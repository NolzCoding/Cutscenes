package dev.nolz.cutscenes;

import dev.nolz.cutscenes.config.ConfigManager;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CutsceneSession {

    private final Player player;
    private final String world;
    private final String name;
    private final ArrayList<Location> points = new ArrayList<>();
    private final FileConfiguration cunscenesConfig;


    public CutsceneSession(Cutscenes cutscenes, String name, Player player) {
        world = player.getWorld().getName();
        this.name = name;
        this.player = player;
        cunscenesConfig = cutscenes.getConfig();
    }

    public void load(String cutsceneName)  { //Case sensitive or not???

    }

    public void save() {
        cunscenesConfig.set(name + ".world", world);
        for (int i = 0; i < points.size(); i++) {
            cunscenesConfig.set(i+".x", points.get(i).getX());
            cunscenesConfig.set(i+".y", points.get(i).getY());
            cunscenesConfig.set(i+".z", points.get(i).getZ());

        }
    }

    public void addPoint(Location loc) {
        points.add(loc);
    }




    public ArrayList<Location> getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public String getWorld() {
        return world;
    }

    public Player getPlayer() {
        return player;
    }
}
