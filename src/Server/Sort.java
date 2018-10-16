package Server;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Sort",urlPatterns = "sort")
public class Sort extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //String contenido = request.getParameter("Contenido");
        response.getWriter().println("Hola");
    }
}
