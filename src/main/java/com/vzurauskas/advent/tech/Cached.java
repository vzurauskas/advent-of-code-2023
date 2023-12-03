package com.vzurauskas.advent.tech;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Supplier;

public final class Cached<T> implements Supplier<T> {
    private final Supplier<T> origin;
    private T cached;

    public Cached (Checked<T> checked) {
        this((Supplier<T>) () -> unchecked(checked));
    }

    public Cached(Supplier<T> origin) {
        this.origin = origin;
    }

    @Override
    public T get() {
        if (cached == null) {
            cached = origin.get();
        }
        return cached;
    }

    private static <T> T unchecked(Checked<T> checked) {
        try {
            return checked.value();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public interface Checked<T> {
        T value() throws IOException;
    }
}
