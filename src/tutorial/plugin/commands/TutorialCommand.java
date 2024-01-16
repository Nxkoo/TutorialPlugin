package tutorial.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tutorial.plugin.PluginTutorial;

import java.util.ArrayList;
import java.util.List;

public class TutorialCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            sender.sendMessage(PluginTutorial.PREFIX + ChatColor.RED + "Comando utilizavel apenas para players!");

        if (cmd.getName().equalsIgnoreCase("tutorial")) {
            Player player = (Player) sender;
            if (args.length != 0) {
                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(ChatColor.GREEN + "Este é um comando de help.");
                } else if (args[0].equalsIgnoreCase("abrirGUI")) {
                    Inventory inv = Bukkit.createInventory(null, 3*9, "Tutorial - GUI");

                    ItemStack bookItem = new ItemStack(Material.BOOK);
                    ItemStack starItem = new ItemStack(Material.NETHER_STAR);
                    ItemMeta bookMeta = bookItem.getItemMeta();
                    ItemMeta starMeta = starItem.getItemMeta();
                    List<String> bookLore = new ArrayList<>();
                    List<String> starLore = new ArrayList<>();
                    bookLore.add("§aAtive o Gamemode Criativo");
                    starLore.add("§cAtive o Gamemode Sobrevivencia");

                    bookMeta.setDisplayName(ChatColor.YELLOW + "Gamemode 1");
                    bookMeta.setLore(bookLore);
                    starMeta.setDisplayName(ChatColor.GOLD + "Gamemode 0");
                    starMeta.setLore(starLore);

                    loopGlass(inv);

                    bookItem.setItemMeta(bookMeta);
                    starItem.setItemMeta(starMeta);
                    inv.setItem(3, bookItem);
                    inv.setItem(4, starItem);
                    player.sendMessage(ChatColor.GOLD + "Você abriu o gui de tutorial com sucesso!");
                    player.openInventory(inv);
                }
            } else {
                player.sendMessage(ChatColor.GREEN + "Olá este é um comando de tutorial, o que deseja?");
            }
        }
        return false;
    }

    private void loopGlass(Inventory inv) {
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(ChatColor.AQUA + "-/-/-/");

        int i = 0;
        glass.setItemMeta(glassMeta);
        // Pega todos os itens do inventario
        for (ItemStack item : inv.getContents()) {
            // verifica se tem algum item que é nulo, então seta o item
            if (item == null) {
                inv.setItem(i, glass);
            }
            // i = i + 1
            // 5 = 5 + 1
            i++;
        }
    }
}
