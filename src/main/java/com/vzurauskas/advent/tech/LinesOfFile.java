package com.vzurauskas.advent.tech;

import com.vzurauskas.advent.Lines;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class LinesOfFile implements Lines {
    private final Cached<List<String>> lines;

    public LinesOfFile(String path) {
        this.lines = new Cached<>(
            (Cached.Checked<List<String>>) () -> Files.lines(
                Paths.get(uri(path))
            ).collect(Collectors.toList())
        );
    }

    private static URI uri(String path) throws IOException {
        try {
            return LinesOfFile.class.getClassLoader().getResource(path).toURI();
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
    }

    @Override
    public Collection<String> value() {
        return lines.get();
    }
}
