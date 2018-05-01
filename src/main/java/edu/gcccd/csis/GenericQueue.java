package edu.gcccd.csis;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GenericQueue<E>{

    private ArrayList<E> elements;

    public GenericQueue(int capacity) {
        int initialCapactiy = capacity > 0 ? capacity : 10;
        elements = new ArrayList<E>(initialCapactiy);
    }

    public E dequeue(){
        if(elements.isEmpty())
            throw new NoSuchElementException("Generic Queue is empty, cannot dequeue");
        return elements.remove(0);
    }

    public void enqueue(E pushValue) {
        elements.add(pushValue);
    }

    //current length of the queue
    public int length() {
        return elements.size();
    }
}
