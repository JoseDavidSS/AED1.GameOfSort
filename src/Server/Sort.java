package Server;

import Logic.Lists.DragonList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Sort",urlPatterns = "sort")
public class Sort extends HttpServlet {
    int round = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dList = request.getParameter("list");
        //Convertir dList en la lista de dragones
        switch (round){
            case 0:
               // DragonList.getInstance().selectionSort();
                response.getWriter().println("0");
                round++;
                break;
            case 1:
                //Aplicar insertion Sort
                response.getWriter().println("1");
                round++;
                break;
            case 2:
                //Aplicar Quick Sort
                response.getWriter().println("2");
                round++;
                break;
            case 3:
                //Ordenar el árbol
                response.getWriter().println("3");
                round++;
                break;
            case 4:
                //AVL
                response.getWriter().println("4");
                round=0;
                break;
        }
        //Enviar la lista codificada.
    }
}
