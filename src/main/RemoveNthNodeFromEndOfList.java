import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第 N 个结点：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 计算链表长度来解决
     */
    public static ListNode removeNthFromEndByLength(ListNode head, int n) {
        // 先计算待移除节点的正序索引
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        int removeIndex = count - n;

        // 找到对应的位置进行移除
        if (removeIndex == 0) {
            ListNode next = head.next;
            head.next = null;
            return next;
        }
        ListNode prev = head;
        int index = 0;
        while (prev != null) {
            if (index++ == removeIndex - 1) {
                break;
            }
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    /**
     * 使用栈
     */
    public static ListNode removeNthFromEndByStack(ListNode head, int n) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        dummy.next = null;
        return ans;
    }

    /**
     * 双指针
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        dummy.next = null;
        return ans;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

}
