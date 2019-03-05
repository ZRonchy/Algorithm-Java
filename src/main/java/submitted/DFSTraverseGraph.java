package submitted;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFSTraverseGraph {
    Graph graph;
    void setGraph(Graph graph){
        this.graph = graph;
    }

    void dfsUtil(String v, Set<String> visited) {
        // Mark the current node as visited and print it
        visited.add(v);
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        List<String> adjs = graph.getAdj().get(v);
        for (String adj: adjs) {
            if (!visited.contains(adj)) {
                dfsUtil(adj, visited);
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void dfs(String v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        Set<String> visited = new HashSet<>();

        // Call the recursive helper function to print DFS traversal
        // dfsUtil(v, visited); call this for connected graphs without any disconnected vertices

        // Call the recursive helper function to print DFS traversal starting from all vertices one by one
        // this is to prevent from disconnected graphs and vertices
        int V = 6; // vertex numbers
        for (int i=0; i< V; ++i) {
            if (!visited.contains(i+"")) {
                dfsUtil(i+"", visited);
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph();

        g.addEdge("0", "1");
        g.addEdge("0", "2");
        g.addEdge("1", "2");
        g.addEdge("2", "0");
        g.addEdge("2", "3");
        g.addEdge("3", "3");

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");
        DFSTraverseGraph dfsTraverseGraph = new DFSTraverseGraph();
        dfsTraverseGraph.dfs("2");
    }
}
