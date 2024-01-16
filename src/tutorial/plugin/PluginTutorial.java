package tutorial.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import tutorial.plugin.commands.TutorialCommand;
import tutorial.plugin.events.TutorialEvent;

public class PluginTutorial extends JavaPlugin {

    public static String PREFIX = "§7[§bPluginTutorial§7]";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + ChatColor.GREEN + " habilitado com sucesso!");
        getCommand("tutorial").setExecutor(new TutorialCommand());
        Bukkit.getPluginManager().registerEvents(new TutorialEvent(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + ChatColor.RED + " desabilitado com sucesso!");
    }
}
