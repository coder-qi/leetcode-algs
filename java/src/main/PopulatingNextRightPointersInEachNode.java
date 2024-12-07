/**
 * 填充每个节点的下一个右侧节点指针：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur.left != null) {
            Node prev = null, next = cur;
            while (next != null) {
                if (prev != null) {
                    prev.right.next = next.left;
                }
                next.left.next = next.right;
                prev = next;
                next = next.next;
            }
            cur = cur.left;
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(connect(Node.of(1,2,3,4,5,6,7)));
    }

}
