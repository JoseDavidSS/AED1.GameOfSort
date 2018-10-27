package Server;

import Logic.Lists.SendList;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Server {
    static int count = 1;

    public static SendList generate(int dragons) throws IOException {
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
        return  Serializer.deserializadorString(builder.toString());
    }

    public static SendList sort(SendList list) throws IOException{
        String XML = Serializer.serializadorString(list);
        String method = "";
        switch (count) {
            case 1:
                method = "selection";
                count++;
                break;

            case 2:
                method = "insertion";
                count++;
                break;
            case 3:
                method = "quicksort";
                count++;
                break;
            case 4:
                method = "btree";
                count++;
                break;
            case 5:
                method = "avl";
                count = 1;
                break;
        }
        URL url = new URL("http://localhost:9080/Progra_2_war_exploded/GOS/sort?method=" + method + "&list=" + XML );
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        InputStreamReader reader = new InputStreamReader(con.getInputStream());
        char[] buffer = new char[1024];
        int leidos = 0;
        StringBuilder builder = new StringBuilder();
        while ((leidos = reader.read(buffer))>0){
            builder.append(new String(buffer,0,leidos));
        }
        return Serializer.deserializadorString(builder.toString());
    }
}
