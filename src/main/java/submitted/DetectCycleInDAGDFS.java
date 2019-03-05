package submitted;

import java.util.List;

public class DetectCycleInDAGDFS {
    int V = 6; // vertices

    private boolean isCyclicUtil(Graph g, int i, boolean[] visited,
                                 boolean[] recStack) {

        // Mark the current node as visited and part of recursion stack
        if (recStack[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        recStack[i] = true;
        List<String> children = g.getAdj().get(i);

        for (String c : children) {
            if (isCyclicUtil(g, Integer.parseInt(c), visited, recStack)) {
                return true;
            }
        }

        recStack[i] = false;
        return false;
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclic() {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(new Graph(), i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }
}
