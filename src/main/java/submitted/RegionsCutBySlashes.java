package submitted;

public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int count = 1;
        UnionFindR uf = new UnionFindR(grid.length + 1);
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                count += uf.union(row, col, grid[row].charAt(col));
            }
        }
        return count;
    }
}

class UnionFindR {
    private int width;
    private int[] parent;
    private int[] weight;

    public UnionFindR(int n) {
        width = n;
        int size = n * n;
        parent = new int[size];
        weight = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        int gap = size - n;
        for (int i = 0; i < n; i++) {
            parent[i] = 0;
            parent[i + gap] = 0;
        }
        gap = n - 1;
        for (int i = 0; i < size; i += n) {
            parent[i] = 0;
            parent[i + gap] = 0;
        }
        weight[0] = n * 4 - 4;
        for (int i = 1; i < size; i++) {
            weight[i] = 1;
        }
    }

    private int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int union(int row, int col, char op) {
        if (op == ' ')
            return 0;
        int rootP, rootQ;
        if (op == '/') {
            rootP = find(row * width + col + 1);
            rootQ = find((row + 1) * width + col);
        } else {
            rootP = find(row * width + col);
            rootQ = find((row + 1) * width + col + 1);
        }
        if (rootP == rootQ) {
            return 1;
        }
        if (weight[rootP] < weight[rootQ]) {
            parent[rootP] = rootQ;
            weight[rootQ] += weight[rootP];
        } else {
            parent[rootQ] = rootP;
            weight[rootP] += weight[rootQ];
        }
        return 0;
    }
}