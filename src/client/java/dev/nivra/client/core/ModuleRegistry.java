package dev.nivra.client.core;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Client-thread-only module lifecycle manager. */
public final class ModuleRegistry {
    private static final Logger LOGGER = LoggerFactory.getLogger("Nivra ModuleRegistry");
    private final Map<String, ClientModule> modules = new LinkedHashMap<>();
    private final Set<String> enabled = new LinkedHashSet<>();

    public void register(ClientModule module, boolean enableInitially) {
        if (module == null || module.id() == null || module.id().isBlank()) {
            throw new IllegalArgumentException("Module and non-empty module id are required");
        }
        if (modules.putIfAbsent(module.id(), module) != null) {
            throw new IllegalArgumentException("Duplicate module id: " + module.id());
        }
        if (enableInitially) {
            setEnabled(module.id(), true);
        }
    }

    public boolean setEnabled(String id, boolean active) {
        ClientModule module = modules.get(id);
        if (module == null) return false;
        if (active == enabled.contains(id)) return true;

        if (active) {
            try {
                module.onEnable();
                enabled.add(id);
            } catch (RuntimeException e) {
                LOGGER.error("Unable to enable module {}", id, e);
                return false;
            }
        } else {
            enabled.remove(id);
            try {
                module.onDisable();
            } catch (RuntimeException e) {
                LOGGER.error("Unable to disable module {}", id, e);
            }
        }
        return true;
    }

    public void onClientTick() {
        for (String id : List.copyOf(enabled)) {
            ClientModule module = modules.get(id);
            if (module == null) continue;
            try {
                module.onClientTick();
            } catch (RuntimeException e) {
                LOGGER.error("Module {} failed during tick; disabling", id, e);
                setEnabled(id, false);
            }
        }
    }

    public boolean isEnabled(String id) {
        return enabled.contains(id);
    }

    public List<String> registeredIds() {
        return List.copyOf(modules.keySet());
    }
}
