/**
 * 558. 四叉树交集：https://leetcode.cn/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
 */
public class LogicalOrOfTwoBinaryGridsRepresentedAsQuadTrees {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public static Node intersect(Node quadTree1, Node quadTree2) {
        if ((quadTree1.isLeaf && quadTree1.val) || (quadTree2.isLeaf && !quadTree2.val)) {
            return quadTree1;
        } else if ((quadTree2.isLeaf && quadTree2.val) || (quadTree1.isLeaf && !quadTree1.val)) {
            return quadTree2;
        } else {
            Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                    && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
                return topLeft;
            }
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    public static void main(String[] args) {

    }

}
