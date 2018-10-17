package Server;

import Logic.Lists.TemporalList;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Sort",urlPatterns = "sort")
public class mainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String command = request.getParameter("command");
        String contenido = request.getParameter("contenido");

        //Decodificar y transformar en lista el contenido si recibe algun contenido

        TemporalList lista;

        if (command == "sort"){
            Sort sort = Sort.getInstance();
            switch (sort.getRound()){
                case 0: lista = sort.selectionSort(null);
                case 1: lista = sort.insertionSort(null);
                case 2: lista = sort.quickSort(null);
                case 3: lista = sort.binaryThree(null);
                case 4: lista = sort.AVL(null);
            }
        }
        else if(command == "generate"){
            //Crear lista
        }
        //Returnar la lista
    }
}
