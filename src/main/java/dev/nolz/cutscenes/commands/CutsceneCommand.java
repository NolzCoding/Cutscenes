package dev.nolz.cutscenes.commands;

import dev.nolz.cutscenes.Cutscenes;
import dev.nolz.cutscenes.VectorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class CutsceneCommand implements CommandExecutor, TabCompleter {

    Cutscenes cutscenes;
    public CutsceneCommand(Cutscenes cutscenes) {
        this.cutscenes = cutscenes;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("cutscenes")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                Location location = new Location(player.getWorld(), player.getLocation().getX() + 10, player.getLocation().getY(), player.getLocation().getX(), player.getLocation().getYaw() + 10, player.getLocation().getPitch() + 20);

                try {
                    Location[] interpolateLocations = new VectorUtils().interpolateLocation(player.getLocation(), location, 20);
                    AtomicInteger i = new AtomicInteger();
                    Bukkit.getScheduler().runTaskTimer(cutscenes, () -> {
                        if (i.get() != interpolateLocations.length - 1) {
                            player.teleport(interpolateLocations[i.get()]);
                            i.getAndIncrement();
                        }

                    }
                    ,0L,2L);
                } catch (VectorUtils.InterpolationError e) {
                    e.printStackTrace();
                }

                switch (args[0].toLowerCase(Locale.ROOT)) { //error here
                    case "create":
                        if (args.length == 3 ) {
                            try {
                                double duration = Double.parseDouble(args[1]);
                            }
                            catch (NumberFormatException e) {
                                return true;
                            }
                        }
                        break;
                    case "delete":
                        break;
                    case "edit":
                        break;
                    case "point":
                        if (args.length == 2) {
                            switch (args[1]) {
                                case "add":
                                    break;
                                case "set":
                                    break;
                                case "remove":
                                    break;
                            }
                        }

                    case "start":
                        if (args.length == 2) {
                            //Player player = Bukkit.getPlayer(args[1]);


                        }
                }
            }
        }

        return true;

    }


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}
