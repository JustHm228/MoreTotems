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

import java.util.Objects;
import org.bukkit.event.Event;
import com.github.justhm228.moretotems.api.MoreTotemsAPI;
import static java.util.Objects.hash;

public class TotemProcessorProxy<E extends Event> implements TotemProcessor<E> {

	protected final TotemProcessor<E> proxied;

	public TotemProcessorProxy(final TotemProcessor<E> proxied) {

		super();
		this.proxied = proxied;
	}

	@Override()
	public boolean test(final E e) {

		return proxied != null && proxied.test(e);
	}

	@Override()
	public void accept(final E e, final MoreTotemsAPI api) {

		if (proxied != null) {

			proxied.accept(e, api);
		}
	}

	@Override()
	public String toString() {

		return getClass().getName() + "[" + proxied + "]";
	}

	@Override()
	public boolean equals(final Object another) {

		return another instanceof TotemProcessorProxy<?> proxy && Objects.equals(proxied, proxy.proxied);
	}

	@Override()
	public int hashCode() {

		return hash(proxied);
	}
}
