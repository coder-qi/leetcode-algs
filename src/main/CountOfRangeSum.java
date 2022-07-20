/**
 * 327. 区间和的个数：https://leetcode.cn/problems/count-of-range-sum/
 */
public class CountOfRangeSum {

    public static void main(String[] args) {
        System.out.println(new CountOfRangeSum().countRangeSum(new int[] {-2,5,-1}, -2, 2));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] += preSum[i - 1] + nums[i - 1];
        }
        long L = Long.MAX_VALUE, R = Long.MIN_VALUE;
        for (long x : preSum) {
            L = Math.min(Math.min(L, x), Math.min(x - lower, x - upper));
            R = Math.max(Math.max(R, x), Math.max(x - lower, x - upper));
        }
        Node root = new Node(L, R);
        int ans = 0;
        for (long x : preSum) {
            ans += count(root, x - upper, x - lower);
            add(root, x);
        }
        return ans;
    }

    int count(Node node, long left, long right) {
        if (node == null) {
            return 0;
        }
        if (left > node.hi || right < node.lo) {
            return 0;
        }
        if (left <= node.lo && node.hi <= right) {
            return node.add;
        }
        return count(node.left, left, right) + count(node.right, left, right);
    }

    void add(Node node, long val) {
        node.add++;
        if (node.lo == node.hi) {
            return;
        }
        long mid = (node.lo + node.hi) >> 1;
        if (val <= mid) {
            if (node.left == null) {
                node.left = new Node(node.lo, mid);
            }
            add(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new Node(mid + 1, node.hi);
            }
            add(node.right, val);
        }
    }

    static class Node {
        Node left, right;
        long lo, hi;
        int add;

        public Node(long lo, long hi) {
            this.lo = lo;
            this.hi = hi;
        }
    }


}
