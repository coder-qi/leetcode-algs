package offerII;

/**
 * 剑指 Offer II 029. 排序的循环链表：https://leetcode.cn/problems/4ueAj6/
 */
public class InsertIntoASortedCycleLinkedList {

    public static Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node cur = head, next = head.next;
        while (next != head) {
            if (insertVal >= cur.val && insertVal <= next.val) {
                break;
            }
            if (cur.val > next.val) {
                if (insertVal > cur.val || insertVal < next.val) {
                    break;
                }
            }
            cur = cur.next;
            next = next.next;
        }
        cur.next = node;
        node.next = next;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(insert(Node.of(3,4,1), 2));
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }

        public static Node of(int... nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            Node dummy = new Node(), head = dummy;
            for (int i = 0; i < nums.length; i++) {
                Node x = new Node(nums[i]);
                head.next = x;
                head = x;
            }
            head.next = dummy.next;
            return dummy.next;
        }

    };

}
