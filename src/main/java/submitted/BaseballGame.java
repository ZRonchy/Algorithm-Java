package submitted;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/202260847/
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> s = new ArrayList<Integer>();

        for (String op : ops) {
            int n = s.size();
            if (op.equals("+"))
                s.add(s.get(n - 1) + s.get(n - 2));
            else if (op.equals("C"))
                s.remove(n - 1);
            else if (op.equals("D"))
                s.add(s.get(n - 1) * 2);
            else
                s.add(Integer.parseInt(op));
        }

        return s.stream().reduce(0, Integer::sum);
    }
}
