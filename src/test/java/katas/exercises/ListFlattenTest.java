package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListFlattenTest {

    @Test
    public void testNestedListFlatten(){
        List<Object> nestedList = List.of(1, List.of(2, 3), List.of(4, List.of(5, 6)), 7);
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        List<Integer> expectedList = List.of(1, 2, 3, 4, 5, 6, 7);

        assertEquals(expectedList, flatList);
    }

    @Test
    public void testListFlatten(){
        List<Object> nestedList = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        List<Integer> expectedList = List.of(1, 2, 3, 4, 5, 6, 7);

        assertEquals(expectedList, flatList);
    }

    @Test
    public void testNullListFlatten(){
        List<Object> nestedList = null;
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        List<Integer> expectedList = new ArrayList<>();

        assertEquals(expectedList, flatList);
    }

    @Test
    public void testEmptyFlatten(){
        List<Object> nestedList = new ArrayList<>();
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        List<Integer> expectedList = new ArrayList<>();

        assertEquals(expectedList, flatList);
    }

    @Test
    public void testDeepNestedListFlatten(){
        List<Object> nestedList = List.of(List.of(1,List.of(List.of(List.of(2, 3)))), 4);
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        List<Integer> expectedList = List.of(1, 2, 3, 4);

        assertEquals(expectedList, flatList);
    }

    @Test
    public void testAllListFlatten(){
        List<Object> nestedList = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        List<Integer> flatList = ListFlatten.flattenList(nestedList);
        List<Integer> expectedList = List.of(1, 2, 3, 4, 5, 6);

        assertEquals(expectedList, flatList);
    }

}
