package edu.gcccd.csis;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class GenericQueueTest {

    private GenericQueue<Double> doubleList;
    private double[] freeDoubles = {1.1, 2.2, 3.3, 4.4, 5.5};

    @Before
    public void setUp() {
        doubleList = new GenericQueue<>(5);
    }

    @Test
    public void testDequeue() throws Exception{
        doubleList = new GenericQueue<>(-1);
        assertEquals(doubleList.length(), 0);
        for(int i = 0; i < freeDoubles.length; i++) {
            doubleList.enqueue(freeDoubles[i]);
        }
        double firstIn = freeDoubles[0];
        assertTrue(doubleList.length() == freeDoubles.length);
        double firstOut = doubleList.dequeue();
        assertTrue(firstIn == firstOut);
        assertTrue(doubleList.length() == freeDoubles.length-1);

        boolean isException = false;
        while(doubleList.length() > 0) {
            doubleList.dequeue();
        }
        assertTrue(doubleList.length() == 0);
        try{
            doubleList.dequeue();
        }
        catch(NoSuchElementException e){
            isException = true;
        }
        assertTrue(isException);
    }

    @Test
    public void testEnqueue() {
        assertTrue(doubleList.length() == 0);
        double initialAdd = 10.0;
        doubleList.enqueue(initialAdd);
        assertFalse(doubleList.length() == 0);
        double inQuestion = doubleList.dequeue();
        assertTrue(initialAdd == inQuestion);
    }

    @Test
    public void testLength(){
        assertTrue(doubleList.length() == 0);
        for(int i = 0; i < freeDoubles.length; i++){
            doubleList.enqueue(freeDoubles[i]);
            assertTrue(doubleList.length() == i+1);
        }
    }
}
