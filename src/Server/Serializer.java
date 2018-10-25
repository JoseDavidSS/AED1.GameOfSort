package Server;

import Logic.Lists.SendList;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Serializer {

    public static void serializadorString(SendList sendList) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(sendList);
        System.out.println(xml);
        SendList sl = xmlMapper.readValue(xml, SendList.class);
        sl.printAge();
    }

    public static void deserializadorString() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Prueba value = xmlMapper.readValue("<Prueba><x>1</x><y>2</y></Prueba>", Prueba.class);
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
