/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamkrafter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
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
public class Arena {
    private Location spawnLocation;
    private Location lobbyLocation;
 
    private List<UUID> players = new ArrayList<UUID>();
 
    public Arena(Location spawnLocation, Location lobbyLocation) {
        this.spawnLocation = spawnLocation;
        this.lobbyLocation = lobbyLocation;
    }
 
    public void join(Player p) {
        players.add(p.getUniqueId());
    }
 
    public void leave(Player p) {
        players.remove(p.getUniqueId());
    }
 
    public List<UUID> getPlayers() {
        return players;
    }
 
    public Location getSpawnLocation() {
        return spawnLocation;
    }
 
    public Location getLobbyLocation() {
        return lobbyLocation;
    }
 
    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }
 
    public void setLobbyLocation(Location lobbyLocation) {
        this.lobbyLocation = lobbyLocation;
    }
 
}
 
