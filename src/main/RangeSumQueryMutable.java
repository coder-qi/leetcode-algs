/**
 * 307. 区域和检索 - 数组可修改：https://leetcode.cn/problems/range-sum-query-mutable/
 */
public class RangeSumQueryMutable {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {1, 3, 5});
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1,2,5]
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 2 + 5 = 8
    }

}

class NumArray {

    public NumArray(int[] nums) {
        n = nums.length - 1;
        for (int i = 0; i <= n; i++) {
            update(root, 0, n, i, i, nums[i]);
        }
    }

    public void update(int index, int val) {
        update(root, 0, n, index, index, val);
    }

    public int sumRange(int left, int right) {
        return query(root, 0, n, left, right);
    }

    Node root = new Node();
    int n;

    static class Node {
        Node left, right;
        int val, add;
    }

    void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.add += (end - start + 1) * val;
            node.val = val;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }
        if (mid < r) {
            update(node.right, mid + 1, end, l, r, val);
        }
        pullUp(node);
    }

    int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.val;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        int ans = 0;
        if (l <= mid) {
            ans += query(node.left, start, mid, l, r);
        }
        if (mid < r) {
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
        node.left.val = leftSum * node.add;
        node.right.val = rightSum * node.add;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }
}
