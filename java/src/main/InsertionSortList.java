/**
 * 对链表进行插入排序：https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0 ,head);
        ListNode cur = head.next, curPrev = dummy.next;
        while (cur != null) {
            ListNode x = dummy.next, xPrev = dummy;
            if (cur.val < curPrev.val) {
                while (x != cur && x.val <= cur.val) {
                    xPrev = xPrev.next;
                    x = x.next;
                }
                if (x != cur) {
                    xPrev.next = cur;
                    curPrev.next = cur.next;
                    cur.next = x;

                    cur = curPrev.next;
                    continue;
                }
            }
            curPrev = curPrev.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(insertionSortList(ListNode.of(4,2,1,3)));
        System.out.println(insertionSortList(ListNode.of(-1,5,3,4,0)));
        System.out.println(insertionSortList(ListNode.of(5,4,3,2,1)));
    }

}
