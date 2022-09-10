import oop.collections.list.linkedList.LinkedList;

public class Main {

    public static void main(String[] args){
        LinkedList linkedList0 = new LinkedList();
        LinkedList linkedList1 = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();

        linkedList0.addAtFront("0");
        linkedList0.remove(0);

        linkedList1.addAtFront("1");
        linkedList1.addAtFront("2");
        linkedList1.addAtTail("3");
        String value= linkedList1.getAt(0);
        value = linkedList1.getAt(1);
        value = linkedList1.getAt(2);
        linkedList1.remove(1);

        linkedList2.addAtTail("5");
        linkedList2.addAtFront("6");

        linkedList2.SetAt(0, "Hello");
        linkedList2.SetAt(1, "World");
        linkedList2.remove(1);

        linkedList3.addAtFront("7");
        linkedList3.addAtTail("8");
        linkedList3.remove(1);

        int indexIterator = 0;
        while(indexIterator < linkedList1.size()){
            System.out.println(linkedList1.getAt(indexIterator));
            indexIterator++;
        }
    }
}
