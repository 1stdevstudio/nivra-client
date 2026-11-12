# Nivra Client

A lightweight, modular, fair-play **all-in-one Minecraft Java Edition utility mod** for multiplayer servers.

**Project status:** early foundation / pre-alpha. There is no downloadable, production-ready mod yet.

## Initial target
- Minecraft Java Edition: **26.3**
- Loader: **Fabric 0.20.1**
- Fabric API: **0.166.0+26.3**
- Java: **25**
- Gradle/Loom: **Gradle 9.8.2** / **Loom 1.19-SNAPSHOT**

## Vision
One client-side mod with independent modules for:
1. Customizable HUD and diagnostics
2. Waypoints and visited-chunk minimap
3. Inventory and equipment warnings
4. Chat filters and manual command shortcuts
5. Fair-play PvP information widgets
6. Survival / SMP helpers
7. Economy, claims and quests (only with legitimate server-provided data)
8. Per-server profiles and preferences
9. Accessibility and performance control
10. Optional Paper integration

Not a hacked client. Nivra will not include combat automation, x-ray, packet spoofing, anti-cheat bypasses, or unsolicited chat/command spam.

## Build
Requires JDK 25 and Gradle 9.8.2:

```bash
bash ./gradlew build
```

Gradle wrapper files are sourced from the official Fabric example mod (26.3 branch).

Client JARs will be written to `build/libs/` after a successful build. **No build success is claimed at repository initialization.**

## Structure
- `src/client/java/dev/nivra/client`: client entrypoint and core modules
- `src/main/resources/fabric.mod.json`: Fabric metadata
- `docs/ARCHITECTURE.md`: technical boundaries
- `docs/ROADMAP.md`: staged implementation plan
- `.github/workflows/build.yml`: CI build

## Development rules
- Client-side by default; no server changes required.
- No network calls without an explicitly negotiated server integration.
- Keep Minecraft-version-specific code isolated.
- Avoid blocking the client render and tick threads.
- Every feature must be independently disableable.
- Don't claim features are implemented until code and tests pass.

## License
MIT — see [LICENSE](LICENSE).
