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

import com.github.justhm228.moretotems.MoreTotemsAPI;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import static java.util.Objects.requireNonNull;

public final class TotemProcessors implements Iterable<TotemProcessor<?>> {

	private final MoreTotemsAPI api;

	private final List<TotemProcessorGuard<? extends Event>> processors;

	public TotemProcessors(final MoreTotemsAPI api) throws NullPointerException, IllegalStateException {

		super();

		if (requireNonNull(api).getTotemProcessors() != null) {

			throw new IllegalStateException();
		}

		this.api = api;
		processors = new ArrayList<>();
		initDefault();
	}

	public void hookProcessor(final TotemProcessor<?> processor) {

		processors.add(new TotemProcessorGuard<>(processor));
	}

	public void unhookProcessor(final TotemProcessor<?> processor) {

		processors.removeIf((e) -> e.getGuarded() == processor);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean fireProcessors(final Event e) {

		boolean affected = false;

		for (@SuppressWarnings("rawtypes") final TotemProcessor processor : processors) {

			@SuppressWarnings("unchecked")
			final boolean applicable = processor.test(e);

			if (applicable) {

				try {

					processor.accept(e, api);
					affected = true;

				} catch (final Exception failed) {

					throw new RuntimeException(failed);
				}
			}
		}

		return affected;
	}

	public Stream<? extends TotemProcessor<? extends Event>> stream() {

		return processors.stream();
	}

	@Override()
	public Spliterator<TotemProcessor<? extends Event>> spliterator() {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final Spliterator<TotemProcessor<? extends Event>> result = (Spliterator<TotemProcessor<? extends Event>>) (Spliterator) processors.spliterator();

		return result;
	}

	@Override()
	public @NotNull() Iterator<TotemProcessor<? extends Event>> iterator() {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final Iterator<TotemProcessor<? extends Event>> result = (Iterator<TotemProcessor<? extends Event>>) (Iterator) processors.iterator();

		return result;
	}

	private void initDefault() {

		hookProcessor(UnbreakableTotemProcessor.getInstance());
		hookProcessor(TotemUnbreakingProcessor.getInstance());
	}
}
