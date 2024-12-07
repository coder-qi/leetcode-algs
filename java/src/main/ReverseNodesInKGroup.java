import java.util.Deque;
import java.util.LinkedList;

/**
 * K 个一组翻转链表：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {

    /**
     * 使用栈来解决
     */
    public static ListNode reverseKGroupByStack(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        Deque<ListNode> stack = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (head != null) {
            stack.push(head);
            head = head.next;
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    ListNode cur = stack.pop();
                    prev.next = cur;
                    prev = cur;
                }
                prev.next = head;
            }
        }

        ListNode ans = dummy.next;
        dummy.next = null;
        return ans;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        return reverseKGroup(head, new ListNode[k]);
    }

    /**
     * 递归解法
     */
    public static ListNode reverseKGroup(ListNode head, ListNode[] arr) {
        int count = 0;
        ListNode cur = head;
        while (cur != null && count < arr.length) {
            arr[count++] = cur;
            cur = cur.next;
        }
        if (count < arr.length) {
            return head;
        }
        ListNode newHead = arr[arr.length - 1];
        cur = newHead;
        ListNode next = newHead.next;
        for (int i = arr.length - 2; i >= 0; i--) {
            cur = cur.next = arr[i];
        }
        cur.next = next;
        cur.next = reverseKGroup(cur.next, arr);
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 2));
        System.out.println(reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 3));
        System.out.println(reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 1));
        System.out.println(reverseKGroup(ListNode.of(1), 1));
    }

}
