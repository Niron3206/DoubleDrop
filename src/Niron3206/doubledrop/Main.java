package Niron3206.doubledrop;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		File config = new File(getDataFolder() + File.separator + "config.yml");
		if(!config.exists()) {
			getLogger().info(ChatColor.GREEN + "Creating a new config.....");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		
		getCommand("doubledrop").setExecutor(this);
		Bukkit.getPluginManager().registerEvents(new Handler(this), this);
		getLogger().info(ChatColor.GREEN + "Plugin enable!");
	}
	
	public void onDisable() {
		getLogger().info(ChatColor.RED + "Plugin disable!");
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("doubledrop")) {
        if((args.length == 1) && (args[0].equalsIgnoreCase("reload")))
            if(sender.hasPermission("doubledrop.reload")) {
                reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Plugin reload!");
                getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f[Doubledrop] ") + ChatColor.GREEN + "Config reload!");
                return true;
            }
        }
        return super.onCommand(sender, cmd, label, args);
    }
}
