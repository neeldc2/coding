package graphs;

import java.util.LinkedList;

public class UndirectedGraphDFS {

    private int V;
    private LinkedList<Integer>[] adj;

    UndirectedGraphDFS(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public static void main(String[] args) {
        UndirectedGraphDFS g = new UndirectedGraphDFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal (starting from vertex 2):");
        g.DFS(2);
    }

}
