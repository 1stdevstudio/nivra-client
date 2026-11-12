package dev.nivra.client.modules;

import dev.nivra.client.core.ClientModule;
import dev.nivra.client.core.ModuleCategory;

/**
 * Small functional starter module to exercise module registration and tick dispatch.
 * A real world/session lifecycle will be added in the HUD milestone.
 */
public final class SessionTrackerModule implements ClientModule {
    private long clientTicks;

    @Override
    public String id() {
        return "session_tracker";
    }

    @Override
    public ModuleCategory category() {
        return ModuleCategory.HUD;
    }

    @Override
    public void onEnable() {
        clientTicks = 0;
    }

    @Override
    public void onClientTick() {
        clientTicks++;
    }

    public long clientTicks() {
        return clientTicks;
    }
}
