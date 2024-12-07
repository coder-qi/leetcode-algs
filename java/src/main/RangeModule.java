/**
 * 715. Range 模块：https://leetcode.cn/problems/range-module/
 */
public class RangeModule {

    public RangeModule() {
    }

    public void addRange(int left, int right) {
        update(root, 1, N, left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return query(root, 1, N, left, right - 1);
    }

    public void removeRange(int left, int right) {
        update(root, 1, N, left, right - 1, -1);
    }

    static class Node {
        Node left, right;
        boolean cover;
        int add;
    }

    static final int N = (int) 1e9;
    Node root = new Node();

    void update(Node root, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            root.cover = val == 1;
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

    boolean query(Node root, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
           return root.cover;
        }
        int mid = (start + end) >> 1;
        pushDown(root, mid - start + 1, end - mid);
        boolean ans = true;
        if (l <= mid) {
            ans = ans && query(root.left, start, mid, l, r);
        }
        if (r > mid) {
            ans = ans && query(root.right, mid + 1, end, l, r);
        }
        return ans;
    }

    private void pullUp(Node root) {
        root.cover = root.left.cover && root.right.cover;
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
        root.left.cover = root.add == 1;
        root.right.cover = root.add == 1;
        root.left.add = root.add;
        root.right.add = root.add;
        root.add = 0;
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        System.out.println(rangeModule.queryRange(10, 14)); // 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
        System.out.println(rangeModule.queryRange(13, 15)); // 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
        System.out.println(rangeModule.queryRange(16, 17)); // 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）

        System.out.println("-------------------------");
        rangeModule = new RangeModule();
        rangeModule.addRange(10, 180);
        rangeModule.addRange(150, 200);
        rangeModule.addRange(250, 500);
        System.out.println(rangeModule.queryRange(50, 100)); // 返回 true
        System.out.println(rangeModule.queryRange(160, 300)); // 返回 false
        System.out.println(rangeModule.queryRange(600, 1000)); // 返回 false
        rangeModule.removeRange(50, 150);
        System.out.println(rangeModule.queryRange(50, 100)); // 返回 false
    }

}
