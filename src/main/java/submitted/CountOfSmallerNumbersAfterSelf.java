package submitted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/210400454/
 * time O(nlogn) on average, O(n*n) worst case
 * space: O(k) k is the number of unique elements
 */
public class CountOfSmallerNumbersAfterSelf {
    class Node {
        int val;
        int count;
        int leftCount;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            this.count = 1;
        }
        public int lessOrEqual() {
            return count + leftCount;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        int n = nums.length;
        Node root = new Node(nums[n - 1]);
        ans.add(0);
        for (int i = n - 2; i >= 0; --i) {
            ans.add(insert(root, nums[i]));
        }
        Collections.reverse(ans);
        return ans;
    }

    private int insert(Node root, int val) {
        if (root.val == val) {
            ++root.count;
            return root.leftCount;
        } else if (val < root.val) {
            ++root.leftCount;
            if (root.left == null) {
                root.left = new Node(val);
                return 0;
            }
            return insert(root.left, val);
        } else  {
            if (root.right == null) {
                root.right = new Node(val);
                return root.lessOrEqual();
            }
            return root.lessOrEqual() + insert(root.right, val);
        }
    }
}
