package Server;

import Logic.Lists.SendList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GenerateTest {

    @Test
    void generate() throws IOException {
        Generate generate = new Generate();
        String xml = generate.generate(10);
        SendList sendList = Serializer.deserializadorString(xml);
        assertEquals(10, sendList.getLarge());
    }
}