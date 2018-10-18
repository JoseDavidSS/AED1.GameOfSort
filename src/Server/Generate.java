package Server;

import GUI.Holder;
import Game.Dragon;
import Logic.Lists.DragonList;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Generate",urlPatterns = "generate")
public class Generate extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String dragons = request.getParameter("dragons");
        int Dragons = Integer.parseInt(dragons);
        response.getWriter().println(Dragons);
        //Insertar codigo para crear lista de dragones
        //codificar dList y enviarla
    }
}

