package Server;

import Logic.Lists.SendList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    @Test
    void generate() throws IOException {
        SendList sendList = Server.generate(10);
        assertEquals(10, sendList.getLarge());
    }

    @Test
    void sort() throws IOException {
        SendList sendList = new SendList();
        sendList.addData(3, 100, "Captain", 1, 1, 1, "Kevin", 1);
        sendList.addData(2, 43, "Infantry", 1, 1, 2, "Kevin", 1);
        sendList.addData(1, 23, "Infantry", 1, 1, 3, "Kevin", 1);
        sendList.addData(4, 64, "Infantry", 1, 1, 4, "Kevin", 1);
        sendList.addData(5, 17, "Infantry", 1, 1, 5, "Kevin", 1);
        sendList = Server.sort(sendList);
        assertEquals(1, sendList.head.getDragonData().getdAge());
        sendList = Server.sort(sendList);
        assertEquals(17, sendList.head.getDragonData().getdRSpeed());
        sendList = Server.sort(sendList);
        assertEquals(1, sendList.head.getDragonData().getdAge());
        sendList = Server.sort(sendList);
        assertEquals(3, sendList.head.getDragonData().getID());
        sendList = Server.sort(sendList);
        assertEquals(1, sendList.head.getDragonData().getdAge());
    }
}