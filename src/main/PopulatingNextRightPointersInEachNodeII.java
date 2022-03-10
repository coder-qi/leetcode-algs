import java.util.Deque;
import java.util.LinkedList;

/**
 * 填充每个节点的下一个右侧节点指针 II：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            Node prev = null;
            for (int i = 0; i < count; i++) {
                Node cur = queue.poll();
                if (prev != null) {
                    prev.next = cur;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                prev = cur;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(connect(Node.of(1,2,3,4,5,null,7)));
    }

}
