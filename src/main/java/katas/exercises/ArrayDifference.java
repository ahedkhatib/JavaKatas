package katas.exercises;

import java.util.Arrays;

public class ArrayDifference {

    /**
     * Finds the difference between the largest and smallest numbers in the array.
     *
     * @param numbers the array of integers
     * @return the difference between the largest and smallest numbers
     */
    public static int findDifference(int[] numbers) {
        if(numbers != null && numbers.length > 0) {
            int maxValue = Arrays.stream(numbers).max().getAsInt();
            int minValue = Arrays.stream(numbers).min().getAsInt();
            return maxValue - minValue;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] sampleArray = {10, 3, 5, 6, 20, -2};
        int difference = findDifference(sampleArray);
        System.out.println(difference);
    }
}
