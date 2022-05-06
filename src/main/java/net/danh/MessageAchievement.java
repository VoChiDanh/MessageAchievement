package net.danh;

import net.danh.Commands.CMDBase;
import net.danh.Manager.AdvancementManager;
import net.danh.Utils.VersionChecker;
import org.bukkit.plugin.java.JavaPlugin;

public final class MessageAchievement extends JavaPlugin {

    private static MessageAchievement instance;
    private AdvancementManager advancementManager;


    public static MessageAchievement get() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
        VersionChecker.checkServerVersion();
    }

    @Override
    public void onEnable() {
        if (!initialSetupSuccessful()) {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("MA").setExecutor(new CMDBase());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean initialSetupSuccessful() {
        if (!VersionChecker.isSupportedVersion()) {
            return false;
        }

        VersionChecker.registerClasses();
        return true;
    }

    public AdvancementManager getAdvancementManager() {
        return advancementManager;
    }

    public void setAdvancementManager(AdvancementManager advancementManager) {
        this.advancementManager = advancementManager;
    }
}
