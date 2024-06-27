package azadxld.wncpskoruma.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;
import azadxld.wncpskoruma.manager.PlayerCPSManager;
import azadxld.wncpskoruma.utils.util;

import java.nio.charset.StandardCharsets;

public class PlayerAnimationListener implements Listener {
    private final PlayerCPSManager cpsManager;
    private final int leftClickLimit;
    private final boolean leftClickProtection;
    private final int cooldownSeconds;

    public PlayerAnimationListener(PlayerCPSManager cpsManager) {
        this.cpsManager = cpsManager;
        this.leftClickLimit = util.getInt("left_click_limit");
        this.leftClickProtection = util.getBool("left_click_aktif");
        this.cooldownSeconds = util.getInt("cooldown_sure_saniye");
    }

    @EventHandler
    public void onPlayerAnimation(PlayerAnimationEvent event) {
        Player player = event.getPlayer();

        if (!leftClickProtection || util.isCooldownActive(player)) {
            return;
        }

        cpsManager.incrementLeftCPS(player);
        int leftCPS = cpsManager.getLeftCPS(player);

        if (leftCPS > leftClickLimit) {
            String message = new String(util.getString("mesajlar.cps_uyari").getBytes(), StandardCharsets.UTF_8);
            util.msgPlayer(player, message);
            util.startCooldown(player, cooldownSeconds);
            event.setCancelled(true);
        }
    }
}
