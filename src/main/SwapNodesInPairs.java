/**
 * 两两交换链表中的节点：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        head = new ListNode(0, head);

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            prev.next = next;

            prev = cur;
            cur = cur.next;
        }

        ListNode ans = head.next;
        head.next = null;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(swapPairs(ListNode.of(1, 2, 3, 4)));
        System.out.println(swapPairs(ListNode.of()));
        System.out.println(swapPairs(ListNode.of(1)));
    }

}
