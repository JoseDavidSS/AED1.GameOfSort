package Server;

import Game.Dragon;
import Game.GameUtil;
import Logic.Lists.DragonList;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import static oracle.jrockit.jfr.events.Bits.intValue;

@WebServlet(name = "Generate", urlPatterns = "generate")

public class Generate extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String dragons = request.getParameter("dragons");
        int Dragons = Integer.parseInt(dragons);
        response.getWriter().println(Dragons);

        int i = 0;
        int y = 5;
        int x = 900;
        boolean fLine = false;
        boolean first = false;
        int age;
        int rSpeed;
        int resistence;
        String dragonName;
        String clas;
        while (i != Dragons) {
            dragonName = GameUtil.generateName();
            age = intValue(Math.random() * 1000);
            rSpeed = intValue(Math.random() * 100);
            resistence = intValue(Math.random() * 3 + 0);
            clas = "Captain";
            if (!first) {
                first = true;
                clas = "Commander";
                resistence = 2;
            }
            if (resistence < 2) {
                clas = "Infantry";
            }
            Dragon dragon = new Dragon(resistence, dragonName, rSpeed, age, clas, x, y, 80, 140, "file:src/Media/Enemies/Nightfury.gif");
            DragonList.getInstance().addEnemy(dragon);
            y += 70;
            if (i % 10 == 0 && i != 0) {
                y = 5;
                if (!fLine) {
                    x += 800;
                    fLine = true;
                } else {
                    x += 500;
                }
            }
            i++;
        }
    }
}

