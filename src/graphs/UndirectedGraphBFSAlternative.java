package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This does not use array of List. Instead, it does List of List.
 */
public class UndirectedGraphBFSAlternative {

    private final int numberOfVertices; // Number of vertices
    private final List<List<Integer>> adj; // Adjacency list

    public UndirectedGraphBFSAlternative(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adj = new ArrayList<>(this.numberOfVertices);
        for (int i = 0; i < this.numberOfVertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    // BFS traversal from a given source vertex
    public void BFS(int s) {
        // Mark all vertices as not visited
        boolean[] visited = new boolean[numberOfVertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the source node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent has not been visited, then mark it visited
            // and enqueue it
            for (int n : adj.get(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraphBFSAlternative g = new UndirectedGraphBFSAlternative(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Breadth First Traversal (starting from vertex 2):");
        g.BFS(2);
    }

}
