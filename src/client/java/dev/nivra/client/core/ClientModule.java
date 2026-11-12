package dev.nivra.client.core;

/** Module callbacks run on the Minecraft client thread. */
public interface ClientModule {
    String id();
    ModuleCategory category();

    default void onEnable() {}
    default void onDisable() {}
    default void onClientTick() {}
}
