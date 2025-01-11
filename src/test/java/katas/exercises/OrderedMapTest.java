package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderedMapTest {

    @Test
    void putAndGetTest(){
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        assertEquals(1, orderedMap.get("One"));
        assertEquals(2, orderedMap.get("Two"));
        assertEquals(3, orderedMap.get("Three"));
        assertNull(orderedMap.get("Four"));
    }

    @Test
    void orderedKeysTest(){
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        assertEquals(List.of("One", "Two", "Three"), orderedMap.keys());
    }

    @Test
    void removeKeyTest(){
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);
        orderedMap.remove("One");

        assertNull(orderedMap.get("One"));
        assertEquals(List.of("Two", "Three"), orderedMap.keys());
        assertEquals(2, orderedMap.size());
    }

    @Test
    void clearTest(){
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);
        orderedMap.clear();

        assertEquals(0, orderedMap.size());
        assertEquals(List.of(), orderedMap.keys());
    }

    @Test
    void updateValueTest(){
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);
        orderedMap.put("Two", 22);

        assertEquals(1, orderedMap.get("One"));
        assertEquals(22, orderedMap.get("Two"));
        assertEquals(3, orderedMap.get("Three"));
        assertEquals(List.of("One", "Two", "Three"), orderedMap.keys());
        assertEquals(3, orderedMap.size());
    }

    @Test
    void updateDeletedValueTest(){
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);
        orderedMap.remove("Two");
        orderedMap.put("Two", 22);

        assertEquals(1, orderedMap.get("One"));
        assertEquals(22, orderedMap.get("Two"));
        assertEquals(3, orderedMap.get("Three"));
        assertEquals(List.of("One", "Three", "Two"), orderedMap.keys());
        assertEquals(3, orderedMap.size());
    }


}
