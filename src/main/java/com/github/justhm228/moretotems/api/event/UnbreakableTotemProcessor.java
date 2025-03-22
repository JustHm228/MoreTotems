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

package com.github.justhm228.moretotems.api.event;

import com.github.justhm228.moretotems.api.MoreTotemsAPI;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

final class UnbreakableTotemProcessor extends TotemUsageProcessor {

	private static final UnbreakableTotemProcessor INSTANCE;

	static {

		INSTANCE = new UnbreakableTotemProcessor();
	}

	private UnbreakableTotemProcessor() {

		super();
	}

	static UnbreakableTotemProcessor getInstance() {

		return INSTANCE;
	}

	@Override()
	public boolean test(final EntityResurrectEvent e) {

		if (e.isCancelled()) {

			return false;
		}

		final ItemStack totem = findTotem(e);

		return totem != null && totem.getItemMeta().isUnbreakable();
	}

	@Override()
	public void accept(final EntityResurrectEvent e, final MoreTotemsAPI api) {

		final ItemStack totem = findTotem(e).clone();

		final Plugin plugin = api.getAsPlugin();

		plugin.getServer().getScheduler().runTaskLater(plugin, () -> rollbackTotem(e, totem, false), 1L);
	}
}
