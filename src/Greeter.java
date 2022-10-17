import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

final class Greeter {
    private static final String[] GREETINGS = {"Hallo", "Griasdi", "Servas", "Guten Morgen", "Hi", "Herzlich Willkommen"};

    public static void main(String[] args) throws IOException {
        final Path fileToRead = Path.of(args[0]);
        final List<String> lines = Files.readAllLines(fileToRead);
        final List<String> firstNames = new ArrayList<>();
        for (String line : lines) {
            final String[] parts = line.split(" ");
            if (parts.length < 1) {
                continue;
            }
            firstNames.add(parts[0]);
        }
        Collections.sort(firstNames);
        for (String firstName : firstNames) {
            final int greetingIndex = ThreadLocalRandom.current().nextInt(GREETINGS.length);
            final String greeting = GREETINGS[greetingIndex] + " ";
            System.out.println(greeting + firstName + "!");
        }
    }
}