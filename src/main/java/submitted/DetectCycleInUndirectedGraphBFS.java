package submitted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraphBFS {
    static boolean isCyclicConntected(ArrayList<Integer> adj[], int s,
                                      int V, boolean visited[]) {

        // Set parent vertex for every vertex as -1.
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        // Create a queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {

            // Dequeue a vertex from queue and print it
            int u = q.poll();
            // Get all adjacent vertices of the dequeued vertex u.  If a adjacent has not been
            // visited, then mark it visited  and enqueue it. We also mark parent so that parent
            // is not considered for cycle.
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                } else if (parent[u] != v) { // visted the same vertext via different parent
                    return true;
                }
            }
        }
        return false;
    }


    static boolean isCyclicDisconntected(ArrayList<Integer> adj[], int V) {

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicConntected(adj, i, V, visited)) {
                return true;
            }
        }
        return false;
    }
}
