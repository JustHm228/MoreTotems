/*
 * The MIT License
 *
 * Copyright (c) 2025 Chirkunov Egor
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

package com.github.justhm228.moretotems.event;

import com.github.justhm228.moretotems.MoreTotems;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import static java.util.Objects.requireNonNull;

public final class TotemListener implements Listener {

	private final MoreTotems plugin;

	public TotemListener(final MoreTotems plugin) throws NullPointerException {

		super();
		this.plugin = requireNonNull(plugin);
	}

	@EventHandler(ignoreCancelled = true)
	public void onTotemActivated(final EntityResurrectEvent e) {

		final LivingEntity entity = e.getEntity();

		final EquipmentSlot slot = e.getHand();

		final ItemStack totem = findTotem(entity, slot);

		if (totem != null) {

			final ItemStack finalTotem = totem.clone();

			final ItemMeta meta = totem.getItemMeta();

			if (meta.isUnbreakable()) {

				plugin.getServer().getScheduler().runTaskLater(plugin, () -> restoreTotem(entity, slot, finalTotem), 1L);
			}
		}
	}

	private ItemStack findTotem(final LivingEntity entity, final EquipmentSlot slot) {

		ItemStack totem = null;

		if (slot != null) {

			if (entity instanceof HumanEntity player) {

				final PlayerInventory inv = player.getInventory();

				totem = switch (slot) {

					case HAND -> inv.getItemInMainHand();
					case OFF_HAND -> inv.getItemInOffHand();

					// This should never happen:
					case FEET -> inv.getBoots();
					case LEGS -> inv.getLeggings();
					case CHEST -> inv.getChestplate();
					case HEAD -> inv.getHelmet();
				};

			} else {

				final EntityEquipment equipment = entity.getEquipment();

				if (equipment != null) {

					totem = equipment.getItem(slot);
				}
			}
		}

		return totem;
	}

	private void restoreTotem(final LivingEntity entity, final EquipmentSlot slot, final ItemStack totem) {

		if (entity instanceof HumanEntity player) {

			final PlayerInventory inv = player.getInventory();

			switch (slot) {

				case HAND -> inv.setItemInMainHand(totem);
				case OFF_HAND -> inv.setItemInOffHand(totem);

				// This should never happen:
				case FEET -> inv.setBoots(totem);
				case LEGS -> inv.setLeggings(totem);
				case CHEST -> inv.setChestplate(totem);
				case HEAD -> inv.setHelmet(totem);
			}

		} else {

			final EntityEquipment equipment = entity.getEquipment();

			if (equipment != null) {

				equipment.setItem(slot, totem, true);
			}
		}
	}
}
