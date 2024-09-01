package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is the solution Claude AI gave.
 * This is simpler to understand than the solution I came up with.
 */
public class DetectCycleInUndirectedGraphUsingBFS2 {

    public static boolean hasCycle(final int numberOfVertices,
                                   final List<List<Integer>> adj) {
        boolean[] visited = new boolean[numberOfVertices];

        // Handling Disconnected Graphs
        for (int i = 0; i < numberOfVertices; i++) {
            if (!visited[i]) {
                if (bfsCycle(numberOfVertices, adj, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfsCycle(final int numberOfVertices,
                                    final List<List<Integer>> adj,
                                    final int source,
                                    final boolean[] visited) {
        int[] parent = new int[numberOfVertices];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbour : adj.get(currentVertex)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                    parent[neighbour] = currentVertex;
                } else if (parent[currentVertex] != neighbour) {
                    // Cycle detected
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
                DetectCycleInUndirectedGraphUsingBFS2.hasCycle(graph1.getNumberOfVertices(), graph1.getAdj()));

        // Test case 2: Graph with no cycle
        UndirectedGraphBFSAlternative graph2 = new UndirectedGraphBFSAlternative(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        System.out.println("Test case 2 (Graph with no cycle): " +
                DetectCycleInUndirectedGraphUsingBFS2.hasCycle(graph2.getNumberOfVertices(), graph2.getAdj()));

        // Test case 3: Graph with a cycle
        UndirectedGraphBFSAlternative graph3 = new UndirectedGraphBFSAlternative(5);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 4);
        graph3.addEdge(4, 1);  // Creates a cycle
        System.out.println("Test case 3 (Graph with a cycle): " +
                DetectCycleInUndirectedGraphUsingBFS2.hasCycle(graph3.getNumberOfVertices(), graph3.getAdj()));

        // Test case 4: Disconnected graph with a cycle
        UndirectedGraphBFSAlternative graph4 = new UndirectedGraphBFSAlternative(6);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 0);  // Cycle in one component
        graph4.addEdge(3, 4);
        graph4.addEdge(4, 5);  // No cycle in other component
        System.out.println("Test case 4 (Disconnected graph with a cycle): " +
                DetectCycleInUndirectedGraphUsingBFS2.hasCycle(graph4.getNumberOfVertices(), graph4.getAdj()));

        // Test case 5: Empty graph
        UndirectedGraphBFSAlternative graph5 = new UndirectedGraphBFSAlternative(0);
        System.out.println("Test case 5 (Empty graph): " +
                DetectCycleInUndirectedGraphUsingBFS2.hasCycle(graph5.getNumberOfVertices(), graph5.getAdj()));

        // Test case 6: Graph with multiple cycles
        UndirectedGraphBFSAlternative graph6 = new UndirectedGraphBFSAlternative(6);
        graph6.addEdge(0, 1);
        graph6.addEdge(1, 2);
        graph6.addEdge(2, 0);  // First cycle
        graph6.addEdge(3, 4);
        graph6.addEdge(4, 5);
        graph6.addEdge(5, 3);  // Second cycle
        System.out.println("Test case 6 (Graph with multiple cycles): " +
                DetectCycleInUndirectedGraphUsingBFS2.hasCycle(graph6.getNumberOfVertices(), graph6.getAdj()));
    }

}
