package dev.nolz.cutscenes;

import dev.nolz.cutscenes.exceptions.NoCutsceneFoundError;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CutsceneSession {

    private final Player player;
    private final String world;
    private final String name;
    private final double duration;
    private final ArrayList<Location> points = new ArrayList<>();
    private final FileConfiguration cutscenesConfig;


    public CutsceneSession(Cutscenes cutscenes, String name, double duration, Player player) {

        world = player.getWorld().getName();
        this.name = name;
        this.player = player;
        cutscenesConfig = cutscenes.getConfig();
        this.duration = duration;
    }

    public void load(String cutsceneName) throws NoCutsceneFoundError { //Case sensitive or not???
        if (cutscenesConfig.contains(name)) {

        }
        else {
            throw new NoCutsceneFoundError();
        }
    }

    public void save() {
        cutscenesConfig.set(name + ".world", world);
        for (int i = 0; i < points.size(); i++) {
            cutscenesConfig.set(i+".x", points.get(i).getX());
            cutscenesConfig.set(i+".y", points.get(i).getY());
            cutscenesConfig.set(i+".z", points.get(i).getZ());

        }
        cutscenesConfig.set(name+".duration", duration);

    }

    public void addPoint(Location loc) {
        points.add(loc);
    }

    public void setPoint(Location loc, int index) {
        points.set(index, loc);
    }

    public void removePoint(int index) {
        points.remove(index);
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
