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

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class MoreTotemsMixin {

	protected MoreTotemsMixin() {

		super();
	}

	protected final ItemStack findTotem(final EntityResurrectEvent e) {

		final LivingEntity entity = e.getEntity();

		final EquipmentSlot slot = e.getHand();

		ItemStack totem = null; // If a Totem of Undying is not found, `null` will be returned

		// If there is a Totem of Undying, it will be found:
		if (slot != null) {

			if (entity instanceof HumanEntity player) {

				// Use the `PlayerInventory` if available
				final PlayerInventory inv = player.getInventory();

				// Find the Totem of Undying:
				totem = switch (slot) {

					case HAND -> inv.getItemInMainHand();
					case OFF_HAND -> inv.getItemInOffHand();

					// This should never happen, but if it somehow happens, here is the code for it:
					case FEET -> inv.getBoots();
					case LEGS -> inv.getLeggings();
					case CHEST -> inv.getChestplate();
					case HEAD -> inv.getHelmet();
				};

			} else {

				// Otherwise, use `EntityEquipment` from Paper API:
				final EntityEquipment equipment = entity.getEquipment();

				if (equipment != null) {

					totem = equipment.getItem(slot);
				}
			}
		}

		return totem;
	}
}
