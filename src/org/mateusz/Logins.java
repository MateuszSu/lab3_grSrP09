package org.mateusz;
import java.io.*;
import java.util.HashMap;

//klasa zawierająca hashmapę z kluczami users i wartościami password oraz metodę ich wczytywania z pliku loginy.csv

public class Logins {
    HashMap<String, String> logins = new HashMap<>(); //utworzenie hash mapy

    void readFromFIle() { //wczytanie danych users i haseł do hash mapy
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader("loginy.csv"));
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(";");
                logins.put(temp[0], temp[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
