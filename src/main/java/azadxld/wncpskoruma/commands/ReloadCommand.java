package azadxld.wncpskoruma.commands;

import azadxld.wncpskoruma.WNCpsKoruma;
import azadxld.wncpskoruma.utils.util;
import org.apache.commons.lang.builder.StandardToStringStyle;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.nio.charset.StandardCharsets;

public class ReloadCommand implements CommandExecutor {
    private final WNCpsKoruma plugin;

    public ReloadCommand(WNCpsKoruma plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("wncpskoruma.reload")) {
            String message = new String(util.getString("mesajlar.yetki_yok").getBytes(), StandardCharsets.UTF_8);
            util.msgSender(sender, message);
            return true;
        }

        plugin.reloadConfig();
        String message = new String(util.getString("mesajlar.reload").getBytes(), StandardCharsets.UTF_8);
        util.msgSender(sender, message);

        return true;
    }
}
