import java.util.Arrays;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数：https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 */
public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        System.out.println(new CountOfSmallerNumbersAfterSelf()
            .countSmaller(new int[] {5,2,6,1})); // [2,1,1,0]
        System.out.println(new CountOfSmallerNumbersAfterSelf()
            .countSmaller(new int[] {-1})); // [0]
        System.out.println(new CountOfSmallerNumbersAfterSelf()
            .countSmaller(new int[] {-1, -1})); // [0,0]
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        L = nums[0];
        R = nums[0];
        for (int num : nums) {
            L = Math.min(L, num);
            R = Math.max(R, num);
        }
        Integer[] ans = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = query(root, L, R, L, nums[i] - 1);
            update(root, L, R, nums[i], nums[i], 1);
        }
        return Arrays.asList(ans);
    }

    void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += val;
            node.add += val;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (mid >= l) {
            update(node.left, start, mid, l, r, val);
        }
        if (r > mid) {
            update(node.right, mid + 1, end, l, r, val);
        }
        pullUp(node);
    }

    int query(Node node, int start, int end, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l <= start && end <= r) {
            return node.val;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        int ans = 0;
        if (mid >= l) {
            ans = query(node.left, start, mid, l, r);
        }
        if (r > mid) {
            ans += query(node.right, mid + 1, end, l, r);
        }
        return ans;
    }

    private void pullUp(Node node) {
        node.val = node.left.val + node.right.val;
    }

    private void pushDown(Node node, int leftSum, int rightSum) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return;
        }
        node.left.val += node.add * leftSum;
        node.right.val += node.add * rightSum;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    int L, R;

    Node root = new Node();

    static class Node {
        Node left, right;
        int val, add;
    }

}
