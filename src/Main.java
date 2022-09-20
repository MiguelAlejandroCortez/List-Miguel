import oop.collections.list.arraylist.ArrayList;
import oop.collections.list.arraylist.ArrayListIterator;

public class Main {

    public static void main(String[] args){

        ArrayList arrayList1= new ArrayList();

        arrayList1.addAtTail("1");
        arrayList1.addAtTail("2");
        arrayList1.addAtTail("3");

        arrayList1.addAtFront("uno");
        arrayList1.addAtFront("dos");
        arrayList1.addAtFront("tres");

//Borre lo anterior del linkedlist que habia en el main. pero esta en el documento de la tarea
        ArrayListIterator iterator= arrayList1.Iterator();

        while (iterator.hasNext()){
            String value = iterator.next();

            System.out.println(value);
        }
    }
}
