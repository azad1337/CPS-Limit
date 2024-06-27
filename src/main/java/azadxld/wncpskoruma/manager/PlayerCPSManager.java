package azadxld.wncpskoruma.manager;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import azadxld.wncpskoruma.WNCpsKoruma;

import java.util.List;

public class PlayerCPSManager {
    private final WNCpsKoruma plugin;
    private static final String LEFT_CPS_KEY = "leftCPS";
    private static final String RIGHT_CPS_KEY = "rightCPS";

    public PlayerCPSManager(WNCpsKoruma plugin) {
        this.plugin = plugin;
    }

    public void incrementLeftCPS(Player player) {
        int cps = getLeftCPS(player) + 1;
        player.setMetadata(LEFT_CPS_KEY, new FixedMetadataValue(plugin, cps));
    }

    public int getLeftCPS(Player player) {
        return getMetadataValue(player, LEFT_CPS_KEY);
    }

    public void resetLeftCPS(Player player) {
        player.setMetadata(LEFT_CPS_KEY, new FixedMetadataValue(plugin, 0));
    }

    public void incrementRightCPS(Player player) {
        int cps = getRightCPS(player) + 1;
        player.setMetadata(RIGHT_CPS_KEY, new FixedMetadataValue(plugin, cps));
    }

    public int getRightCPS(Player player) {
        return getMetadataValue(player, RIGHT_CPS_KEY);
    }

    public void resetRightCPS(Player player) {
        player.setMetadata(RIGHT_CPS_KEY, new FixedMetadataValue(plugin, 0));
    }

    private int getMetadataValue(Player player, String key) {
        List<MetadataValue> metadata = player.getMetadata(key);
        if (metadata.isEmpty()) {
            return 0;
        }
        return metadata.get(0).asInt();
    }
}
