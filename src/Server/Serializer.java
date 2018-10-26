package Server;

import Logic.Lists.SendList;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Serializer {

    public static String serializadorString(SendList sendList) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(sendList);
        return xml;
    }

    public static SendList deserializadorString(String xml) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        SendList value = xmlMapper.readValue(xml, SendList.class);
        return value;
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
