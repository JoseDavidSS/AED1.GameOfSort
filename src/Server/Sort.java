package Server;

import Logic.Lists.DragonList;

public class Sort {

    private int round;
    private static Sort sort = null;

    public static Sort getInstance(){
        if (sort==null){
            sort = new Sort();
        }
        return sort;
    }

    private Sort(){
        this.round = 0;
    }

    public int getRound() {
        return round;
    }

    public DragonList selectionSort(DragonList lista){
        //Aplicar selectionSort
        this.round++;
        return lista;
    }

    public DragonList insertionSort(DragonList lista){
        //Aplicar insertionSort
        this.round++;
        return lista;
    }

    public DragonList quickSort(DragonList lista){
        //Aplicar quickSort
        this.round++;
        return lista;
    }

    public DragonList binaryThree(DragonList lista){
        //Aplicar el ordenamiento tipo arbol
        this.round++;
        return lista;
    }

    public DragonList AVL(DragonList lista){
        //Ordenar AVL por edades
        this.round = 0;
        return lista;
    }
}
