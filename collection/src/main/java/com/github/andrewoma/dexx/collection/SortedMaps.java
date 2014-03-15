/*
 * Copyright (c) 2014 Andrew O'Malley
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.andrewoma.dexx.collection;

import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class SortedMaps {
    private SortedMaps() {
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <K extends Comparable<? super K>, V> SortedMap<K, V> of() {
        return SortedMaps.<K, V>construct();
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <K extends Comparable<? super K>, V> SortedMap<K, V> of(K k, V v) {
        return construct(p(k, v));
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <K extends Comparable<? super K>, V> SortedMap<K, V> of(K k1, V v1, K k2, V v2) {
        return construct(p(k1, v1), p(k2, v2));
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <K extends Comparable<? super K>, V> SortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return construct(p(k1, v1), p(k2, v2), p(k3, v3));
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <K extends Comparable<? super K>, V> SortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return construct(p(k1, v1), p(k2, v2), p(k3, v3), p(k4, v4));
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <K extends Comparable<? super K>, V> SortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return construct(p(k1, v1), p(k2, v2), p(k3, v3), p(k4, v4), p(k5, v5));
    }

    private static <K extends Comparable<? super K>, V> Pair<K, V> p(K k, V v) {
        return new Pair<K, V>(k, v);
    }

    private static <K extends Comparable<? super K>, V> SortedMap<K, V> construct(Pair<K, V>... pairs) {
        SortedMap<K, V> map = new TreeMap<K, V>();
        for (Pair<K, V> pair : pairs) {
            map = map.put(pair.component1(), pair.component2());
        }
        return map;
    }

    @NotNull
    public static <K extends Comparable<? super K>, V> SortedMap<K, V> copyOf(java.lang.Iterable<Pair<K, V>> iterable) {
        SortedMap<K, V> result = new TreeMap<K, V>();
        for (Pair<K, V> pair : iterable) {
            result = result.put(pair.component1(), pair.component2());
        }

        return result;
    }

    @NotNull
    public static <K extends Comparable<? super K>, V> SortedMap<K, V> copyOf(Pair<K, V>[] pairs) {
        SortedMap<K, V> result = new TreeMap<K, V>();
        for (Pair<K, V> pair : pairs) {
            result = result.put(pair.component1(), pair.component2());
        }
        return result;
    }

    @NotNull
    public static <K extends Comparable<? super K>, V> SortedMap<K, V> copyOfTraversable(Traversable<Pair<K, V>> traversable) {
        @SuppressWarnings("unchecked")
        final SortedMap<K, V>[] result = new TreeMap[1];
        result[0] = new TreeMap<K, V>();
        traversable.forEach(new Function<Pair<K, V>, Object>() {
            @Override
            public Object invoke(Pair<K, V> pair) {
                result[0] = result[0].put(pair.component1(), pair.component2());
                return null;
            }
        });

        return result[0];
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <K extends Comparable<? super K>, V> BuilderFactory<Pair<K, V>, SortedMap<K, V>> factory() {
        return (BuilderFactory) TreeMap.<K, V>factory(null, null);
    }

    @NotNull
    public static <K extends Comparable<? super K>, V> Builder<Pair<K, V>, SortedMap<K, V>> builder() {
        return SortedMaps.<K, V>factory().newBuilder();
    }
}