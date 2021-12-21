package dev.nolz.cutscenes;

import dev.nolz.cutscenes.config.ConfigManager;

import java.util.HashMap;
import java.util.UUID;

public class SessionManager {


    public HashMap<UUID, CutsceneSession> getActiveSessions() {
        return activeSessions;
    }

    private final HashMap<UUID, CutsceneSession> activeSessions = new HashMap<>();

    public void saveAllSessions() {
        for (CutsceneSession cutsceneSession : activeSessions.values()) {
            cutsceneSession.save();
        }
    }

    public void addSession(CutsceneSession cutsceneSession) {
        activeSessions.put(cutsceneSession.getPlayer().getUniqueId(), cutsceneSession);
    }




}
