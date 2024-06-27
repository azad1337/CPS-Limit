package azadxld.wncpskoruma.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import azadxld.wncpskoruma.manager.PlayerCPSManager;

public class resettask extends BukkitRunnable {
    private final PlayerCPSManager cpsManager;

    public resettask(PlayerCPSManager cpsManager) {
        this.cpsManager = cpsManager;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            cpsManager.resetLeftCPS(player);
            cpsManager.resetRightCPS(player);
        }
    }
}
