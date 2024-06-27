package azadxld.wncpskoruma.utils;

import azadxld.wncpskoruma.WNCpsKoruma;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class util {
    private static WNCpsKoruma plugin;
    private static FileConfiguration config;

    public util(WNCpsKoruma plugin) {
        util.plugin = plugin;
        util.config = plugin.getConfig();
    }

    public static List<String> getList(String path) {
        return config.getStringList(path);
    }

    public static String getString(String path) {
        return config.getString(path);
    }

    public static int getInt(String path) {
        return config.getInt(path);
    }

    public static boolean getBool(String path) {
        return config.getBoolean(path);
    }

    public static void msgPlayer(Player player, String path) {
        String msg = getMessage(path);
        player.sendMessage(msg);
    }

    public static void msgSender(CommandSender sender, String path) {
        String msg = getMessage(path);
        sender.sendMessage(msg);
    }

    private static String getMessage(String path) {
        String message = config.getString(path);
        if (message != null) {
            return ChatColor.RED + "Hata " + path;
        } else {
            return ChatColor.translateAlternateColorCodes('&', config.getString("mesajlar.prefix") + path);
        }
    }

    public static boolean isCooldownActive(Player player) {
        return player.hasMetadata("cooldown_active");
    }

    public static void startCooldown(Player player, int seconds) {
        player.setMetadata("cooldown_active", new FixedMetadataValue(plugin, true));

        plugin.getServer().getScheduler().runTaskLater(plugin, () -> {
            player.removeMetadata("cooldown_active", plugin);
        }, seconds * 20L);
    }

    public static WNCpsKoruma getPlugin() {
        return plugin;
    }
}
