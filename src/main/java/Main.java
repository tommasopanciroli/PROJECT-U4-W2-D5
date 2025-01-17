import CatalogoBibliotecario.Libro;
import CatalogoBibliotecario.Periodicità;
import CatalogoBibliotecario.Rivista;
import Exceptions.FunzioneSconosciuta;
import Servizi.FileArchivioSvc;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);
    static FileArchivioSvc archivio = new FileArchivioSvc();

    public static void main(String[] args) {
        Libro libro1 = new Libro("libro1", 2005, 10, "luca", "thriller");
        Libro libro2 = new Libro("libro2", 2010, 10, "mario", "poesia");
        Libro libro3 = new Libro("libro3", 2000, 10, "LUca", "giallo");
        Rivista rivista1 = new Rivista("rivista1", 2010, 50, Periodicità.MENSILE);
        Rivista rivista2 = new Rivista("rivista2", 2005, 50, Periodicità.ANNUALE);
        Rivista rivista3 = new Rivista("rivista1", 2000, 50, Periodicità.SETTIMANALE);
        archivio.addElementManual(libro1, libro2, libro3, rivista1, rivista2, rivista3);

        archiveMenu();
    }

    static Scanner scanner = new Scanner(System.in);
    public static void archiveMenu(){
        System.out.println("\n---MENU ARCHIVIO---");
        System.out.println("1 - Aggiungi elemento all'archivio");
        System.out.println("2 - Rimuovi un elemento");
        System.out.println("3 - Ricerca un elemento");
        System.out.println("4 - Carica file locale");
        System.out.println("0 - Esci dall'applicazione\n");
        System.out.print("Scegli una funzione: ");

        try {
            int function = scanner.nextInt();
            if (function > 4) throw new FunzioneSconosciuta();

            switch (function){
                case 1:
                    archivio.addElement();
                    archiveMenu();
                    break;
                case 2:
                    archivio.deleteElementByISBN();
                    archiveMenu();
                    break;
                case 3:
                    getElement();
                    archiveMenu();
                    break;
                case 4:
                    archivio.load();
                    archiveMenu();
                    break;
                case 0:
                    break;
            }
            scanner.nextLine();
        } catch (InputMismatchException ex){
            logger.error(String.valueOf(ex));
        } catch (FunzioneSconosciuta ex){
            logger.error("Funzione non esistente.");
        }
    }



    private static void getElement(){
        System.out.println("\n1 - ISBN");
        System.out.println("2 - Anno di pubblicazione");
        System.out.println("3 - Autore");
        System.out.print("\nRicerca tramite: ");
        int researchType = scanner.nextInt();
        scanner.nextLine();
        if (researchType == 0 || researchType > 3) throw new FunzioneSconosciuta();
        try {
            switch (researchType){
                case 1:
                    System.out.print("\nInserisci ISBN: ");
                    archivio.getByISBN(scanner.nextInt());
                    scanner.reset();
                    break;
                case 2:
                    System.out.print("\nInserisci anno: ");
                    archivio.getByPublishYear(scanner.nextInt());
                    scanner.reset();
                    break;
                case 3:
                    System.out.print("\nInserisci autore: ");
                    archivio.getByAuthor(scanner.nextLine());
                    scanner.reset();
                    break;
            }
        } catch (FunzioneSconosciuta ex){
            logger.error("Tipo di ricerca selezionata non esistente.");
        }
    }
}
