package katas.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderedMap<K, V> {
    /**
     * Implement an OrderedMap data structure that behaves like a regular map (dictionary) but maintains the
     * order of the keys based on their insertion order.
     *
     * Your task is to implement this class without using the SortedMap interface or similar utilities provided
     * by Java libraries.
     *
     * The order should be preserved as the keys are added to the map.
     */

    private final HashMap<K, V> map;
    private final List<K> orderedKeys;

    public OrderedMap() {
        this.map = new HashMap<>();
        this.orderedKeys = new ArrayList<>();
    }

    public void put(K key, V value) {
        /**
         * Add a key-value pair to the map.
         * If the key already exists, update its value while preserving the order.
         */
        if (!orderedKeys.contains(key))
        {
            orderedKeys.add(key);
        }
        map.put(key, value);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public V get(K key) {
        /**
         * Retrieve the value associated with a given key.
         *
         * @param key: The key whose value is to be retrieved.
         * @return: The value associated with the key, or null if the key does not exist.
         */
        if (!orderedKeys.contains(key))
        {
            return null;
        }
        return map.get(key);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void remove(K key) {
        /**
         * Remove a key-value pair from the map.
         *
         * @param key: The key to be removed.
         */
        if (!orderedKeys.contains(key)){
            return;
        }
        map.remove(key);
        orderedKeys.remove(key);
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<K> keys() {
        /**
         * Return all keys in the order they were added.
         *
         * @return: A list of keys in insertion order.
         */
        return orderedKeys;
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public int size() {
        /**
         * Return the number of elements in the map.
         *
         * @return: The size of the map.
         */
        return orderedKeys.size();
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void clear() {
        /**
         * Remove all key-value pairs from the map.
         */
        orderedKeys.clear();
        map.clear();
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        System.out.println("Keys in order: " + orderedMap.keys());
        System.out.println("Value of 'Two': " + orderedMap.get("Two"));

        orderedMap.remove("Two");
        System.out.println("Keys after removal: " + orderedMap.keys());

        orderedMap.put("Two", 22);
        System.out.println("Keys after re-adding 'Two': " + orderedMap.keys());

        System.out.println("Map size: " + orderedMap.size());

        orderedMap.clear();
        System.out.println("Map size after clearing: " + orderedMap.size());
    }
}

