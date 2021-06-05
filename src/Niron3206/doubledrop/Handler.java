package Niron3206.doubledrop;

import java.util.List;

import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Handler implements Listener {	
	
	private Main plugin;

	public Handler(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onDropByBlock(BlockDropItemEvent e) {
		List<Item> drop = e.getItems();
		if(drop.size() == 0) {
			return;
		}	
		for(int i=0; i<drop.size(); i++) {
			drop.get(i).getItemStack().setAmount(plugin.getConfig().getInt("ammount_of_drop"));
		}
	}
	
	@EventHandler
	public void onDeathEntityByPlayer(EntityDeathEvent e) {
		LivingEntity ent = e.getEntity();
		List<ItemStack> drop = e.getDrops();
		if(ent instanceof Player) {
			return;
		}
		if(drop.size() == 0) {
			return;
		}
		for(int i=0; i<drop.size(); i++) {
			drop.get(i).setAmount(plugin.getConfig().getInt("ammount_of_drop"));
		}
	}
	
}
