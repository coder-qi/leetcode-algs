public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode prev = head;
        for (int i = 1; i < values.length; i++) {
            prev = prev.next = new ListNode(values[i]);
        }
        return head;
    }

    public static ListNode ofCycle(int[] values, int pos) {
        ListNode head = of(values);
        if (pos >= 0 && pos < values.length) {
            ListNode first = head;
            for (int i = 0; i < pos; i++) {
                first = first.next;
            }
            ListNode tail = first;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = first;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val);
            node = node.next;
            if (node != null) {
                sb.append("->");
            }
        }
        return sb.toString();
        //return String.valueOf(val);
    }
}
