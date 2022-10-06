package oop.collections.list.linkedList;

import oop.collections.list.Iterator;

public class LinkedListIterator implements Iterator {
    private Node aux;

    public LinkedListIterator(Node head){
        this.aux = head;
    }

    public boolean hasNext(){
        return aux != null;
    }

    public String Next() {
        if (this.hasNext()) {
            String data = aux.getData();
            aux = aux.getNext();
            return data;
        }
        return null;
    }
}
