package Server;


import Game.GameUtil;
import Logic.Lists.SendList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.awt.*;
import java.io.IOException;

import static oracle.jrockit.jfr.events.Bits.intValue;

@Path("generate")
public class Generate {
    @GET
    @Produces("application/xml")
    public String generate(@QueryParam("dragons") int dragons) throws IOException {//Recibe cantidad dragones
        int i = 0;
        int y = 15;
        int x = 900;
        boolean fLine = false;
        boolean first = false;
        int age;
        int rSpeed;
        int resistence;
        String dragonName;
        String clas;
        int id = 1;
        SendList sl = new SendList();
        while (i != dragons){
            dragonName = GameUtil.generateName();
            age = intValue(Math.random() * 1000);
            rSpeed = intValue(Math.random() * 100);
            resistence = intValue(Math.random() * 3 + 0);
            clas = "Captain";
            if (!first){
                first = true;
                clas = "Commander";
                resistence = 2;
            }
            if (resistence < 2){
                clas = "Infantry";
            }
            sl.addData(age, rSpeed, clas, x, y, id, dragonName, resistence);
            y += 70;
            if (i % 9 == 0 && i != 0){
                y = 15;
                if (!fLine){
                    x += 400;
                    fLine = true;
                }
                else{
                    x += 400;
                }
            }
            i++;
            id++;
        }
        return Serializer.serializadorString(sl);

    }
}
