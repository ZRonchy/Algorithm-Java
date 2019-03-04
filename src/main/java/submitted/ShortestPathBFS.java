package submitted;

import java.util.*;

class Graph {
    // 图的起点
    private String firstVertex;
    // 邻接表
    private Map<String, List<String>> adj = new HashMap<>();

    public Graph() {
    }

    public void setFirstVertex(String firstVertex) {
        this.firstVertex = firstVertex;
    }

    public void addEdge(String fromVertex, String toVertex) {
        if (firstVertex == null) {
            firstVertex = fromVertex;
        }
        adj.get(fromVertex).add(toVertex);
        adj.get(toVertex).add(fromVertex);
    }

    public void addVertex(String vertex) {
        adj.put(vertex, new ArrayList<String>());
    }

    public Map<String, List<String>> getAdj() {
        return adj;
    }
}

class ShortestPathBFS {
    private List<String> BFS(Graph g, String sourceVertex, String distVertex) {
        Map<String, List<String>> paths = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        List<String> visitedVertex = new ArrayList<>();

        //标记起点
        visitedVertex.add(sourceVertex);
        // 起点入列
        queue.add(sourceVertex);
        List<String> tempPath = new ArrayList<>();
        tempPath.add(sourceVertex);
        paths.put(sourceVertex, tempPath);
        while (!queue.isEmpty()) {
            String cur = queue.poll();  //返回队列头部，或null，如果队列为空
            List<String> toBeVisitedVertex = g.getAdj().get(cur);
            for (String v : toBeVisitedVertex) {
                if (v.equals(distVertex)) {
                    List<String> path = paths.get(cur);
                    path.add(v);
                    return path;
                }

                if (!visitedVertex.contains(v)) {
                    visitedVertex.add(v);
                    List<String> path = new ArrayList<>(paths.get(cur));
                    path.add(v);
                    paths.put(v, path);
                    queue.add(v);   //后添加的要等前面的所有距离为currDist的顶点都被处理之后才被处理
                }
            }
        }
        return new ArrayList<>();
    }
}