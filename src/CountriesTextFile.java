import java.io.*;
import java.nio.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
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
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String country) {
        ArrayList<String> countries = new ArrayList<>();

        try {
            FileReader r = new FileReader(countriesFile);
            BufferedReader in = new BufferedReader(r);

            String line = in.readLine();

            while (line != null) {
                if (!line.toLowerCase().equals(country.toLowerCase())) {
                    countries.add(line);
                }
                line = in.readLine();
            }

            in.close();
            r.close();

            PrintWriter out = new PrintWriter(new FileOutputStream(countriesFile, false));

            for (int i = 0; i < countries.size(); ++i) {
                out.println(countries.get(i));
            }
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
