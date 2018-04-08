package leetcode.graph;

import java.util.LinkedList;

/**
 * An edge in an undirected connected graph is a bridge iff removing it disconnects
 * the graph. For a disconnected undirected graph, definition is similar, a bridge
 * is an edge removing which increases number of connected components.
 * We do DFS traversal of the given graph. In DFS tree an edge (u, v)
 * (u is parent of v in DFS tree) is bridge if there does not exit any
 * other alternative to reach u or an ancestor of u from subtree rooted with v.
 * As discussed in the previous post, the value low[v] indicates earliest visited
 * vertex reachable from subtree rooted with v. The condition for an edge (u, v)
 * to be a bridge is, “low[v] > disc[u]”.
 */
public class FindBridgesInGraph {
    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    // Constructor
    FindBridgesInGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        } ;
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);  //Add v to w's list
    }

    // A recursive function that finds and prints bridges
    // using DFS traversal
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // low[v] indicates earliest visited vertex reachable from subtree rooted with v.
    // The condition for an edge (u, v) to be a bridge is, “low[v] > disc[u]”.
    void bridgeUtil(int u, boolean visited[], int disc[],
                    int low[], int parent[]) {

        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices adjacent to this
        for (Integer v : adj[u]) {
            // If v is not visited yet, then make it a child
            // of u in DFS tree and recur for it.
            // If v is not visited yet, then recur for it
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);

                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge
                if (low[v] > disc[u]) {
                    System.out.println(u + " " + v);
                }
            }
            // Update low value of u for parent function calls.
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // DFS based function to find all bridges. It uses recursive
    // function bridgeUtil()
    void bridge() {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
        }

        // Call the recursive helper function to find Bridges
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bridgeUtil(i, visited, disc, low, parent);
            }
        }
    }

    public static void main(String args[]) {
        // Create graphs given in above diagrams
        System.out.println("Bridges in first graph ");
        FindBridgesInGraph g1 = new FindBridgesInGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.bridge();
        System.out.println();

        System.out.println("Bridges in Second graph");
        FindBridgesInGraph g2 = new FindBridgesInGraph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.bridge();
        System.out.println();

        System.out.println("Bridges in Third graph ");
        FindBridgesInGraph g3 = new FindBridgesInGraph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.bridge();
    }
}
