package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxStorageCapacityTest {

    @Test
    void basicContainers(){
        int[] containers = {2, 1, 5, 6, 2, 3};

        int result = MaxStorageCapacity.maxStorageArea(containers);
        assertEquals(10, result);
    }

    @Test
    void equalContainers(){
        int[] containers = {2, 2, 2, 2};

        int result = MaxStorageCapacity.maxStorageArea(containers);
        assertEquals(8, result);
    }

    @Test
    void oneContainer(){
        int[] containers = {2};

        int result = MaxStorageCapacity.maxStorageArea(containers);
        assertEquals(2, result);
    }

    @Test
    void emptyContainers(){
        int[] containers = {};

        int result = MaxStorageCapacity.maxStorageArea(containers);
        assertEquals(0, result);
    }

    @Test
    void increasingContainers(){
        int[] containers = {1, 2, 3, 4, 5};

        int result = MaxStorageCapacity.maxStorageArea(containers);
        assertEquals(9, result);
    }

    @Test
    void decreasingContainers(){
        int[] containers = {5, 4, 3, 2, 1};

        int result = MaxStorageCapacity.maxStorageArea(containers);
        assertEquals(9, result);
    }
}
