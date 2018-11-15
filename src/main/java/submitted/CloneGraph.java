package submitted;

import java.util.*;

/**
 * https://leetcode.com/submissions/detail/189805328/
 * BFS and DFS
 */
public class CloneGraph {
    Map<UndirectedGraphNode, UndirectedGraphNode> clonedNodes = new HashMap<>();

    public UndirectedGraphNode cloneGraph_dfs(UndirectedGraphNode node) {
        return helper(node);
    }

    UndirectedGraphNode helper(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (clonedNodes.containsKey(node)) {
            return clonedNodes.get(node);
        }

        UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
        clonedNodes.put(node, dup);
        for (UndirectedGraphNode neighbour: node.neighbors) {
            UndirectedGraphNode clone = helper(neighbour);
            dup.neighbors.add(clone);
        }
        return dup;
    }

    // BFS
    public UndirectedGraphNode cloneGraph_bfs(UndirectedGraphNode node) {
        if (node == null) return node;
        List<UndirectedGraphNode> nodes = getNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        for (UndirectedGraphNode cur : nodes) {
            map.put(cur, new UndirectedGraphNode(cur.label));
        }
        for (UndirectedGraphNode cur : nodes) {
            UndirectedGraphNode newNode = map.get(cur);
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }
}


class UndirectedGraphNode {
  int label;
  List<UndirectedGraphNode> neighbors;
  UndirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<>();
  }
}