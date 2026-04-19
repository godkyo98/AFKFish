# AFKFish

AFKFish is a client-side Fabric mod that automatically reels in and recasts your fishing rod when a fish bites.

## Features

- Automatic reel and recast loop
- MultiRod hotbar cycling
- Rod break protection
- Persistent mode to keep fishing active
- Multiplayer sound detection
- ClearLag chat pattern support
- Config screen with keybind and Mod Menu integration

## Compatibility

- Minecraft `26.1.x`
- Fabric Loader `>= 0.18.5`
- Java `25`

## Installation

1. Install Fabric Loader for Minecraft `26.1.x`.
2. Install Fabric API.
3. Install Cloth Config if you want to use the in-game settings screen.
4. Install Mod Menu if you want settings integration from the mod list.
5. Put the `AFKFish` jar in your `mods` folder.

## Controls

- Press `V` to open the Autofish settings screen.

## Building

```bash
./gradlew build
```

The built jars are generated in `build/libs/`.

## Documentation

Detailed usage, configuration and release notes are documented in [docs/DOCUMENTATION.md](docs/DOCUMENTATION.md).
