package main;

import java.io.InputStream;

public final class ResourceLoader {
    private ResourceLoader() {
    }

    public static InputStream openResource(Class<?> anchor, String... candidates) {
        for (String candidate : candidates) {
            String path = candidate.startsWith("/") ? candidate : "/" + candidate;
            InputStream is = anchor.getResourceAsStream(path);
            if (is != null) {
                return is;
            }
        }
        throw new IllegalArgumentException("Resource not found: " + String.join(", ", candidates));
    }
}
