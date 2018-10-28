package Server;

import Logic.Lists.SendList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Serializer {

    /**
     * Method to serialize a list
     * @param sendList Sendlist that will be converted to xml.
     * @return XMl of the the list
     * @throws IOException ni case an error happens.
     */
    public static String serializadorString(SendList sendList) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(sendList);
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
        return value;
    }

}
