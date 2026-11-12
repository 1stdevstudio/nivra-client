# Roadmap — Nivra Client

## M0 — Foundation
- [x] Create public repository and MIT license
- [x] Fabric 26.3/Java 25 baseline files
- [x] Client mod entrypoint
- [x] Minimal module registry and example module
- [x] CI workflow
- [ ] Confirm Gradle build on GitHub Actions
- [ ] Add proper automated tests
- [ ] Add config persistence

## M1 — UI & HUD Editor
- [ ] Native settings screen and modules search
- [ ] Theme tokens, scale/opacity and keybind editor
- [ ] HUD layout, anchors, drag-and-drop

## M2 — Essential Utilities
- [ ] FPS/ping/coordinates, item durability, potion and health alerts
- [ ] Chat filters and manual shortcuts
- [ ] Inventory notifications

## M3 — Navigation & Survival
- [ ] Waypoints, death markers, per-world isolation
- [ ] Visited-chunk minimap, fullscreen map
- [ ] Survival reminders and material checklist

## M4 — PvP Information & Profiles
- [ ] CPS/attack cooldown/armor HUD, no combat automation
- [ ] Per-server presets and manual reconnect

## M5 — Optional Paper Server Bridge
- [ ] Versioned handshake and capability policy
- [ ] Economy/claim/quest adapters with server-side permission checks

## M6 — Optimization and Release
- [ ] Compatibility matrix (vanilla servers, Paper, Sodium, Iris)
- [ ] Benchmark and memory profiling
- [ ] Reproducible release and Modrinth metadata

Release gates: no feature is considered shipped until it builds, passes tests and is verified in-game.
