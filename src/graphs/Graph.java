package graphs;

import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adjList;

    // Constructor
    Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Adding an edge
    void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v); // Because it's undirected
    }

    // Print the graph
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer neighbor : adjList[i]) {
                System.out.print(" -> " + neighbor);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
    }
}
