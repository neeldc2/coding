package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * This is the solution I came up with.
 */
public class DetectCycleInUndirectedGraphUsingBFS {

    private static boolean hasCycle(final int v,
                                    final List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];
        boolean hasCycle = false;

        // Handling Disconnected Graphs
        for (int i = 0 ; i < v ; i++) {
            if (!visited[i]) {
                hasCycle = hasCycle(v, adj, visited, i);

                if (hasCycle) {
                    return true;
                }
            }
        }

        return hasCycle;
    }

    private static boolean hasCycle(final int v,
                                 final List<List<Integer>> adj,
                                 final boolean[] visited,
                                 final int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        Set<Integer> parentNodesThatAreAlreadyCovered = new HashSet<>();

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.remove();

            // Add only if the current vertex qualifies as a parent
            if (!adj.get(currentVertex).isEmpty()) {
                parentNodesThatAreAlreadyCovered.add(currentVertex);
            }

            for (Integer neighbouringVertex : adj.get(currentVertex)) {
                if (!visited[neighbouringVertex]) {
                    visited[neighbouringVertex] = true;
                    queue.offer(neighbouringVertex);
                } else if (!parentNodesThatAreAlreadyCovered.contains(neighbouringVertex)) {
                    return true;
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        // Test case 1: Graph with a self-loop
        UndirectedGraphBFSAlternative graph1 = new UndirectedGraphBFSAlternative(4);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 3);  // Self-loop
        System.out.println("Test case 1 (Graph with self-loop): " +
                DetectCycleInUndirectedGraphUsingBFS.hasCycle(graph1.getNumberOfVertices(), graph1.getAdj()));

        // Test case 2: Graph with no cycle
        UndirectedGraphBFSAlternative graph2 = new UndirectedGraphBFSAlternative(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        System.out.println("Test case 2 (Graph with no cycle): " +
                DetectCycleInUndirectedGraphUsingBFS.hasCycle(graph2.getNumberOfVertices(), graph2.getAdj()));

        // Test case 3: Graph with a cycle
        UndirectedGraphBFSAlternative graph3 = new UndirectedGraphBFSAlternative(5);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 4);
        graph3.addEdge(4, 1);  // Creates a cycle
        System.out.println("Test case 3 (Graph with a cycle): " +
                DetectCycleInUndirectedGraphUsingBFS.hasCycle(graph3.getNumberOfVertices(), graph3.getAdj()));

        // Test case 4: Disconnected graph with a cycle
        UndirectedGraphBFSAlternative graph4 = new UndirectedGraphBFSAlternative(6);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 0);  // Cycle in one component
        graph4.addEdge(3, 4);
        graph4.addEdge(4, 5);  // No cycle in other component
        System.out.println("Test case 4 (Disconnected graph with a cycle): " +
                DetectCycleInUndirectedGraphUsingBFS.hasCycle(graph4.getNumberOfVertices(), graph4.getAdj()));

        // Test case 5: Empty graph
        UndirectedGraphBFSAlternative graph5 = new UndirectedGraphBFSAlternative(0);
        System.out.println("Test case 5 (Empty graph): " +
                DetectCycleInUndirectedGraphUsingBFS.hasCycle(graph5.getNumberOfVertices(), graph5.getAdj()));

        // Test case 6: Graph with multiple cycles
        UndirectedGraphBFSAlternative graph6 = new UndirectedGraphBFSAlternative(6);
        graph6.addEdge(0, 1);
        graph6.addEdge(1, 2);
        graph6.addEdge(2, 0);  // First cycle
        graph6.addEdge(3, 4);
        graph6.addEdge(4, 5);
        graph6.addEdge(5, 3);  // Second cycle
        System.out.println("Test case 6 (Graph with multiple cycles): " +
                DetectCycleInUndirectedGraphUsingBFS.hasCycle(graph6.getNumberOfVertices(), graph6.getAdj()));
    }

}
