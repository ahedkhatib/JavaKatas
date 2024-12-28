package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SlidingWindowMaximumTest {

    @Test
    void basicWindow(){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> slidingWindowMax = SlidingWindowMaximum.maxSlidingWindow(nums, 3);
        assertEquals(List.of(3, 3, 5, 5, 6, 7), slidingWindowMax);
    }

    @Test
    void singleElementWindow(){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> slidingWindowMax = SlidingWindowMaximum.maxSlidingWindow(nums, 1);
        assertEquals(List.of(1, 3, -1, -3, 5, 3, 6, 7), slidingWindowMax);
    }

    @Test
    void fullElementsWindow(){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> slidingWindowMax = SlidingWindowMaximum.maxSlidingWindow(nums, nums.length);
        assertEquals(List.of(7), slidingWindowMax);
    }

    @Test
    void emptyArray(){
        int[] nums = {};
        List<Integer> slidingWindowMax = SlidingWindowMaximum.maxSlidingWindow(nums, 1);
        assertEquals(List.of(), slidingWindowMax);
    }

    @Test
    void nullArray(){
        int[] nums = null;
        List<Integer> slidingWindowMax = SlidingWindowMaximum.maxSlidingWindow(nums, 1);
        assertNull(slidingWindowMax);
    }

    @Test
    void zeroWindow(){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> slidingWindowMax = SlidingWindowMaximum.maxSlidingWindow(nums, 0);
        assertEquals(List.of(1, 3, -1, -3, 5, 3, 6, 7), slidingWindowMax);
    }

    @Test
    void largerThanArraySizeWindow(){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> slidingWindowMax = SlidingWindowMaximum.maxSlidingWindow(nums, 9);
        assertEquals(List.of(1, 3, -1, -3, 5, 3, 6, 7), slidingWindowMax);
    }

    @Test
    void negativeArray(){
        int[] nums = {-1, -3, -4, -8};
        List<Integer> slidingWindowMax = SlidingWindowMaximum.maxSlidingWindow(nums, 2);
        assertEquals(List.of(-1, -3, -4), slidingWindowMax);
    }

    @Test
    void dublicateElements(){
        int[] nums = {1, 3, 3, 3, 4, 3, 3};
        List<Integer> slidingWindowMax = SlidingWindowMaximum.maxSlidingWindow(nums, 2);
        assertEquals(List.of(3, 3, 3, 4, 4, 3), slidingWindowMax);
    }

}
