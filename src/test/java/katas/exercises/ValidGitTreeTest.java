package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidGitTreeTest {

    @Test
    void validGitTree(){
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        assertTrue(ValidGitTree.isValidGitTree(validTree));
    }

    @Test
    void inValidGitTree(){
        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle

        assertFalse(ValidGitTree.isValidGitTree(invalidTree));
    }

    @Test
    void disconnectedNode(){
        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of());
        invalidTree.put("D", List.of());

        assertFalse(ValidGitTree.isValidGitTree(invalidTree));
    }

    @Test
    void multipleRoots(){
        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("C", List.of());

        assertFalse(ValidGitTree.isValidGitTree(invalidTree));
    }

    @Test
    void emptyTreeTest(){
        Map<String, List<String>> emptyTree = new HashMap<>();

        assertFalse(ValidGitTree.isValidGitTree(emptyTree));
    }

    @Test
    void singleNode(){
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of());

        assertTrue(ValidGitTree.isValidGitTree(validTree));
    }

}
