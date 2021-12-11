/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 思路：两个链表从左往右遍历，相同位的数字相加并加上进位，进位h置位0，如果相加的结果大于等于10，那么结果减10，
 * 记录进位的状态1，建立相应位置的节点对象，两个链表指向下一位，重复进行该操作直到两链表都到达尾部且没有进位了
 */
public class LinkNodeAddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;
            int value = value1 + value2 + carry;
            carry = value / 10;
            if (tail != null) {
                tail = tail.next = new ListNode(value % 10);
            } else {
                root = tail = new ListNode(value % 10);
            }
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
        }
        return root;
    }

    public static ListNode buildList(long value) {
        String stringValue = Long.toString(value);
        ListNode root = null, tail = null;
        for (int i = stringValue.length() - 1; i >= 0; i--) {
            int num = Integer.parseInt(String.valueOf(stringValue.charAt(i)));
            if (tail != null) {
                tail = tail.next = new ListNode(num);
            } else {
                root = tail = new ListNode(num);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = buildList(9999999);
        ListNode l2 = buildList(9999);
        ListNode r = addTwoNumbers(l1, l2);
        System.out.println(r);

        l1 = buildList(243);
        l2 = buildList(564);
        r = addTwoNumbers(l1, l2);
        System.out.println(r);

        l1 = buildList(0);
        l2 = buildList(0);
        r = addTwoNumbers(l1, l2);
        System.out.println(r);
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.reverse().toString();
    }
}