package Logic.Lists;

public class Lista {

    int largo;
    Nodo head;

    public void selectionSort() {
        if (!listaVacia()) {
            for (int a = 0; a < this.largo - 1; a++) {
                int minIndex = a;
                for (int j = a + 1; j < this.largo; j++)
                    if (this.getValue(j) < this.getValue(minIndex))
                        minIndex = j;
                swap(minIndex, a);
            }
        }
    }

    public void insertionSort(){
        if (!listaVacia()){
            int in;
            int out;
            for(out = 1; out < this.largo; out++){
                int temp = this.getValue(out);
                in = out;
                while(in >= 0 && this.getValue(in-1) >= temp){
                    this.swap(in, in-1);
                    in --;
                }
                this.setValue(in, temp);
            }

        }
    }

    public int partition(){
        int pivote = this.getValue(largo-1);
        int menor = 0;
        int mayor = largo-1;
        int i = menor-1;
        int j;
        for(j = menor; j<this.largo-1; j++){
            if(this.getValue(j) <= pivote){
                i++;
                this.swap(i,j);
            }
        }
        this.swap(i+1, mayor);
        return(i+1);
    }

    public void quickSort(int mayor, int menor){
        if(menor<mayor){
            int pi = partition();
            quickSort(pi-1,menor);
            quickSort(mayor, pi+1);

        }
    }



    public void swap(int minIndex, int i) {
        int temp = this.getValue(minIndex);
        this.setValue(minIndex, this.getValue(i));
        this.setValue(i, temp);
    }

    public void print() {
        if (!listaVacia()) {
            for (int a = 0; a < this.largo; a++) {
                System.out.println(getValue(a));
            }
            System.out.println("--------------------------");
        }
    }

    public int getValue(int index) {
        if (this.largo - 1 < index) {
            System.out.println("IndexOutOfRange");
            return Integer.parseInt(null);
        } else {
            Nodo tmp = this.head;
            for (int a = 0; a < index; a++) {
                tmp = tmp.next;
            }
            return tmp.valor;
        }
    }

    public void setValue(int index, int valor) {
        if (this.largo - 1 < index) {
            System.out.println("IndexOutOfRange");
        } else {
            Nodo tmp = this.head;
            for (int a = 0; a < index; a++) {
                tmp = tmp.next;
            }
            tmp.valor = valor;
        }
    }

    public boolean listaVacia() {
        if (this.largo == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        Lista lista = new Lista();
        lista.head = new Nodo(10);
        lista.head.next = new Nodo(1);
        lista.head.next.next = new Nodo(12);
        lista.head.next.next.next = new Nodo(11);
        lista.head.next.next.next.next = new Nodo(20);
        lista.head.next.next.next.next.next = new Nodo(2);
        lista.head.next.next.next.next.next.next = new Nodo(7);
        lista.largo = 7;
        lista.print();
        lista.insertionSort();
        lista.print();
    }
}

