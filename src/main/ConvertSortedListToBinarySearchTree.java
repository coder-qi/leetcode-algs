/**
 * 有序链表转换二叉搜索树：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {

    public static TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private static TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    private static ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left, slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(sortedListToBST(ListNode.of(-10, -3, 0, 5, 9)));
    }

}
