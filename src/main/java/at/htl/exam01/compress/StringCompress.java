package at.htl.exam01.compress;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class StringCompress {

    private static final String FILE_NAME = "sample.txt";

    /**
     * Main-Methode, hier wird das StringCompress-Objekt erstellt
     * und die Methoden des Objekts werden aufgerufen
     *
     * @param args
     */
    public static void main(String[] args) {
        StringCompress sc = new StringCompress();
        String[] text = sc.readFromFile(FILE_NAME);
        sc.print(text);

        int lines = getNoOfLines(FILE_NAME);

        print(readFromFile(FILE_NAME));
    }




    /**
     *
     * Sämtliche Zeilen werden aus der Textdatei eingelesen
     * zB 5A
     * Nun wird in das String-Array AAAAA geschrieben
     *
     * Bsp Testdatei
     * 5A
     * 3B
     * 4C
     *
     * ergibt eine String-Array mit 3 Elementen
     * AAAAA
     * BBB
     * CCCC
     *
     * @param fileName
     * @return String-Array mit dem entpacktem Text
     */
    public static String[] readFromFile(String fileName) {

        String filename = new String();

        int lines = getNoOfLines(FILE_NAME);

        String[] letter = new String[28];

        int i = 0;

        try(Scanner scanner = new Scanner(new FileReader(FILE_NAME))){

            while (scanner.hasNextLine()){

                letter[i] = scanner.nextLine();

                i++;

            }
        } catch (FileNotFoundException e) {

            System.err.println(e.getMessage());

        }


        return letter;
    }


    /**
     * Der Inhalt des String-Arrays wird zeilenweise auf der Console ausgegeben
     *
     *
     * @param lines String-Array
     */
    public static void print(String[] lines) {

        System.out.println(lines);

        int i = 0;

        while(i < getNoOfLines(FILE_NAME)){

            readFromFile(FILE_NAME);

        }

    }

    /**
     * Die Anzahl der Zeilen der übergebenen Textdatei wird bestimmt
     *
     * @param fileName
     * @return Anzahl der Zeilen in der Textdatei
     */
    public static int getNoOfLines(String fileName) {

        int lines = 0;

        try(Scanner scanner = new Scanner(new FileReader(FILE_NAME))){

            while(scanner.hasNextLine()){

                lines++;

            }

        } catch (FileNotFoundException e) {

            System.err.println(e.getMessage());

        }

        return lines;
    }
}
