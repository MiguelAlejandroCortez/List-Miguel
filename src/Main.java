import oop.collections.list.arraylist.ArrayList;
public class Main {

    public static void main(String[] args){

        ArrayList arrayList1= new ArrayList();

        arrayList1.addAtFront("1");
        arrayList1.addAtFront("2");
        arrayList1.addAtFront("3");

//Borre lo anterior del linkedlist que habia en el main. pero esta en el documento de la tarea 6

        int indexIterator = 0;
        while(indexIterator < arrayList1.size()){
            System.out.println(arrayList1.getAt(indexIterator));
            indexIterator++;
        }
    }
}
