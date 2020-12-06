package io.github.underscore11code.maintenancemode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MaintenanceMode extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        //noinspection ConstantConditions
        getServer().getPluginCommand("maintainence").setExecutor(this);
    }

    @EventHandler(ignoreCancelled = true)
    public void onJoin(PlayerLoginEvent e) {
        if (!this.getConfig().getBoolean("enabled")) {
            return;
        }

        Player player = e.getPlayer();
        if (!(player.hasPermission("maintenancemode.bypass") || player.isOp())) {
            //noinspection ConstantConditions
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, getConfig().getString("kickMessage"));
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equals("maintainence")) return true;
        if (args.length == 0) return false;
        switch (args[0]) {
            case "reload":
                reloadConfig();
                sender.sendMessage("Config Reloaded!");
                break;
            case "on":
                getConfig().set("enabled", true);
                saveConfig();
                sender.sendMessage("Maintenance mode enabled!");
                break;
            case "off":
                getConfig().set("enabled", false);
                saveConfig();
                sender.sendMessage("Maintenance mode disabled!");
                break;
            default:
                return false;
        }

        return true;
    }
}
