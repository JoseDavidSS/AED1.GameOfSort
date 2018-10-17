package Server;

import Game.Dragon;
import Logic.Lists.DragonList;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Sort_1",urlPatterns = "sort_1")
public class mainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String command = request.getParameter("command");
        String list = request.getParameter("list");


        //Decodificar y transformar en lista el contenido si recibe algun contenido

        DragonList dList;

        if (command.equals("sort")){
            Sort sort = Sort.getInstance();
            switch (sort.getRound()){
                case 0: dList = sort.selectionSort(null);
                case 1: dList = sort.insertionSort(null);
                case 2: dList = sort.quickSort(null);
                case 3: dList = sort.binaryThree(null);
                case 4: dList = sort.AVL(null);
            }
        }
        else if(command.equals("generate")){
            int num = Integer.parseInt("list");
            int i = 0;
            int n = 5;
            while (i != num){
                Dragon dragon = new Dragon(0, "Hol", 2, 122, "Comandante", 830, n, 80, 140, "file:src/Media/Enemies/Nightfury.gif");
                DragonList.getInstance().addEnemy(dragon);
                n += 70;
                if (i % 10 == 0 && i != 0){
                    n = 5;
                }
                i++;
            }
            dList = DragonList.getInstance();
        }
    }
}
