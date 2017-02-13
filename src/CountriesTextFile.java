import java.io.*;
import java.nio.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Jeff Choi on 2/13/17.
 */
public class CountriesTextFile {
    private Path filePath = Paths.get("countries.txt");
    private File countriesFile = filePath.toFile();

    public void writeFile(String country) {

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(countriesFile, true));

            out.println(country);
            out.close();


        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void readFile() {
        try {
            FileReader r = new FileReader(countriesFile);
            BufferedReader in = new BufferedReader(r);

            String line = in.readLine();

            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








}
