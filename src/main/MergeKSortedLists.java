/**
 * 合并K个升序链表：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    /**
     * 遍历链表数组，每次取得最小的值节点即可
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (true) {
            int minValue = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if (list == null) {
                    continue;
                }
                if (list.val < minValue) {
                    index = i;
                    minValue = list.val;
                }
            }
            if (index == -1) {
                break;
            }
            prev = prev.next = new ListNode(lists[index].val);
            lists[index] = lists[index].next;
        }
        ListNode ans = dummy.next;
        dummy.next = null;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mergeKLists(new ListNode[]{
            ListNode.of(1,4,5), ListNode.of(1,3,4), ListNode.of(2,6)
        }));
        System.out.println(mergeKLists(new ListNode[]{}));
        System.out.println(mergeKLists(new ListNode[]{null}));
    }

}
