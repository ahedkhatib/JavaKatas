package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RequirementsCoverageTest {

    @Test
    void testBasicCase() {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(2, 3), result);
    }

    @Test
    void testSingleRequirements(){
        List<List<Integer>> testCases = List.of(
                List.of(1),
                List.of(2),
                List.of(3)
        );

        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(0, 1, 2), result);
    }

    @Test
    void testEmptyTestCases() {
        List<List<Integer>> testCases = List.of();
        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertTrue(result.isEmpty());
    }

    @Test
    void oneTestCase() {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3, 4, 5)
        );
        List<Integer> result = RequirementsCoverage.selectMinimalTestCases(testCases);
        assertEquals(List.of(0), result);
    }

}
