package katas.exercises;

import java.util.*;

public class ValidGitTree {

    /**
     * Determines if a given tree structure represents a valid Git tree.
     *
     * A valid Git tree should:
     * 1. Have exactly one root (no parent).
     * 2. Contain no cycles.
     *
     * @param treeMap a map representing the Git tree (commit ID to list of child commit IDs)
     * @return true if the tree is a valid Git tree, false otherwise
     */
    public static boolean isValidGitTree(Map<String, List<String>> treeMap) {

        Set<String> allNodes= new HashSet<>();
        Set<String> children = new HashSet<>();

        for(Map.Entry<String, List<String>> entry : treeMap.entrySet()){
            allNodes.add(entry.getKey());
            children.addAll(entry.getValue());
        }

        allNodes.removeAll(children);
        if (allNodes.size() != 1)
        {
            return false;
        }

        //Check for cycle
        String root = allNodes.iterator().next();
        Set<String> visited = new HashSet<>();

        if (hasCycle(treeMap, root, visited, null)){
            return false;
        }

        return visited.size() == treeMap.size();
    }

    private static boolean hasCycle(Map<String, List<String>> treeMap, String node, Set<String> visited, String parent){
        if (visited.contains(node)){
            return true;
        }

        visited.add(node);

        List<String> children = treeMap.getOrDefault(node, Collections.emptyList());
        for (String child : children){
            if (!child.equals(parent)){
                if (hasCycle(treeMap, child, visited, node)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle

        System.out.println("Is valid tree: " + isValidGitTree(validTree));
        System.out.println("Is valid tree: " + isValidGitTree(invalidTree));
    }
}
