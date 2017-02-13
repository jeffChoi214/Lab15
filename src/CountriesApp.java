import java.io.*;
import java.nio.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
 * Created by Jeff Choi on 2/13/17.
 */

public class CountriesApp {
    public static int getUserInput(Scanner sc, Validator validate) {
        int userInput = validate.getInt(sc);

        while (userInput != 1 && userInput != 2
                && userInput != 3 && userInput != 4) {
            System.out.println("Please enter 1, 2, 3, or 4!");
            userInput = validate.getInt(sc);
        }
        return userInput;
    }

    public static void printHeader() {
        System.out.println("");
        System.out.println("1 - See the list of countries");
        System.out.println("2 - Add a country");
        System.out.println("3 - Remove a country");
        System.out.println("4 - Exit");
        System.out.println("");
        System.out.print("Enter menu number: ");
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Validator validate = new Validator();
        CountriesTextFile theFile = new CountriesTextFile();

        while (true) {
            printHeader();
            int userInput = getUserInput(sc, validate);

            if (userInput == 1) {
                theFile.readFile();
            }
            else if (userInput == 2) {
                System.out.print("Enter country: ");
                theFile.writeFile(validate.getString(sc));
            }
            else if (userInput == 3) {
                System.out.print("Enter country to remove: ");
                theFile.deleteFile(validate.getString(sc));
            }
            else {
                // quit program
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
