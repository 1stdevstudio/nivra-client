# Architecture — Nivra Client

## Runtime boundaries
- **Fabric client:** module registry, event dispatch, settings, HUD, local persistence.
- **Platform adapter:** all version-sensitive rendering/input/network code.
- **Core modules:** independent, opt-in, safe to disable.
- **Optional Paper bridge:** separate future distribution; not required for vanilla multiplayer.

## Design decisions
1. No global background HTTP backend for core features.
2. No x-ray, automated attacks, anti-cheat circumvention, fake packets or unsolicited messaging.
3. Never infer undisclosed economy, claims or quest values from server internals.
4. Thread safety: client callbacks stay on the game thread; costly I/O occurs off-thread.
5. Minimap will only render data legitimately known to the client.
6. Game-version-specific functionality must not spread into business/module logic.
7. Each feature must declare its server compatibility and configurable restrictions.
8. Persist settings using versioned schemas and atomic writes in a future milestone.

## Planned packages
- `core` module registry and lifecycle
- `modules` implementation packages (HUD, chat, inventory, waypoints, etc.)
- `ui` native screen elements and HUD editor
- `config` profiles, serialization, migrations
- `platform` version-dependent Fabric bindings
- `integration` capability-negotiated, optional server bridge

## Foundation scope implemented
- Fabric client entrypoint
- Module category/interface/registry
- Failure-isolating client tick dispatch
- Example local session-tick module

**Not implemented yet:** menus, HUD, waypoint, map, chat assistant, server bridge, performance optimizations. These remain roadmap items.
