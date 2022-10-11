package oop.collections.list.arraylist;

import oop.collections.list.Iterator;
import oop.collections.list.List;

public class ArrayList implements List {
    private String[] data;
    private int size;

    public ArrayList(){
        data = new String[2];
    }

    public Iterator getIterator(){
        return new Iterator(){
            private int currentIndex =0;
         public boolean hasNext(){
             return currentIndex < size;
         }
         public String Next(){
             return data[currentIndex++];
         }
        };
    }

    public void addAtFront(String data){
        if(size == this.data.length){
            increaseArraySize();
        }
        for(int i= size; i>0;i-- ){
            this.data[i] = this.data[i-1];
        }

        this.data[0]=data;
        size++;
    }

    public void addAtTail(String data){
        if(size == this.data.length){
            increaseArraySize();
        }
        this.data[size] = data;
        size++;
    }

    public void increaseArraySize(){
        String []newArray = new String[this.data.length *2];

        for(int i=0; i<data.length;i++){
            newArray[i] =data[i];
        }

        data=newArray;
    }

    public boolean remove(int indexToRemove){

        if(indexToRemove <0 || indexToRemove >= size) {
            return false;
        }

        for(int i= indexToRemove; i<size ; i++){
            data[i]=data[i+1];
        }

        size--;
        data[size]=null;

        return true;
    }

    public void removeAll(){
        for (int i=0; i<size; i++){
            data[i]=null;
        }
        size = 0;
    }

    public void removeAllWithValue(String value){
        String []newArray = new String[data.length];
        int cont = 0;
        for(int i=0; i<size; i++){
            if (!data[i].equals(value)) {
                newArray[cont++] = data[i];
            }
        }

        this.data=newArray;
        size= cont;
    }

    public boolean setAt(int index, String data){
        if(index<0 || index >= size){
            return false;
        }

        this.data[index]=data;

        return true;
    }

    public String getAt(int index) {
        if(index<0 || index >= size){
            return null;
        }

        return this.data[index];
    }

    public int getSize(){
        return size;
    }
    }