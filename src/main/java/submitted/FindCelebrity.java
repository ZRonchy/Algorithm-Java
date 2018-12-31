package submitted;

/**
 * https://leetcode.com/submissions/detail/198172022/
 */
public class FindCelebrity {
    // The first pass is to pick out the candidate. If candidate knows i, then switch candidate.
    // The second pass is to check whether the candidate is real.
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }

    boolean knows (int i, int j) {
        return true;
    }
}
