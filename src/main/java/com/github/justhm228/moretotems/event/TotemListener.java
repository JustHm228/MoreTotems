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

package com.github.justhm228.moretotems.event;

import com.github.justhm228.moretotems.MoreTotems;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.concurrent.ThreadLocalRandom;
import static java.util.Objects.requireNonNull;

// Handles custom mechanics, added for Totems of Undying by this plugin
public final class TotemListener implements Listener {

	private final MoreTotems plugin; // The plugin instance

	public TotemListener(final MoreTotems plugin) throws NullPointerException {

		super();
		this.plugin = requireNonNull(plugin); // The plugin instance is required to register `TotemListener`
	}

	private static float getDamageProbability(final int lvl) {

		// Calculate the probability of item (enchanted with Unbreaking) to be damaged on use:
		return (100.0F / (lvl + 1.0F)) / 100.0F; // (see https://minecraft.wiki/w/Unbreaking#Usage for details)
	}

	@EventHandler(ignoreCancelled = true)
	public void onTotemActivated(final EntityResurrectEvent e) {

		final LivingEntity entity = e.getEntity(); // An entity that used a Totem of Undying

		final EquipmentSlot slot = e.getHand(); // `EquipmentSlot` was added in build #191

		final ItemStack totem = findTotem(entity, slot); // Find the used Totem of Undying

		// If the used Totem of Undying was found:
		if (totem != null) {

			final ItemStack finalTotem = totem.clone(); // Create the identical copy of the used Totem of Undying

			boolean totemBack = false; // If the Totem of Undying should be rolled back

			final ItemMeta meta = totem.getItemMeta();

			if (meta.isUnbreakable()) { // If the Totem of Undying is unbreakable:

				totemBack = true; // Roll this Totem of Undying back

			} else if (meta.hasEnchant(Enchantment.DURABILITY)) {

				final float chance = getDamageProbability(meta.getEnchantLevel(Enchantment.DURABILITY));

				// If the Totem of Undying will not be broken:
				if (ThreadLocalRandom.current().nextFloat(0.0F, 1.0F) < chance) {

					totemBack = true; // Roll this Totem of Undying back
				}
			}

			if (totemBack) {

				// Roll the Totem of Undying back
				plugin.getServer().getScheduler().runTaskLater(plugin, () -> restoreTotem(entity, slot, finalTotem), 1L);
			}
		}
	}

	private ItemStack findTotem(final LivingEntity entity, final EquipmentSlot slot) {

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

	private void restoreTotem(final LivingEntity entity, final EquipmentSlot slot, final ItemStack totem) {

		if (entity instanceof HumanEntity player) {

			// Use the `PlayerInventory` if available:
			final PlayerInventory inv = player.getInventory();

			// Restore the used Totem of Undying:
			switch (slot) {

				case HAND -> inv.setItemInMainHand(totem);
				case OFF_HAND -> inv.setItemInOffHand(totem);

				// This should never happen, but if it somehow happens, here is the code for it:
				case FEET -> inv.setBoots(totem);
				case LEGS -> inv.setLeggings(totem);
				case CHEST -> inv.setChestplate(totem);
				case HEAD -> inv.setHelmet(totem);
			}

		} else {

			// Otherwise, use `EntityEquipment` from Paper:
			final EntityEquipment equipment = entity.getEquipment();

			if (equipment != null) {

				equipment.setItem(slot, totem, true); // Do not play the equipment sound on replacement
			}
		}
	}
}
