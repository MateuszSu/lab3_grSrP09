package org.mateusz;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Logins {
    HashMap<String, String> logins = new HashMap<>();

    void readFromFIle() {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader("loginy.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] temp = line.split(";");
                logins.put(temp[0],temp[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*for (Map.Entry<String, String> entry : logins.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }*/
    }
}
