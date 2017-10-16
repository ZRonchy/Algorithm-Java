package datastructure.breadthfirstsearch;

public class BreadthFirstSearchTest {
    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);

        n1.neighbors = new GraphNode[]{n2, n3, n5};
        n2.neighbors = new GraphNode[]{n1, n4};
        n3.neighbors = new GraphNode[]{n1, n4, n5};
        n4.neighbors = new GraphNode[]{n2, n3, n5};
        n5.neighbors = new GraphNode[]{n1, n3, n4};

        breadthFirstSearch(n1, 5);
    }

    public static void breadthFirstSearch(GraphNode root, int value) {
        if(root.val == value) {
            System.out.println("Find the value at root");
        }

        Queue queue = new Queue();
        root.visited = true;
        queue.enqueue(root);

        while(queue.first != null) {
            GraphNode c = queue.dequeue();
            for(GraphNode neighbor: c.neighbors) {
                if(!neighbor.visited) {
                    neighbor.visited = true;
                    if(neighbor.val == value) {
                        System.out.println("Found " + neighbor);
                    }
                    queue.enqueue(neighbor);
                }
            }
        }
    }
}
