package submitted;

import java.util.*;

/**
 *  https://leetcode.com/submissions/detail/204074941/
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget_BFS(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> q = new ArrayDeque<>();
        q.add(Arrays.asList(0));

        while(!q.isEmpty()) {
            List<Integer> e = q.remove();
            if(e.get(e.size() - 1) == graph.length - 1) {
                res.add(e);
                continue;
            }

            for(int n : graph[e.get(e.size() - 1)]) {
                List<Integer> next = new ArrayList(e);
                next.add(n);
                q.add(next);
            }
        }

        return res;
    }
}
