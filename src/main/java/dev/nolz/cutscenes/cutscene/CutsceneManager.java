package dev.nolz.cutscenes.cutscene;

import dev.nolz.cutscenes.CutsceneSession;
import dev.nolz.cutscenes.Cutscenes;
import org.bukkit.Bukkit;

public class CutsceneManager {

    public CutsceneManager(Cutscenes cutscenes){
        Bukkit.getScheduler().runTask(cutscenes, new CutsceneRunnable(new CutsceneSession()))
    }

}
