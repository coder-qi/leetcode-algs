import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {

    public static Node copyRandomList(Node head) {
        Node dummy = new Node(0), copyPrevNode = dummy;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node h = head;
            Node copyNode = map.computeIfAbsent(head, k -> new Node(h.val));
            copyPrevNode.next = copyNode;
            copyPrevNode = copyNode;
            if (head.random != null) {
                Node randomNode = map.computeIfAbsent(head.random, k -> new Node(h.random.val));
                copyNode.random = randomNode;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
