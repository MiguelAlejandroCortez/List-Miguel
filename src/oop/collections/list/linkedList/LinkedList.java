package oop.collections.list.linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    public LinkedListIterator Iterator(){
        return new LinkedListIterator(head); //Si no me equivoco de esta manera puedo manejar el iterator
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
        LinkedListIterator aux= this.Iterator();
        while(aux.hasNext()){
            aux.next();
            this.remove(0);
        }
    }

    public void removeAllWithValue(String data){
        int indexIterator = 0;
        LinkedListIterator aux = this.Iterator();
        while (aux.hasNext()){
            if(data.equals(aux.next()))
                this.remove(indexIterator);
            else
                indexIterator++;
        }
    }
    public boolean SetAt(int index, String data){
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

    public int size(){
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