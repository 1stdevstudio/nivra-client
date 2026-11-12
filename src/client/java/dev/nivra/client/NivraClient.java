package dev.nivra.client;

import dev.nivra.client.core.ModuleRegistry;
import dev.nivra.client.modules.SessionTrackerModule;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client-only bootstrap. Keep Minecraft-specific hooks at the platform boundary.
 */
public final class NivraClient implements ClientModInitializer {
    public static final String MOD_ID = "nivra";
    private static final Logger LOGGER = LoggerFactory.getLogger("Nivra Client");
    private static final ModuleRegistry MODULES = new ModuleRegistry();

    @Override
    public void onInitializeClient() {
        MODULES.register(new SessionTrackerModule(), true);
        ClientTickEvents.END_CLIENT_TICK.register(client -> MODULES.onClientTick());
        LOGGER.info("Nivra Client initialized (foundation/pre-alpha)");
    }

    public static ModuleRegistry modules() {
        return MODULES;
    }
}
