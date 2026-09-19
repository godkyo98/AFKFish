# 🎣 AFKFish

![Minecraft Version](https://img.shields.io/badge/Minecraft-26.2%20%7C%2026.3-2ea44f?style=for-the-badge&logo=minecraft)
![Platform](https://img.shields.io/badge/Fabric-Client--Side-E3C95A?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

**AFKFish** is a client-side Fabric mod that automatically reels in and recasts your fishing rod when a fish bites, making the AFK fishing experience seamless, secure, and optimal.

---

## ✨ Features

* 🔄 **Auto Reel & Recast:** Automatically detects fish bites to instantly reel in and cast the line again.
* 🎒 **MultiRod Hotbar Cycling:** Automatically switches to the next fishing rod on your hotbar when the current one runs low on durability or breaks.
* 🛡️ **Rod Break Protection:** Automatically halts usage or cycles rods when durability drops to a critical threshold to prevent breaking valuable equipment.
* ⏱️ **Persistent Mode:** Keeps the fishing loop active consistently and reliably.
* 🔊 **Multiplayer Sound Detection:** Accurately isolates your own bite sound events even on crowded multiplayer servers.
* 🧹 **ClearLag Pattern Support:** Detects ClearLag ground-clearing chat notifications and automatically recasts the rod if your bobber gets cleared.
* ⚙️ **In-Game Configuration Screen:** Offers a convenient settings interface with customizable keybinds and seamless **Mod Menu** integration.
* 🌐 **Multi-Language Support:** Bundled with multiple localization files, including English (`en_us`, `en_gb`), Vietnamese (`vi_vn`), and more.

---

## 📌 Compatibility

* **Minecraft:** `26.2` & `26.3`
* **Fabric Loader:** `>= 0.18.5`
* **Java:** Target runtime versions (Java 21 / Java 25)

---

## 📥 Installation

1. Install **Fabric Loader** compatible with your Minecraft version.
2. Place **Fabric API** into your `.minecraft/mods` directory.
3. *(Optional)* Install **Cloth Config** to enable the in-game settings screen.
4. *(Optional)* Install **Mod Menu** to access configuration directly from the mods list.
5. Drop the **AFKFish** `.jar` file into your `mods` folder.

---

## 🎮 Controls

* Press **`V`** (default) to open the in-game Autofish configuration menu.
* Keybindings can be customized under Minecraft's **Options -> Controls** menu.

---

## 🔨 Building from Source

To compile the mod manually from source:

```bash
# On Linux / macOS
./gradlew build

# On Windows
gradlew.bat build
The compiled binaries will be output to build/libs/.
```

📖 Documentation & Notes
For detailed configuration guides and release notes, refer to docs/DOCUMENTATION.md.
