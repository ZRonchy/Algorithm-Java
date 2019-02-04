package submitted;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfAString {
    public List<String> permutation(String input) {
        List<String> res = new ArrayList<String>();
        if (input == null || input.length() == 0) {
            return res;
        }
        boolean[] used = new boolean[input.length()];
        permutation(res, input, "", used);
        return res;
    }

    void permutation(List<String> res, String input, String temp, boolean[] used) {
        if (temp.length() == input.length()) {
            res.add(temp);
        }

        // start from i=0 not i=start, as we need to revisit element
        for (int i = 0; i < input.length(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            permutation(res, input, temp + input.charAt(i), used);
            used[i] = false;
        }
    }
}
