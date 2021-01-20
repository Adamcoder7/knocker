/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamkrafter;

import java.util.Set;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.bukkit.util.permissions.*;
import org.bukkit.conversations.*;

/**
 *
 * @author Adam
 */
public class Knocker extends JavaPlugin{

    private ArenaManger arenaManager;
   public static final Logger LOG = Logger.getLogger("Knocker"); 
    private final String PREFIX="KNO";

    @Override
    public void onEnable() {
        arenaManager = new ArenaManger();
    }
   @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("knocker")) {
            if(args.length == 0) {
                sender.sendMessage(PREFIX + ChatColor.GOLD + "Knocker by AdamKrafter");
                sender.sendMessage(PREFIX + ChatColor.GRAY + "Use /knocker help for a list of commands.");
                return true;
            }
            if(args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(PREFIX + ChatColor.GOLD + "Knocker Command Usage");
                sender.sendMessage(PREFIX + ChatColor.GRAY + "/knocker - The main command");
                sender.sendMessage(PREFIX + ChatColor.GRAY + "/pvpgame help - Shows this message.:D");
                sender.sendMessage(PREFIX + ChatColor.GRAY + "/pvpgame add <Name> - Create an arena");
                sender.sendMessage(PREFIX + ChatColor.GRAY + "/pvpgame remove <Name> - Remove an arena");
                sender.sendMessage(PREFIX + ChatColor.GRAY + "/pvpgame setlobby <Name> - Set the lobby for an arena");
                sender.sendMessage(PREFIX + ChatColor.GRAY + "/pvpgame setspawn <Name> - Set the spawn for an arena");
                return true;
            }
            if(args[0].equalsIgnoreCase("add")) {
                if(args.length == 1) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "Use /pvpgame add <Name>");
                    return true;
                }
                String name = args[1];
                if(arenaManager.exists(name)) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "That arena already exists!");
                    return true;
                }
                arenaManager.registerArena(name, null, null);
                sender.sendMessage(ChatColor.GOLD + "Arena created.");
                return true;
            }
            if(args[0].equalsIgnoreCase("remove")) {
                if(args.length == 1) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "Use /pvpgame remove <Name>");
                    return true;
                }
                String name = args[1];
                if(!arenaManager.exists(name)) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "That arena doesn't exist!");
                    return true;
                }
                arenaManager.remove(name);
                sender.sendMessage(ChatColor.GOLD + "Arena removed.");
                return true;
            }
            if(args[0].equalsIgnoreCase("setspawn")) {
                if(!(sender instanceof Player)) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "This command can only be used by players.");
                    return true;
                }
                String name = args[1];
                if(!arenaManager.exists(name)) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "That arena doesn't exist!");
                    return true;
                }
                arenaManager.getArena(name).setSpawnLocation(((Player) sender).getLocation());
                sender.sendMessage(ChatColor.GOLD + "Spawn set.");
                return true;
            }
            if(args[0].equalsIgnoreCase("setlobby")) {
                if(!(sender instanceof Player)) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "This command can only be used by players.");
                    return true;
                }
                String name = args[1];
                if(!arenaManager.exists(name)) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "That arena doesn't exist!");
                    return true;
                }
                arenaManager.getArena(name).setLobbyLocation(((Player) sender).getLocation());
                sender.sendMessage(ChatColor.GOLD + "Lobby set.");
                return true;
            }return true;
        }
            sender.sendMessage(PREFIX + ChatColor.RED + "Unknown subcommand. Use /pvpgame help for a list of commands.");
            return true;
    }
}
