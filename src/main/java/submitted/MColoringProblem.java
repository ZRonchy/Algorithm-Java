package submitted;

public class MColoringProblem {
    int color[];
    /* A utility function to check if the current color assignment is safe for vertex v */
    boolean isSafe(int v, int graph[][], int color[], int c) {
        for (int i = 0; i < graph.length; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    /* A recursive utility function to solve m
       coloring  problem */
    boolean graphColoringUtil(int graph[][], int m,
                              int color[], int v) {
        /* base case: If all vertices are assigned
           a color then return true */
        int V = graph.length;
        if (v == V) {
            return true;
        }
        /* Consider this vertex v and try different
           colors */
        for (int c = 1; c <= m; c++) {
            /* Check if assignment of color c to v
               is fine*/
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                /* recur to assign colors to rest of the vertices */
                if (graphColoringUtil(graph, m, color, v + 1)) {
                    return true;
                }

                /* If assigning color c doesn't lead
                   to a solution then remove it */
                color[v] = 0;
            }
        }

        /* If no color can be assigned to this vertex  then return false */
        return false;
    }
}
