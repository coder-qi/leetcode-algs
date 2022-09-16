import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import static util.ArrayUtils.matrix;

/**
 * 850. 矩形面积 II：https://leetcode.cn/problems/rectangle-area-ii/
 */
public class RectangleAreaII {

    public static void main(String[] args) {
        System.out.println(new RectangleAreaII().rectangleArea(matrix("[[0,0,2,2],[1,0,2,3],[1,0,3,1]]")));
        System.out.println(new RectangleAreaII().rectangleArea(matrix("[[0,0,1000000000,1000000000]]")));
        System.out.println(new RectangleAreaII().rectangleArea(matrix("[[0,0,1,1],[2,2,3,3]]")));
    }

    public int rectangleArea(int[][] rectangles) {
        final var MOD = (int) (1e9 + 7);
        var n = rectangles.length;
        var ys = new TreeSet<Integer>();
        var xs = new ArrayList<int[]>();
        for (var rect : rectangles) {
            xs.add(new int[] {rect[0], rect[1], rect[3], 1});
            xs.add(new int[] {rect[2], rect[1], rect[3], -1});
            ys.add(rect[1]);
            ys.add(rect[3]);
        }
        Collections.sort(xs, Comparator.comparingInt(a -> a[0]));

        nums = new ArrayList<>(n);
        var map = new HashMap<Integer, Integer>();
        for (int y : ys) {
            nums.add(y);
            map.put(y, nums.size() - 1);
        }
        long ans = 0;
        for (int i = 0; i < xs.size(); i++) {
            int[] p = xs.get(i);
            int x = p[0], y1 = p[1], y2 = p[2], k = p[3];
            if (i > 0) {
                ans += (long)root.val * (x - xs.get(i - 1)[0]);
            }
            update(root, 0, nums.size() - 1, map.get(y1), map.get(y2) - 1, k);
        }
        ans %= MOD;
        return (int) ans;
    }

    Node root = new Node();
    List<Integer> nums;

    static class Node {
        Node left, right;
        int val, add;
    }

    void update(Node node, int start, int end, int l, int r, int val) {
        pushDown(node);
        if (l <= start && end <= r) {
            node.add += val;
            pullUp(node, start, end);
            return;
        }
        int mid = (start + end) >> 1;
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }
        if (mid < r) {
            update(node.right, mid + 1, end, l, r, val);
        }
        pullUp(node, start, end);
    }

    private void pullUp(Node node, int start, int end) {
        if (node.add > 0) {
            node.val = nums.get(end + 1) - nums.get(start);
        } else if (end != start) {
            node.val = node.left.val + node.right.val;
        } else {
            node.val = 0;
        }
    }

    private void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
    }

}
