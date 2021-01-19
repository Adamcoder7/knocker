/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamkrafter;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
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
public class ArenaManger {
    private Map<String, Arena> arenas = new HashMap<String, Arena>();
 
    public void registerArena(String name, Location spawnLocation, Location lobbyLocation) {
        arenas.put(name, new Arena(spawnLocation, lobbyLocation));
    }

    public void remove(String name) {
        arenas.remove(name);
    }
 
    public Arena getArena(String name) {
        return arenas.get(name);
    }

    public boolean exists(String name) {
        return arenas.get(name) != null;
    }
 
    public void load() {
     
    }
 
    public void save() {
     
    }
 
}
