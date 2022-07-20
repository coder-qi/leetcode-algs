/**
 * 2276. 统计区间中的整数数目：https://leetcode.cn/problems/count-integers-in-intervals/
 */
public class CountIntegersInIntervals {

    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
        countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
        countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
        System.out.println(countIntervals.count());     // 返回 6
                                                        // 整数 2 和 3 出现在区间 [2, 3] 中
                                                        // 整数 7、8、9、10 出现在区间 [7, 10] 中

        countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
        System.out.println(countIntervals.count());     // 返回 8
                                                        // 整数 2 和 3 出现在区间 [2, 3] 中
                                                        // 整数 5 和 6 出现在区间 [5, 8] 中
                                                        // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
                                                        // 整数 9 和 10 出现在区间 [7, 10] 中
    }

}

class CountIntervals {

    public CountIntervals() {
    }

    public void add(int left, int right) {
        update(root, 1, N, left, right, 1);
    }

    public int count() {
        return root.val;
    }

    static class Node {
        Node left, right;
        int val, add;
    }

    static final int N = (int) 1e9;
    Node root = new Node();

    void update(Node root, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            root.val = (end - start + 1) * val;
            root.add = val;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(root, mid - start + 1, end - mid);
        if (l <= mid) {
            update(root.left, start, mid, l, r, val);
        }
        if (r > mid) {
            update(root.right, mid + 1, end, l, r, val);
        }
        pullUp(root);
    }

    private void pullUp(Node root) {
        root.val = root.left.val + root.right.val;
    }

    private void pushDown(Node root, int leftNum, int rightNum) {
        if (root.left == null) {
            root.left = new Node();
        }
        if (root.right == null) {
            root.right = new Node();
        }
        if (root.add == 0) {
            return;
        }
        root.left.val = leftNum * root.add;
        root.right.val = rightNum * root.add;
        root.left.add = root.add;
        root.right.add = root.add;
        root.add = 0;
    }
}
