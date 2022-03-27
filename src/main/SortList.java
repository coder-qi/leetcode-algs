import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序链表：https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, Comparator.comparingInt(n -> n.val));
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(sortList(ListNode.of(4,2,1,3)));
        System.out.println(sortList(ListNode.of(-1,5,3,4,0)));
    }

}
