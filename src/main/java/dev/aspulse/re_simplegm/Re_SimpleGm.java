package dev.aspulse.re_simplegm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Re_SimpleGm extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("gm")).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "This command can only be executed by the player.");
            return true;
        }
        String gmname = "";
        if(!(args.length == 1 || args.length == 2)){
            sender.sendMessage(ChatColor.RED + "Usage: /gm <gamemode value> [player name]");
            return true;
        }
        switch(args[0]){
            case "0":
            case "s":
            case "survival":
                gmname = "survival";
                break;
            case "1":
            case "c":
            case "creative":
                gmname = "creative";
                break;
            case "2":
            case "a":
            case "adventure":
                gmname = "adventure";
                break;
            case "3":
            case "sp":
            case "spectator":
                gmname = "spectator";
                break;
        }
        boolean b = false;
        switch(args.length){
            case 1:
                b = ((Player) sender).performCommand("gamemode " + gmname);
                break;
            case 2:
                b = ((Player) sender).performCommand("gamemode " + gmname + " " + args[1]);
        }
        return b;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
