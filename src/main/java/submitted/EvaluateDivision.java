package submitted;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class EvaluateDivision {
    // time O(e + q * e)   e is the number of equations and q is the number of queries
    // space O(e)
    Map<String, HashMap<String, Double>> g = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (int i = 0; i < equations.length; ++i) {
            String x = equations[i][0];
            String y = equations[i][1];
            double k = values[i];
            g.computeIfAbsent(x, l -> new HashMap<>()).put(y, k);
            g.computeIfAbsent(y, l -> new HashMap<>()).put(x, 1.0 / k);
        }

        double[] ans = new double[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            String x = queries[i][0];
            String y = queries[i][1];
            if (!g.containsKey(x) || !g.containsKey(y)) {
                ans[i] = -1.0;
            } else {
                ans[i] = divide(x, y, new HashSet<>());
            }
        }

        return ans;
    }

    private double divide(String x, String y, Set<String> visited) {
        if (x.equals(y)) return 1.0;
        visited.add(x);
        if (!g.containsKey(x)) return -1.0;
        for (String n : g.get(x).keySet()) {
            if (visited.contains(n)) continue;
            visited.add(n);
            double d = divide(n, y, visited);
            if (d > 0) return d * g.get(x).get(n);
        }
        return -1.0;
    }
}

class EvaluateDivisionUnionFind {
    // time O(e + q)   e is the number of equations and q is the number of queries
    // space O(e)
    class Node {
        public String parent;
        public double ratio;
        public Node(String parent, double ratio) {
            this.parent = parent;
            this.ratio = ratio;
        }
    }

    class UnionFindSet {
        private Map<String, Node> parents = new HashMap<>();

        public Node find(String s) {
            if (!parents.containsKey(s)) return null;
            Node n = parents.get(s);
            if (!n.parent.equals(s)) {
                Node p = find(n.parent);
                n.parent = p.parent;
                n.ratio *= p.ratio;
            }
            return n;
        }

        public void union(String s, String p, double ratio) {
            boolean hasS = parents.containsKey(s);
            boolean hasP = parents.containsKey(p);
            if (!hasS && !hasP) {
                parents.put(s, new Node(p, ratio));
                parents.put(p, new Node(p, 1.0));
            } else if (!hasP) {
                parents.put(p, new Node(s, 1.0 / ratio));
            } else if (!hasS) {
                parents.put(s, new Node(p, ratio));
            } else {
                Node rS = find(s);
                Node rP = find(p);
                rS.parent = rP.parent;
                rS.ratio = ratio / rS.ratio * rP.ratio;
            }
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        UnionFindSet u = new UnionFindSet();

        for (int i = 0; i < equations.length; ++i)
            u.union(equations[i][0], equations[i][1], values[i]);

        double[] ans = new double[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            Node rx = u.find(queries[i][0]);
            Node ry = u.find(queries[i][1]);
            if (rx == null || ry == null || !rx.parent.equals(ry.parent))
                ans[i] = -1.0;
            else
                ans[i] = rx.ratio / ry.ratio;
        }

        return ans;
    }
}
