package azadxld.wncpskoruma.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class AttackEventListener implements Listener {
    private final JavaPlugin plugin;

    public AttackEventListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();

        if (hasCooldown(player)) {
            event.setCancelled(true);
        }
    }

    private boolean hasCooldown(Player player) {
        List<MetadataValue> metadataList = player.getMetadata("cooldown_active");
        for (MetadataValue metadata : metadataList) {
            if (metadata.asBoolean()) {
                return true;
            }
        }
        return false;
    }
}
