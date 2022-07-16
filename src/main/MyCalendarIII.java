/**
 * 732. 我的日程安排表 III：https://leetcode.cn/problems/my-calendar-iii/
 */
public class MyCalendarIII {

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
        myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
        myCalendarThree.book(5, 10); // 返回 3
        myCalendarThree.book(25, 55); // 返回 3
    }

}

class MyCalendarThree {


    public MyCalendarThree() {
    }

    public int book(int start, int end) {
        update(root, 0, N, start, end - 1, 1);
        return root.val;
    }

    static final int N = (int) 1e9;

    static class Node {
        Node left, right;
        int val, add;
    }

    Node root = new Node();

    void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += val;
            node.add += val;
            return;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }
        if (r > mid) {
            update(node.right, mid + 1, end, l, r, val);
        }
        pullUp(node);
    }

    private void pullUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    private void pushDown(Node node) {
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
}
