package submitted;

public class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int capacity) {
        this.parent = new int[capacity];
        this.rank = new int[capacity];
        for(int i = 0; i < capacity; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(x != parent[x]) {
            // find root and make root as parent of i (path compression)
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int xroot = find(x);
        int yroot = find(y);

        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (rank[xroot] < rank[yroot]) {
            parent[xroot] = yroot;
        } else if (rank[xroot] > rank[yroot]) {
            parent[yroot] = xroot;
        } else {
            // if rank is equal, attach in either case and increase rank
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }
}
