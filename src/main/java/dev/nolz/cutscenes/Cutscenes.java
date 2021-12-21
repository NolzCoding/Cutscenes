package dev.nolz.cutscenes;

import dev.nolz.cutscenes.config.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class Cutscenes extends JavaPlugin {

    private ConfigManager configManager;
    SessionManager sessionManager;

    @Override
    public void onEnable() {

        try {
            configManager = new ConfigManager(this);
        } catch (IOException e) {
            Bukkit.getPluginManager().disablePlugin(this);
            e.printStackTrace();
        }

        sessionManager = new SessionManager();

    }

    @Override
    public void onDisable() {

    }
}
