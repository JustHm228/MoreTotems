/*
 * The MIT License
 *
 * Copyright (c) 2025 JustHuman228
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.justhm228.moretotems;

import com.github.justhm228.moretotems.event.TotemListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoreTotems extends JavaPlugin implements MoreTotemsAPI {

	private TotemListener totemListener; // A singleton instance of `TotemListener`

	public MoreTotems() {

		super();
	}

	public TotemListener getTotemListener() {

		return totemListener; // Provide a singleton instance of `TotemListener`
	}

	@Override()
	public Plugin getAsPlugin() {

		return this;
	}

	@Override()
	public void onLoad() {

		// Load the plugin:
		super.onLoad();
	}

	@Override()
	public void onEnable() {

		// Enable the plugin:
		super.onEnable();

		// Register event listeners for Totems of Undying:
		final TotemListener totemListener = new TotemListener(this);

		getServer().getPluginManager().registerEvents(totemListener, this);
		this.totemListener = totemListener;
	}

	@Override()
	public void onDisable() {

		// Disable the plugin:
		super.onDisable();
	}
}
