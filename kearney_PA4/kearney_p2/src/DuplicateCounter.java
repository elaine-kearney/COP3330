import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class DuplicateCounter {
    private Map<String, Integer> hashMap;

    public void count(String dataFile) {
        hashMap = new HashMap<String, Integer>();
        String input;

        try {
            File file = new File(dataFile);
            System.out.println(file.getCanonicalPath());
            Scanner in = new Scanner(file);

            while(in.hasNext()) {
                input = in.next().toLowerCase().replaceAll("[.,!\"']", "");

                hashMap.computeIfPresent(input, (k,v) -> v+1);
                hashMap.putIfAbsent(input, 1);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String outputFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);

            for (String key : hashMap.keySet()) {
                fileWriter.write(key + " : " + Integer.toString(hashMap.get(key)) + "\n");
            }

            fileWriter.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


