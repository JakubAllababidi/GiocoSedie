

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Allababidi Jakub
 */
public class TestGiocoSedie {
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserire il numero di partecipanti: ");
        int numPartecipanti = scanner.nextInt();

        if (numPartecipanti <= 1) {
            System.out.println("Il numero di partecipanti deve essere maggiore di 1.");
            return;
        }

        int numSedie = numPartecipanti - 1; // Il numero di sedie è sempre uno in meno dei partecipanti
        Posto[] sedie = new Posto[numSedie];
        for (int k = 0; k < sedie.length; k++) {
            sedie[k] = new Posto();
        }

        Display display = new Display(sedie);
        logger.info("Sto facendo partire il Display.\n");
        display.start();

        Partecipante[] partecipanti = new Partecipante[numPartecipanti];
        for (int i = 0; i < numPartecipanti; i++) {
            partecipanti[i] = new Partecipante(sedie, i + 1);
            logger.info("Sto facendo partire il thread id: " + partecipanti[i].getId() + " name: " + partecipanti[i].getName() + "\n");
            partecipanti[i].start();
        }

        for (Partecipante p : partecipanti) {
            try {
                p.join();
            } catch (InterruptedException e) {
                logger.severe("Errore nel join dei thread: " + e.getMessage());
            }
        }

        // Salva i risultati in un file
        try (FileWriter writer = new FileWriter("Risultato.txt")) {
            for (Partecipante p : partecipanti) {
                writer.write(p.getRisultato() + "\n");
            }
            System.out.println("Risultati salvati in 'Risultato.txt'.");
        } catch (IOException e) {
            logger.severe("Errore nella scrittura del file: " + e.getMessage());
        }
    }
}
