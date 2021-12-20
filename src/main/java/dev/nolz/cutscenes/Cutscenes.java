package dev.nolz.cutscenes;

import dev.nolz.cutscenes.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Cutscenes extends JavaPlugin {

    ConfigManager configManager;

    @Override
    public void onEnable() {
        try {
            configManager = new ConfigManager(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {

    }
}
