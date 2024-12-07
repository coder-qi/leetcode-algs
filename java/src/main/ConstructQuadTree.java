import java.util.Deque;
import java.util.LinkedList;

import static util.ArrayUtils.matrix;

/**
 * 427. 建立四叉树：https://leetcode-cn.com/problems/construct-quad-tree/
 */
public class ConstructQuadTree {

    public static Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        int n = grid.length;
        return construct(grid, 0, 0, n);
    }

    private static Node construct(int[][] grid, int row, int column, int len) {
        Node root;
        if (len > 1) {
            int halfLen = len / 2;
            Node topLeft = construct(grid, row, column, halfLen);
            Node topRight = construct(grid, row, column + halfLen, halfLen);
            Node bottomLeft = construct(grid, row + halfLen, column, halfLen);
            Node bottomRight = construct(grid, row + halfLen, column + halfLen, halfLen);
            boolean merged = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
            if (merged) {
                int k = (topLeft.val ? 1 : 0) + (topRight.val ? 1 : 0)
                    + (bottomLeft.val ? 1 : 0) + (bottomRight.val ? 1 : 0);
                merged = k == 0 || k == 4;
            }
            if (merged) {
                root = new Node(topLeft.val, true);
            } else {
                root = new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        } else {
            root = new Node(grid[row][column] == 1 ? true : false, true);
        }

        return root;
    }

    public static void main(String[] args) {
        // [[0,1],[1,0],[1,1],[1,1],[1,0]]
        System.out.println(construct(matrix("[[0,1],[1,0]]")));
        // [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
        System.out.println(construct(matrix("[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]")));
        // [[0,1],[0,1],[0,1],[0,1],[0,1],[1,1],[1,1],[1,0],[1,0],[1,0],[1,0],[1,1],[1,1],[1,1],[1,1],[1,0],[1,0],[1,0],[1,0],[1,1],[1,1]]
        System.out.println(construct(matrix("[[1,1,0,0],[0,0,1,1],[1,1,0,0],[0,0,1,1]]")));
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append('[');
            Deque<Node> q = new LinkedList<>();
            q.offer(this);
            while (!q.isEmpty()) {
                int count = q.size();
                for (int i = 0; i < count; i++) {
                    Node x = q.poll();
                    if (x == null) {
                        result.append("null").append(',');
                        continue;
                    }
                    result.append('[')
                        .append(x.isLeaf ? 1 : 0)
                        .append(',')
                        .append(x.val ? 1 : 0)
                        .append(']')
                        .append(',');
                    if (x.topLeft != null || x.topRight != null || x.bottomLeft != null || x.bottomRight != null) {
                        q.offer(x.topLeft);
                        q.offer(x.topRight);
                        q.offer(x.bottomLeft);
                        q.offer(x.bottomRight);
                    }
                }
            }
            result.setLength(result.length() - 1);
            result.append(']');
            return  result.toString();
        }
    }

}
