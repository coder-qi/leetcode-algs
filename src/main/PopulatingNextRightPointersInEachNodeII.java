/**
 * 填充每个节点的下一个右侧节点指针 II：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

    private Node last = null, nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            last = nextStart = null;
            for (Node p = cur; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            cur = nextStart;
        }
        return root;
    }

    private void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }

    public static void main(String[] args) {
        System.out.println(new PopulatingNextRightPointersInEachNodeII().connect(Node.of(1,2,3,4,5,null,7)));
        System.out.println(new PopulatingNextRightPointersInEachNodeII().connect(Node.of(1,2,3,4,null,null,5)));
        System.out.println(new PopulatingNextRightPointersInEachNodeII().connect(Node.of(-1,-7,9,null,null,-1,-7,null,8,-9)));
    }

}
