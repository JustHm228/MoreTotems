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

import com.github.justhm228.moretotems.api.MoreTotemsAPI;
import com.github.justhm228.moretotems.api.event.TotemUsageProcessor;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public final class TotemUnbreakingProcessor extends TotemUsageProcessor {

	private static final Enchantment UNBREAKING;

	private static final int HASH_CODE;

	private static final TotemUnbreakingProcessor INSTANCE;

	static {

		{

			Enchantment unbreaking = Enchantment.getByKey(NamespacedKey.minecraft("unbreaking"));

			if (unbreaking == null) {

				try {

					unbreaking = Enchantment.DURABILITY;

				} catch (final NoSuchFieldError ignored) {

				}
			}

			UNBREAKING = unbreaking;
		}

		HASH_CODE = Objects.hash(TotemUnbreakingProcessor.class);
		INSTANCE = new TotemUnbreakingProcessor();
	}

	private TotemUnbreakingProcessor() {

		super();
	}

	static TotemUnbreakingProcessor getInstance() {

		return INSTANCE;
	}

	private static float getDamageProbability(final int lvl) {

		// Calculate the probability of item (enchanted with Unbreaking) to be damaged on use:
		return (100.0F / (lvl + 1.0F)) / 100.0F;  // (see https://minecraft.wiki/w/Unbreaking#Usage for details)
	}

	@Override()
	public boolean test(final EntityResurrectEvent e) {

		if (e.isCancelled()) {

			return false;
		}

		final ItemStack totem = findTotem(e);

		return totem != null && totem.containsEnchantment(UNBREAKING);
	}

	@Override()
	public void accept(final EntityResurrectEvent e, final MoreTotemsAPI api) {

		final ItemStack totem = findTotem(e).clone();

		final float chance = getDamageProbability(totem.getEnchantmentLevel(UNBREAKING));

		if (ThreadLocalRandom.current().nextFloat(0.0F, 1.0F) < chance) {

			final Plugin plugin = api.getAsPlugin();

			plugin.getServer().getScheduler().runTaskLater(plugin, () -> rollbackTotem(e, totem, false), 1L);
		}
	}

	@Override()
	public String toString() {

		return super.toString();
	}

	@Override()
	public boolean equals(final Object another) {

		return another instanceof TotemUnbreakingProcessor;
	}

	@Override()
	public int hashCode() {

		return HASH_CODE;
	}
}
