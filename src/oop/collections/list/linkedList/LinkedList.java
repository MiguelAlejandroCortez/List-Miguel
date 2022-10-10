package oop.collections.list.linkedList;

import oop.collections.list.Iterator;
import oop.collections.list.List;

//INNER CLASS (CLASE ANIDADA)

public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        Node next;
        Node previous;
        String data;

        public Node(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    private class LinkedListIterator implements Iterator {
        private Node aux;

        public LinkedListIterator(){
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

    public LinkedListIterator getIterator(){
        return new LinkedListIterator(); //Si no me equivoco de esta manera puedo manejar el iterator
    }                                        //en vez de crear un atributo private del iterator

    public void addAtFront(String data){
        Node node = new Node(data);

        node.setNext(head);
        if(head != null)
            head.setPrevious(node);
        else
            tail =node;

        head=node;
        size++;
    }

    public void addAtTail(String data){
        Node node = new Node(data);

        node.setPrevious(tail);
        if(tail != null)
            tail.setNext(node);
        else
            head =node;

        tail=node;
        size++;
    }

    public boolean remove(int indexToRemove){
        if(indexToRemove < 0 || indexToRemove >= size){
            return false;
        }
        if(size == 1){
            head = null;
            tail = null;
        }else if(indexToRemove == 0){
            head= head.getNext();
            head.setPrevious(null);
        }else if(indexToRemove == size - 1){
            tail = tail.getPrevious();
            tail.setNext(null);
        }else{
            Node iteratorNode = findNodeByIndex(indexToRemove);
            iteratorNode.getPrevious().setNext(iteratorNode.getNext());
            iteratorNode.getNext().setPrevious(iteratorNode.getPrevious());
        }
        size--;
        return true;
    }

    public void removeAll(){
        LinkedListIterator aux= this.getIterator();
        while(aux.hasNext()){
            aux.Next();
            this.remove(0);
        }
    }

    public void removeAllWithValue(String data){
        int indexIterator = 0;
        LinkedListIterator aux = this.getIterator();
        while (aux.hasNext()){
            if(data.equals(aux.Next()))
                this.remove(indexIterator);
            else
                indexIterator++;
        }
    }
    public boolean setAt(int index, String data){
        if(index < 0 || index >= size){
            return false;
        }
        Node node = findNodeByIndex(index);
        node.setData(data);
        return true;
    }

    public String getAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node node = findNodeByIndex(index);
        if (node == null)
        {
            System.out.println("its null oops " + index);
        }
        return node.getData();
    }

    public int getSize(){
        return size;
    }

    private Node findNodeByIndex(int index) {
        Node iteratorNode = head;
        if (head == null)
        {
            System.out.println("ERROR: head is null");
            return null;
        }
        int indexIteratorNode = 0;
        while (indexIteratorNode < index && iteratorNode != null) {
            iteratorNode = iteratorNode.getNext();
            if (iteratorNode == null)
            {
                System.out.println("ERROR: next is null");
            }
            indexIteratorNode++;
        }
        return iteratorNode;
    }
}