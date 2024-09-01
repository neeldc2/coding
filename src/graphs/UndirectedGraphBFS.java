package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphBFS {

    private int V;
    private LinkedList<Integer>[] adj;

    UndirectedGraphBFS(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraphBFS g = new UndirectedGraphBFS(4);
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
