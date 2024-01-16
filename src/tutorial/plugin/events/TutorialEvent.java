package tutorial.plugin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TutorialEvent implements Listener {

    @EventHandler
    public void aoEntrarNoServidor(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("§7[§a+§7] §e" + player.getName());
    }

    @EventHandler
    public void aoSairDoServidor(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("§7[§c-§7] §e" + player.getName());
    }

    @EventHandler
    public void aoClicarNoInv(InventoryClickEvent event) {
       if (event.getInventory().getTitle().equalsIgnoreCase("Tutorial - GUI")) {
           Player player = (Player) event.getWhoClicked();
           if (event.getCurrentItem().hasItemMeta()) {
               String itemName = event.getCurrentItem().getItemMeta().getDisplayName();
               if (itemName.equalsIgnoreCase(ChatColor.YELLOW + "Gamemode 1")) {
                   player.sendMessage(ChatColor.GREEN + "Você ativou o Gamemode Criativo com sucesso!");
                   Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode 1 " + player.getName());
               } else if (itemName.equalsIgnoreCase(ChatColor.GOLD + "Gamemode 0")) {
                   player.sendMessage(ChatColor.GREEN + "Você ativou o Gamemode Survival com sucesso!");
                   Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode 0 " + player.getName());
               }
               player.closeInventory();
               event.setCancelled(true);
           }
       }
    }

}
