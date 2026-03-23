# Hydrophobic Elytra 🦅💧

![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.11-success)
![Mod Loader](https://img.shields.io/badge/Modloader-Fabric-orange)
![License](https://img.shields.io/badge/License-CC0_1.0-blue)
![Client Side](https://img.shields.io/badge/✅_100%25_Client--Side-Required-brightgreen)
![Vanilla Servers](https://img.shields.io/badge/✅_Works_on_Vanilla_Servers-Yes-brightgreen)

**Hydrophobic Elytra** is a simple mod for Minecraft (Fabric) that adds a touch of realism and difficulty to the game: **it prevents players from flying or propelling themselves with Elytras while submerged in fluids** (such as water or lava).

<!-- ✨ SUSTITUYE ESTA LÍNEA POR LA URL DE TU GIF (EJ. ![Demostración de Elytras fallando en el agua](https://url-del-gif-aqui.gif) ) ✨ -->

## ✨ Features

* **Restricted flight in fluids:** If you try to open your Elytras underwater, lava, or any other fluid, the mod will cancel the action.
* **In-game Feedback:** Displays a non-intrusive warning message directly on your action bar if you try to fly while wet. Now includes bubbling particles and extinguish sounds!
* **In-game Config:** Now features full ModMenu and ClothConfig integration! Customize which fluids affect you, and toggle sounds or messages directly from the game.
* **Lightweight and optimized:** It uses the official Fabric API events (`EntityElytraEvents.ALLOW`), so it doesn't cause lag or severe conflicts.
* **Client and Server Compatible:** Works flawlessly on multiplayer.

## 📦 Requirements

To play with this mod, you need to install the following:
* Minecraft `1.21.11` 
* Fabric Loader (`>=0.18.4`)
* Fabric API
* Cloth Config API (Recommended for configuration)
* ModMenu (Recommended to access the config menu)
* Java 21

## 🚀 Installation

1. Download the mod's `.jar` file from the [Releases tab](https://github.com/SrParavel/HydrophobicElytra/releases).
2. Make sure you have **Fabric Loader** and **Fabric API** installed.
3. Drag the `.jar` file into your mods folder (`%appdata%\.minecraft\mods` on Windows, `~/.minecraft/mods` on Linux/Mac).
4. Launch the game and enjoy!

## 🛠️ Build from source

If you want to modify the code or build the mod yourself, follow these steps:

1. Clone this repository:
   ```bash
   git clone https://github.com/SrParavel/HydrophobicElytra.git
   ```
2. Open a terminal in the project folder and run Gradle:
   ```bash
   # On Windows
   .\gradlew build

   # On Linux/Mac
   ./gradlew build
   ```
3. Once finished, you will find the compiled mod in the `build/libs/` directory.

*(Optional)* If you are a contributor and want to auto-bump the version metadata during compilation, use:
```bash
.\gradlew build -Prelease
```

## 👥 Authors

* **Paravel**
* **VeritasShield**

## 📄 License

This project is licensed under the **CC0-1.0** (Creative Commons Zero) license. You are free to use, modify, and distribute this code without restrictions.