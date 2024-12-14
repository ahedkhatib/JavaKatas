package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixRotateTest {

    @Test
    public void testRotate2x2Matrix(){
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int[][] expected = {
                {3, 1},
                {4, 2}
        };
        MatrixRotate.rotateMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate3x3Matrix(){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        MatrixRotate.rotateMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate4x4Matrix(){
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] expected = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };
        MatrixRotate.rotateMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate1x1Matrix(){
        int[][] matrix = {
                {1}
        };
        int[][] expected = {
                {1}
        };
        MatrixRotate.rotateMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotateNullMatrix(){
        int[][] matrix = null;
        int[][] expected = null;
        MatrixRotate.rotateMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotateEmptyMatrix(){
        int[][] matrix = {
                {}
        };
        int[][] expected = {
                {}
        };
        MatrixRotate.rotateMatrix(matrix);
        assertArrayEquals(expected, matrix);
    }
}
