package oop.collections.list.arraylist;

import oop.collections.list.linkedList.Node;

public class ArrayListIterator {
    private Node nodeIterator;

    public ArrayListIterator(Node head){
        this.nodeIterator = head;
    }

    public boolean hasNext(){
        return nodeIterator != null;
    }

    public String next() {
        if (this.hasNext()) {
            String data = nodeIterator.getData();
            nodeIterator = nodeIterator.getNext();
            return data;
        }
        return null;
    }
}
