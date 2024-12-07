import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import util.ArrayUtils;

/**
 * 699. 掉落的方块：https://leetcode.cn/problems/falling-squares/
 */
public class FallingSquares {

    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = positions[i][0], sideLength = positions[i][1];
            int cur = query(root, 0, N, left, left + sideLength - 1);
            update(root, 0, N, left, left + sideLength - 1, cur + sideLength);
            heights.add(root.val);
        }
        return heights;
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
            ans = query(node.left, start, mid, l, r);
        }
        if (mid < r) {
            ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
        }
        return ans;
    }

    void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.add = val;
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
        node.left.val = node.add;
        node.right.val = node.add;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }

    void pullUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    public static void main(String[] args) {
        System.out.println(new FallingSquares().fallingSquares(ArrayUtils.matrix("[[1,2],[2,3],[6,1]]"))); // [2, 5, 5]
        System.out.println(new FallingSquares().fallingSquares(ArrayUtils.matrix("[[100, 100], [200, 100]]"))); // [100, 100]
        System.out.println(new FallingSquares().fallingSquares(ArrayUtils.matrix("[[9,1],[6,5],[6,7]]"))); // [1,6,13]
    }

}
