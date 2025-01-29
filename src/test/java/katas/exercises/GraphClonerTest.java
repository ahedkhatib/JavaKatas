package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.prefs.PreferenceChangeEvent;

import static katas.exercises.GraphCloner.cloneGraph;
import static org.junit.jupiter.api.Assertions.*;

public class GraphClonerTest {

    @Test
    public void testGraphClonerWithCycle() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);
        GraphCloner.Node node3 = new GraphCloner.Node(3);
        GraphCloner.Node node4 = new GraphCloner.Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);

        GraphCloner.Node clonedNode = cloneGraph(node1);
        assertTrue(areGraphsEqual(node1, clonedNode, new HashSet<>(), new HashSet<>()));
    }

    @Test
    public void testGraphClonerWithoutCycle() {
        GraphCloner.Node node1 = new GraphCloner.Node(1);
        GraphCloner.Node node2 = new GraphCloner.Node(2);
        GraphCloner.Node node3 = new GraphCloner.Node(3);
        GraphCloner.Node node4 = new GraphCloner.Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);


        GraphCloner.Node clonedNode = cloneGraph(node1);
        assertTrue(areGraphsEqual(node1, clonedNode, new HashSet<>(), new HashSet<>()));
    }

    @Test
    public void testOneNode(){
        GraphCloner.Node node1 = new GraphCloner.Node(1);

        GraphCloner.Node clonedNode = cloneGraph(node1);
        assertTrue(areGraphsEqual(node1, clonedNode, new HashSet<>(), new HashSet<>()));
    }

    @Test
    public void testNullGraph(){
        GraphCloner.Node node1 = null;

        GraphCloner.Node clonedNode = cloneGraph(node1);

        assertNull(clonedNode);
    }


    private boolean areGraphsEqual(GraphCloner.Node original, GraphCloner.Node cloned, Set<GraphCloner.Node> visitedOriginal, Set<GraphCloner.Node> visitedCloned) {
        if (original == null || cloned == null) return original == cloned;
        if (visitedOriginal.contains(original) && visitedCloned.contains(cloned)) return true;
        if (original.val != cloned.val || original == cloned) return false;
        visitedCloned.add(cloned);
        visitedOriginal.add(original);

        if (original.neighbors.size() != cloned.neighbors.size()) return false;

        for (int i = 0; i < original.neighbors.size(); i++){
            if (!areGraphsEqual(original.neighbors.get(i), cloned.neighbors.get(i), visitedOriginal, visitedCloned)) {
                return false;
            }
        }
        return true;
    }
}
