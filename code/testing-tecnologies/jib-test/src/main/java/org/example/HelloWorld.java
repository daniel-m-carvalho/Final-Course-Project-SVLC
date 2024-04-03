package org.example;

import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(HelloWorld.class.getResourceAsStream("/world")), StandardCharsets.UTF_8)) {
            String world = CharStreams.toString(reader);
            System.out.println("Hello " + world);
        }
    }
}