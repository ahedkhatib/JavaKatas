package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaseGroupingTest {

    @Test
    void basicCase(){
        List<Integer> testCaseGroupSizes1 = List.of(1, 2, 3, 3, 3, 2);
        List<List<Integer>> testCaseGroups1 = TestCaseGrouping.groupTestCases(testCaseGroupSizes1);
        List<List<Integer>> expected = List.of(
                List.of(0),
                List.of(1, 5),
                List.of(2, 3, 4)
        );
        assertEquals(expected, testCaseGroups1);
    }

    @Test
    void singleGroups(){
        List<Integer> testCaseGroupSizes1 = List.of(1, 1, 1, 1);
        List<List<Integer>> testCaseGroups1 = TestCaseGrouping.groupTestCases(testCaseGroupSizes1);
        List<List<Integer>> expected = List.of(
                List.of(0),
                List.of(1),
                List.of(2),
                List.of(3)
        );
        assertEquals(expected, testCaseGroups1);
    }

    @Test
    void sameSizeGroups(){
        List<Integer> testCaseGroupSizes1 = List.of(2, 2, 2, 2);
        List<List<Integer>> testCaseGroups1 = TestCaseGrouping.groupTestCases(testCaseGroupSizes1);
        List<List<Integer>> expected = List.of(
                List.of(0, 1),
                List.of(2, 3)
        );
        assertEquals(expected, testCaseGroups1);
    }

    @Test
    void emptyInput(){
        List<Integer> testCaseGroupSizes1 = List.of();
        List<List<Integer>> testCaseGroups1 = TestCaseGrouping.groupTestCases(testCaseGroupSizes1);
        List<List<Integer>> expected = List.of();
        assertEquals(expected, testCaseGroups1);
    }
}
