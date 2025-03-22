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

package com.github.justhm228.moretotems.internal.event;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityResurrectEvent;
import com.github.justhm228.moretotems.api.MoreTotemsAPI;
import static java.util.Objects.requireNonNull;

// Handles custom mechanics, added for Totems of Undying by this plugin
public final class TotemListener implements Listener {

	private final MoreTotemsAPI api; // The API instance

	public TotemListener(final MoreTotemsAPI api) throws NullPointerException {

		super();
		this.api = requireNonNull(api); // The API instance is required to register `TotemListener`
	}

	@EventHandler(ignoreCancelled = true)
	public void onTotemUse(final EntityResurrectEvent e) {

		api.getTotemProcessors().fireProcessors(e);
	}
}
