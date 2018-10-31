package Server;

import Logic.Lists.SendList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SerializerTest {

    @Test
    void serializadorString() throws IOException {
        SendList sendList = new SendList();
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(1, 65, "Commander", 12, 100, 2, "Jose", 2);
        sendList.addData(900, 35, "Commander", 1, 100, 3, "Jose", 2);
        assertEquals("<SendList><head><next><next><next/><dragonData><name>Jose</name><dAge>900</dAge><dRSpeed>35</dRSpeed><resistence>2</resistence><dClas>Commander</dClas><posx>1</posx><posy>100</posy><id>3</id></dragonData></next><dragonData><name>Jose</name><dAge>1</dAge><dRSpeed>65</dRSpeed><resistence>2</resistence><dClas>Commander</dClas><posx>12</posx><posy>100</posy><id>2</id></dragonData></next><dragonData><name>Kevin</name><dAge>1</dAge><dRSpeed>33</dRSpeed><resistence>1</resistence><dClas>Infantry</dClas><posx>50</posx><posy>100</posy><id>1</id></dragonData></head><large>3</large><leftest>1</leftest></SendList>", Serializer.serializadorString(sendList));
    }

    @Test
    void deserializadorString() throws IOException {
        SendList sendList = new SendList();
        sendList.addData(1, 33, "Infantry", 50, 100, 1, "Kevin", 1);
        sendList.addData(1, 65, "Commander", 12, 100, 2, "Jose", 2);
        sendList.addData(900, 35, "Commander", 1, 100, 3, "Jose", 2);
        SendList sendList2 = Serializer.deserializadorString("<SendList><head><next><next><next/><dragonData><name>Jose</name><dAge>900</dAge><dRSpeed>35</dRSpeed><resistence>2</resistence><dClas>Commander</dClas><posx>1</posx><posy>100</posy><id>3</id></dragonData></next><dragonData><name>Jose</name><dAge>1</dAge><dRSpeed>65</dRSpeed><resistence>2</resistence><dClas>Commander</dClas><posx>12</posx><posy>100</posy><id>2</id></dragonData></next><dragonData><name>Kevin</name><dAge>1</dAge><dRSpeed>33</dRSpeed><resistence>1</resistence><dClas>Infantry</dClas><posx>50</posx><posy>100</posy><id>1</id></dragonData></head><large>3</large><leftest>1</leftest></SendList>");
        assertEquals(sendList.head.getDragonData().getID(), sendList2.head.getDragonData().getID());
        assertEquals(sendList.head.next.getDragonData().getID(), sendList2.head.next.getDragonData().getID());
        assertEquals(sendList.head.next.next.getDragonData().getID(), sendList2.head.next.next.getDragonData().getID());
    }
}