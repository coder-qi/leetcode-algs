import java.util.ArrayList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
public class AllElementsInTwoBinarySearchTrees {

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        inorder(root1, nums1);
        inorder(root2, nums2);
        List<Integer> merged = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 == nums1.size()) {
                merged.addAll(nums2.subList(p2, nums2.size()));
                break;
            }
            if (p2 == nums2.size()) {
                merged.addAll(nums1.subList(p1, nums1.size()));
                break;
            }
            if (nums1.get(p1) < nums2.get(p2)) {
                merged.add(nums1.get(p1++));
            } else {
                merged.add(nums2.get(p2++));
            }
        }
        return merged;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void main(String[] args) {
        System.out.println(getAllElements(TreeNode.of(2,1,4), TreeNode.of(1,0,3)));
        System.out.println(getAllElements(TreeNode.of(1,null,8), TreeNode.of(8,1)));
        System.out.println(getAllElements(TreeNode.of(99,90,null,8,null,7,85,null,null,null,87),
            TreeNode.of(50,2,73,null,34,58,80,21,null,null,64,74,92,10,null,null,68,null,null,89,100,null,null,66,null,84)));
    }

}
