package Server;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.codehaus.jackson.JsonProcessingException;

import java.io.*;

public class Serializer {
    public void serializadorString() throws JsonProcessingException, com.fasterxml.jackson.core.JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(new Prueba());
    }
    public void deserializadorString() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Prueba value = xmlMapper.readValue("<Prueba><x>1</x><y>2</y></Prueba>", Prueba.class);
    }
    public void serializadorFile() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("Prueba.xml"), new Prueba());
        File file = new File("Prueba.xml");


}
    public void deserializadorFile() throws IOException {
        File file = new File("Prueba.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        Prueba value = xmlMapper.readValue(xml, Prueba.class);
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
