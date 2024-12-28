package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SemanticVersionComparatorTest {

    @Test
    void patchDifferent(){
        int result = SemanticVersionComparator.compareVersions("1.0.0", "1.0.1");
        assertEquals(-1, result);
    }

    @Test
    void oneEmpty(){
        int result = SemanticVersionComparator.compareVersions("1.0.0", "");
        assertEquals(1, result);
    }

    @Test
    void oneNull(){
        int result = SemanticVersionComparator.compareVersions("1.0.0", null);
        assertEquals(1, result);
    }

    @Test
    void majorDifferent(){
        int result = SemanticVersionComparator.compareVersions("1.0.0", "2.0.0");
        assertEquals(-1, result);
    }

    @Test
    void minorDifferent(){
        int result = SemanticVersionComparator.compareVersions("1.0.0", "1.1.0");
        assertEquals(-1, result);
    }

    @Test
    void allDifferent(){
        int result = SemanticVersionComparator.compareVersions("1.2.3", "2.0.0");
        assertEquals(-1, result);
    }

    @Test
    void twoEquals(){
        int result = SemanticVersionComparator.compareVersions("1.0.0", "1.0.0");
        assertEquals(0, result);
    }

    @Test
    void edgeCases(){
        int result = SemanticVersionComparator.compareVersions("1", "2.0.0");
        assertEquals(-1, result);
    }
}
