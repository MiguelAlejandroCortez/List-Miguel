package oop.collections.list.linkedList;

public class LinkedListIterator {
    private Node aux;

    public LinkedListIterator(Node head){
        this.aux = head;
    }

    public boolean hasNext(){
        return aux != null;
    }

    public String next() {
        if (this.hasNext()) {
            String data = aux.getData();
            aux = aux.getNext();
            return data;
        }
        return null;
    }
}
