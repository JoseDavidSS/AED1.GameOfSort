package Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class mainTest {

    public static void main(String[] args){
        try {
            String url = "http://localhost:9080/Progra_2_war_exploded/generate?dragons=8";
            URLConnection conn = new URL(url).openConnection();
            try (InputStream stream = conn.getInputStream();
                 Scanner sc = new Scanner(stream, "UTF-8")) {
                sc.useDelimiter("\\A");
                if (sc.hasNext()) {
                    System.out.printf("Respuesta: %s", sc.next());
                }
            }
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }
}
