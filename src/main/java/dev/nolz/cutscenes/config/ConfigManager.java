package dev.nolz.cutscenes.config;

import dev.nolz.cutscenes.Cutscenes;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final File cutscenesFile;
    private final FileConfiguration cutscenesConfig;


    public ConfigManager(Cutscenes cutscenes) throws IOException {

        File dataFolder = cutscenes.getDataFolder();

        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        cutscenesFile = new File(dataFolder, "cutscenes.yml");
        cutscenesFile.createNewFile();
        cutscenesConfig = YamlConfiguration.loadConfiguration(cutscenesFile);

    }

    public FileConfiguration getCutscenesConfig() {
        return cutscenesConfig;
    }

    public void SaveCutscenesConfig() {
        try {
            cutscenesConfig.save(cutscenesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
