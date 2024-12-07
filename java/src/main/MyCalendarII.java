/**
 * 731. 我的日程安排表 II：https://leetcode.cn/problems/my-calendar-ii/
 */
public class MyCalendarII {

    public static void main(String[] args) {
        MyCalendarTwo calendar = new MyCalendarTwo();
        System.out.println(calendar.book(10, 20)); // returns true
        System.out.println(calendar.book(50, 60)); // returns true
        System.out.println(calendar.book(10, 40)); // returns true
        System.out.println(calendar.book(5, 15)); // returns false
        System.out.println(calendar.book(5, 10)); // returns true
        System.out.println(calendar.book(25, 55)); // returns true
    }

}

class MyCalendarTwo {

    public MyCalendarTwo() {
    }

    public boolean book(int start, int end) {
        if (query(root, 0, N, start, end - 1) >= 2) {
            return false;
        }
        update(root, 0, N, start, end - 1, 1);
        return true;
    }

    static final int N = (int) 1e9;

    Node root = new Node();

    static class Node {
        Node left, right;
        int add, val;
    }

    void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += val;
            node.add += val;
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
            ans = query(node.left, start, mid, l, r);
        }
        if (mid < r) {
            ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
        }
        return ans;
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
        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    void pullUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }
}
