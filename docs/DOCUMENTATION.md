# AFKFish Documentation

## Overview

AFKFish is a client-side quality-of-life mod for Fabric that automates fishing. It listens for fishing events, reels the rod in when a fish is detected, and casts again after a configurable delay.

## Supported Environment

- Minecraft `26.1.x`
- Fabric Loader `>= 0.18.5`
- Java `25`

## Installation

1. Install Fabric Loader for Minecraft `26.1.x`.
2. Install Fabric API.
3. Add the AFKFish jar to your `mods` folder.
4. Install Cloth Config to use the in-game config screen.
5. Install Mod Menu if you want the config screen accessible from the mods list.

## Controls

- `V`: open the Autofish settings screen

## Configuration File

The config file is stored at:

```text
config/autofish.config
```

The file is JSON-based and uses these fields:

- `isAutofishEnabled`: enables or disables the mod. Default: `true`
- `multiRod`: cycles through fishing rods in the hotbar. Default: `false`
- `noBreak`: stops using rods before they break. Default: `false`
- `persistentMode`: keeps recasting while a rod is held. Default: `false`
- `useSoundDetection`: uses sound-based multiplayer detection. Default: `false`
- `forceMPDetection`: forces multiplayer detection logic in singleplayer. Default: `false`
- `recastDelay`: delay between catch and recast in milliseconds. Default: `1500`
- `clearLagRegex`: chat pattern that triggers a recast. Default: `\\[ClearLag\\] Removed [0-9]+ Entities!`

## In-Game Options

### Basic Options

- `Enable Autofish`: turns the full automation loop on or off
- `Enable MultiRod`: rotates through rods in the hotbar when one breaks
- `Enable Break Protection`: avoids using rods with very low durability
- `Enable Persistent Mode`: keeps checking and recasting when needed

### Advanced Options

- `Use Sound Detection`: more accurate for multiplayer, but requires being close to the bobber
- `Force Multiplayer Detection`: uses multiplayer detection logic even in singleplayer
- `Recast Delay (ms)`: adjusts the delay before recasting
- `ClearLag Chat Pattern`: regex used to detect chat messages that should trigger a recast

## Building From Source

Use the Gradle wrapper from the project root:

```bash
./gradlew build
```

Artifacts are written to `build/libs/`.

## Release Automation

The repository includes a GitHub Actions workflow that:

- runs on pushes to `main` and `master`
- builds the mod with Java `25`
- reads `mod_version` from `gradle.properties`
- reads release notes from `.github/release-notes/<version>.md` when that file exists
- creates or updates a GitHub Release named after the current version
- uploads the jars from `build/libs/`

If you push more than once without changing `mod_version`, the workflow updates the assets for the existing release instead of creating a new tag.
