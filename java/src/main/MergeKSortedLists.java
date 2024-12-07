import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个升序链表：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    /**
     * 遍历链表数组，每次取得最小的值节点即可
     */
    public static ListNode mergeKListsSimple(ListNode[] lists) {
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

    /**
     * 分治法求解
     */
    public static ListNode mergeKLists_DV(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left + 1 == right) {
            return mergeTwoLists(lists[left], lists[right]);
        }
        int mid = (left + right) / 2;
        ListNode leftList = mergeLists(lists, left, mid);
        ListNode rightList = mergeLists(lists, mid + 1, right);
        return mergeTwoLists(leftList, rightList);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (true) {
            if (list1 == null && list2 == null) {
                break;
            }
            int v1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int v2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            if (v1 < v2) {
                prev = prev.next = new ListNode(v1);
                list1 = list1.next;
            } else {
                prev = prev.next = new ListNode(v2);
                list2 = list2.next;
            }
        }
        ListNode ans = dummy.next;
        dummy.next = null;
        return ans;
    }

    /**
     * 使用优先队列求解
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator = (o1, o2) -> o1.val - o2.val;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(comparator);
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (!queue.isEmpty()) {
            ListNode list = queue.poll();
            prev = prev.next = new ListNode(list.val);
            if (list.next != null) {
                queue.offer(list.next);
            }
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
