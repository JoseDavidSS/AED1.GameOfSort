package Server;

import Logic.Lists.TemporalList;

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

    public TemporalList selectionSort(TemporalList lista){
        //Aplicar selectionSort
        this.round++;
        return lista;
    }

    public TemporalList insertionSort(TemporalList lista){
        //Aplicar insertionSort
        this.round++;
        return lista;
    }

    public TemporalList quickSort(TemporalList lista){
        //Aplicar quickSort
        this.round++;
        return lista;
    }

    public TemporalList binaryThree(TemporalList lista){
        //Aplicar el ordenamiento tipo arbol
        this.round++;
        return lista;
    }

    public TemporalList AVL(TemporalList lista){
        //Ordenar AVL por edades
        this.round = 0;
        return lista;
    }
}
