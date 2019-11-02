import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class DuplicateRemover {
    private Set<String> hashSet;

    public void remove(String dataFile) {
        hashSet = new HashSet<String>();

        try {
            File file = new File(dataFile);
            Scanner in = new Scanner(file);

            while(in.hasNext())
                hashSet.add(in.next().toLowerCase().replaceAll("[.,!\"']", ""));

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String outputFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            for (String s : hashSet) {
                fileWriter.write(s + " ");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


