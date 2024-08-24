package graphs;

import java.util.LinkedList;

public class GraphRepresentation {
    public int V;
    private LinkedList<Integer>[] adjList;

    // Constructor
    GraphRepresentation(int V) {
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
        GraphRepresentation graph = new GraphRepresentation(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
