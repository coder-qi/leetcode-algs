/**
 * 933. 最近的请求次数：https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class NumberOfRecentCalls {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3

        System.out.println("-------------------------");
        recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(641));
        System.out.println(recentCounter.ping(1849));
        System.out.println(recentCounter.ping(4921));
        System.out.println(recentCounter.ping(5936));
        System.out.println(recentCounter.ping(5957));

    }

}

class RecentCounter {

    public RecentCounter() {
    }

    public int ping(int t) {
        update(root, 1, N, t, t, 1);
        return query(root, 1, N, Math.max(1, t - 3000), t);
    }

    static final int N = (int) 1e9;

    Node root = new Node();

    static class Node {
        Node left, right;
        int add, val;
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

    void pushDown(Node node, int leftSum, int rightSum) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return;
        }
        node.left.val += leftSum * node.add;
        node.right.val += rightSum * node.add;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }

    void pullUp(Node node) {
        node.val = node.left.val + node.right.val;
    }
}