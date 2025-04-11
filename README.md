# MoreTotems

<a href="https://modrinth.com/plugin/moretotems" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/available/modrinth_vector.svg" height="48" alt="modrinth" title="Available on Modrinth">
</a>

<a href="https://hangar.papermc.io/JustHm228/MoreTotems" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/available/hangar_vector.svg" height="48" alt="hangar" title="Available on Hangar">
</a>

<a href="https://github.com/JustHm228/MoreTotems" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/available/github_vector.svg" height="48" alt="github" title="Available on GitHub">
</a>

**MoreTotems** is a simple Paper plugin which adds some minor tweaks to Totems of Undying.

## Quick Start

### Installation:

> [!WARNING]
>
> Please, do not download versions from range:
> [0.1.0-data-1.20.5](https://modrinth.com/datapack/moretotems/version/0.1.0-data-1.20.5)..[0.1.0-1.20.5+mod](https://modrinth.com/datapack/moretotems/version/0.1.0-1.20.5+mod)!
> They are not loading because of #11 (Data pack is not loading on >=1.20.5) and #13 (Data pack never registers objectives).
> 
> So, it is recommended not to use experimental data pack versions of the plugin.

<a href="https://papermc.io" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/supported/paper_vector.svg" height="48" alt="platform-paper" title="Built for Paper">
</a>

<a href="https://www.spigotmc.org" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/unsupported/spigot_vector.svg" height="48" alt="platform-spigot" title="Won't support Spigot">
</a>

Please ensure that you have the following software installed:
 - [Java](<https://www.oracle.com/java/>) \($\ge$ 11 LTS\)
 - [Minecraft](<https://minecraft.net/>) \($\ge$ 1.19.4\)
 - [Paper](<https://papermc.io/>) \($\ge$ 1.19.2 build 
   [#191](<https://github.com/PaperMC/Paper-Archive/commit/928bcc8d3a058221146cea1de7d42d7e178e78f2>)\)

To install the plugin on your Minecraft server, you should:
1. Download the [lastest](<../../releases/latest>) version.
2. Place it to the ``plugins`` directory in the root of the server.
3. Restart the server.

### Experimental versions:

<a href="https://fabricmc.net" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/supported/fabric_vector.svg" height="48" alt="platform-fabric" title="Supports Fabric">
</a>

<a href="https://files.minecraftforge.net" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/supported/forge_vector.svg" height="48" alt="platform-forge" title="Supports Forge">
</a>

<a href="https://quiltmc.net" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/supported/quilt_vector.svg" height="48" alt="platform-quilt" title="Supports Quilt">
</a>

<a href="https://neoforged.net" target="_blank">
  <img src="https://raw.githubusercontent.com/intergrav/devins-badges/74adf3b26de1006e9ec9fcffff17322ae3962f9b/assets/cozy/supported/neoforge_vector-cozy.svg" height="48" alt="platform-neoforge" title="Supports NeoForge">
</a>

#### Disclaimer:

I am currently developing some experimental alpha versions of this plugin,
which can be loaded as vanilla data packs. I recommend not to use them because
of many bugs. So, if you download such experimental version and load it to
your world, please be ready for many serious errors.

### Features:

 - **"Unbreakable" Totems of Undying.** A Totem of Undying with the 
   [``Unbreakable`` tag](<https://minecraft.wiki/w/Data_component_format#unbreakable>) set will not 
   disappear when used. To get such totem you can use one of the following commands:
   - $\le$ 1.20.4: ``/minecraft:give @s minecraft:totem_of_undying{Unbreakable:1b} 1``
   - $\ge$ 1.20.5: ``/minecraft:give @s minecraft:totem_of_undying[minecraft:unbreakable={}] 1``
 - **Enchantments for Totems of Undying:**
   - **[Unbreaking](https://minecraft.wiki/w/Unbreaking).** Every Totem of Undying enchanted with 
     Unbreaking of $n$ level has a $(\frac{100}{n+1})$% chance that it will disappear when used.
     Otherwise, it will not. So, the Totem of Undying enchanted with Unbreaking of 3 level has a 
     75% chance that it will not disappear when used.

### Configuration:

Coming soon!

## Contact me:

<a href="https://github.com/JustHm228" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/social/github-singular_vector.svg" height="48" alt="social-github" title="See me on GitHub">
</a>

<a href="https://discordapp.com/users/825011445509914675" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/social/discord-singular_vector.svg" height="48" alt="social-discord" title="Chat with me on Discord">
</a>

<a href="https://matrix.to/#/@justhm228:matrix.org" target="_blank">
  <img src="https://github.com/intergrav/devins-badges/raw/refs/heads/v3/assets/cozy/social/matrix-singular_vector.svg" height="48" alt="social-matrix" title="Chat with me on Matrix">
</a>

## License

This project and its sources are licensed under the [MIT License](./LICENSE):

```text
MIT License

Copyright (c) 2025 JustHuman228

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
