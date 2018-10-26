package Server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Server {
    public static String generate(int dragons) throws IOException {
        URL url = new URL("http://localhost:9080/Progra_2_war_exploded/GOS/generate?dragons=" + Integer.toString(dragons));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        InputStreamReader reader = new InputStreamReader(con.getInputStream());
        char[] buffer = new char[1024];
        int leidos = 0;
        StringBuilder builder = new StringBuilder();
        while ((leidos = reader.read(buffer))>0){
            builder.append(new String(buffer,0,leidos));
        }
        return builder.toString();
    }
}
