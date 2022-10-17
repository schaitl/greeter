import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Grüßer {
    static String[] Grüße = {"Hallo", "Griasdi", "Servas", "Guten Morgen", "Hi", "Herzlich Willkommen"};

    public static void main(String[] args) throws IOException {
        Path Datei = Path.of(args[0]);
        List<String> Zeilen = Files.readAllLines(Datei);
        List<String> Vornamensliste = new ArrayList<>();
        for (String Zeile : Zeilen) {
            String[] Teile = Zeile.split(" ");
            if (Teile.length < 1) {
                continue;
            }
            Vornamensliste.add(Teile[0]);
        }
        Collections.sort(Vornamensliste);
        for (String Vorname : Vornamensliste) {
            final int WelcherGruß = ThreadLocalRandom.current().nextInt(Grüße.length);
            final String Gruß = Grüße[WelcherGruß] + " ";
            System.out.println(Gruß + Vorname + "!");
        }
    }
}