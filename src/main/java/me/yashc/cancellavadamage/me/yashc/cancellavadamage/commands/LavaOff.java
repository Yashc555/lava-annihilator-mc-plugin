package me.yashc.cancellavadamage.me.yashc.cancellavadamage.commands;

import me.yashc.cancellavadamage.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.persistence.PersistentDataType;

import javax.swing.text.AttributeSet;

public class LavaOff implements CommandExecutor{
    private final Main main;

    public LavaOff(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 1){
                if(args[0].equals("off")) {
                    p.sendMessage(ChatColor.GREEN + "You are protected from lava");
                    p.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "whatIsPvp"), PersistentDataType.INTEGER, 1);
                }
                else if(args[0].equals("on")) {
                    p.sendMessage(ChatColor.RED + "You are no longer protected from lava");
                    p.getPersistentDataContainer().set(new NamespacedKey(Main.getPlugin(), "whatIsPvp"), PersistentDataType.INTEGER, 0);
                }
                else if(args[0].equals("help")){
                    p.sendMessage("_____________");
                    p.sendMessage(ChatColor.BLUE + "1. /lavadamage off " + ChatColor.WHITE + " - Use this command if you want to be protected from lava");
                    p.sendMessage(ChatColor.BLUE + "1. /lavadamage on " + ChatColor.WHITE + " - Use this command if you DO NOT want to be protected from lava");
                    p.sendMessage(ChatColor.BLUE + "1. /lavadamage help " + ChatColor.WHITE + " - To get help");
                    p.sendMessage(ChatColor.GREEN + "You can contact the developer on discord:" + ChatColor.GOLD + " Terminator#1343");
                    p.sendMessage("_____________");
                }
                else{
                    p.sendMessage(ChatColor.RED + "Incorrect usage of command. Use /lavadamage help");
                    return true;
                }
            }
            else{
                p.sendMessage(ChatColor.RED + "You need to provide an argument. Either /lavadamage on  or  /lavadamage off");
                return true;
            }
        }



        else{
            main.getLogger().info(ChatColor.RED + "You need to be a player to execute this command");
            return true;
        }
        return true;
    }

}
