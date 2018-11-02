package Server;

import Logic.Lists.SendList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Serializer {

    final static Logger logger = LoggerFactory.getLogger(Serializer.class);

    /**
     * Method to serialize a list
     * @param sendList Sendlist that will be converted to xml.
     * @return XMl of the the list
     * @throws IOException ni case an error happens.
     */
    public static String serializadorString(SendList sendList) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(sendList);
        logger.info("Serializing list to xml.");
        return xml;
    }

    /**
     * Method to deserealize an xml to list.
     * @param xml Xml that will be converted.
     * @return Sendlist created from the XML
     * @throws IOException in case an error happens.
     */
    public static SendList deserializadorString(String xml) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        SendList value = xmlMapper.readValue(xml, SendList.class);
        logger.info("Deserialize xml to list.");
        return value;
    }

}
