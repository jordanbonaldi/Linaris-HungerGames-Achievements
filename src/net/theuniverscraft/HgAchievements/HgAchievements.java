package net.theuniverscraft.HgAchievements;

import net.theuniverscraft.HgAchievements.Managers.DbManager;
import net.theuniverscraft.HgAchievements.Managers.GameConfig;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HgAchievements extends JavaPlugin implements Listener {
	public void onEnable() {
		GameConfig.initConfig(this);
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
		DbManager.saveInstance();
	}
	
	@EventHandler public void onPlayerQuit(PlayerQuitEvent event) { onPlayerQuitOrKick(event.getPlayer()); }
	@EventHandler public void onPlayerKick(PlayerKickEvent event) { onPlayerQuitOrKick(event.getPlayer()); }
	public void onPlayerQuitOrKick(Player player) {
		DbManager.getInstance().savePlayer(player);
	}
}
