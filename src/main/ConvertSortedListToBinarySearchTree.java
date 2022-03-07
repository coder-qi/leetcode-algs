/**
 * 有序链表转换二叉搜索树：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {

    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int len = getLength(head);
        return buildTree(0, len - 1);
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(ListNode.of(-10, -3, 0, 5, 9)));
    }

}
