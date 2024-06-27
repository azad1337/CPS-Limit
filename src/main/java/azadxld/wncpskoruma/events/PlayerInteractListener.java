package azadxld.wncpskoruma.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import azadxld.wncpskoruma.manager.PlayerCPSManager;
import azadxld.wncpskoruma.utils.util;

import java.nio.charset.StandardCharsets;

public class PlayerInteractListener implements Listener {
    private final PlayerCPSManager cpsManager;
    private final int rightClickLimit;
    private final boolean rightClickProtection;
    private final int cooldownSeconds; // Cooldown süresi

    public PlayerInteractListener(PlayerCPSManager cpsManager) {
        this.cpsManager = cpsManager;
        this.rightClickLimit = util.getInt("right_click_limit");
        this.rightClickProtection = util.getBool("right_click_aktif");
        this.cooldownSeconds = util.getInt("cooldown_sure_saniye");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (!rightClickProtection || util.isCooldownActive(player)) {
            return;
        }

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            cpsManager.incrementRightCPS(player);
            int rightCPS = cpsManager.getRightCPS(player);

            if (rightCPS > rightClickLimit) {
                String message = new String(util.getString("mesajlar.cps_uyari").getBytes(), StandardCharsets.UTF_8);
                util.msgPlayer(player, message);
                event.setCancelled(true);

                util.startCooldown(player, cooldownSeconds);
            }
        }
    }
}
