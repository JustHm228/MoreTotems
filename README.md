## MoreTotems

**MoreTotems** is a simple Paper plugin which adds some minor tweaks to Totems of Undying.

## Quick Start

### Installation:

Please ensure that you have the following software installed:
 - [Java](<https://www.oracle.com/java/>) \($\ge$ 11 LTS\)
 - [Minecraft](<https://minecraft.net/>) \($\ge$ 1.19.4\)
 - [Paper](<https://papermc.io/>) \($\ge$ 1.19.2 build 
   [#191](<https://github.com/PaperMC/Paper-Archive/commit/928bcc8d3a058221146cea1de7d42d7e178e78f2>)\)

To install the plugin on your Minecraft server, you should:
1. Download the [lastest](<../../releases/latest>) version.
2. Place it to the ``plugins`` directory in the root of the server.
3. Restart the server.

### Features:

 - **"Unbreakable" Totems of Undying.** A Totem of Undying with the 
   [``Unbreakable`` tag](<https://minecraft.wiki/w/Data_component_format#unbreakable>) set will not disappear when used.
   To get such totem you can use one of the following commands:
   - $\le$ 1.20.4: ``/minecraft:give @s minecraft:totem_of_undying{Unbreakable:1b} 1``
   - $\ge$ 1.20.5: ``/minecraft:give @s minecraft:totem_of_undying[minecraft:unbreakable={}] 1``
 - **Enchantments for Totems of Undying:**
   - **[Unbreaking](https://minecraft.wiki/w/Unbreaking).** Every Totem of Undying enchanted with Unbreaking of 
     $n$ level has a $(\frac{100}{n+1})$% chance that it will disappear when used. Otherwise, it will not. So, 
     the Totem of Undying enchanted with Unbreaking of 3 level has a 75% chance that it will not disappear when 
     used.

### Configuration:

Coming soon!

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
