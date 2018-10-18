package Server;

import GUI.Holder;
import Game.Dragon;
import Logic.Lists.DragonList;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Sort_1",urlPatterns = "sort_1")
public class Generate extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String dragons = request.getParameter("dragons");
        int Dragons = Integer.parseInt(dragons);
        DragonList dList;
        int i = 0;
        int n = 5;

        while (i != Dragons) {
            Dragon dragon = new Dragon(0, "Hol", 2, 122, "Comandante", 830, n, 80, 140, "file:src/Media/Enemies/Nightfury.gif");
            DragonList.getInstance().addEnemy(dragon);
            n += 70;
            if (i % 10 == 0 && i != 0) {
                n = 5;
            }
            i++;
        }
        dList = DragonList.getInstance();

        //codificar dList y enviarla
    }
}

