package submitted;

/**
 * https://leetcode.com/submissions/detail/194435624/
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        UnionFind unionFind = new UnionFind(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int capacity) {
            this.parent = new int[capacity];
            this.rank = new int[capacity];
            this.count = capacity;
            for(int i = 0; i < capacity; ++i) {
                parent[i] = i;
            }
        }

        // find how many groups in union find
//        for (int i = 0; i < m * n; i++) {
//            if (find(i) == i) { // i is the root of one group
//                count++;
//            }
//        }
//        return count;
        public int find(int x) {
            if(x != parent[x]) {
                // find root and make root as parent of i (path compression)
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public int find_iterative(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xroot = find(x);
            int yroot = find(y);

            if (xroot != yroot) {
                count--;
            }

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
}
