import java.util.Deque;
import java.util.LinkedList;

import util.TreeNode;

/**
 * 449. 序列化和反序列化二叉搜索树：https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */
public class SerializeAndDeserializeBst {

    static public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder result = new StringBuilder("[");
            Deque<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode x = q.poll();
                result.append(x != null ? x.val : null).append(',');
                if (x != null) {
                    q.offer(x.left);
                    q.offer(x.right);
                }
            }
            result.setLength(result.length() - 1);
            return result.toString().replaceAll("(,null)+$", "") + ']';
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.substring(1, data.length() - 1);
            if (data.isEmpty()) {
                return null;
            }
            String[] values = data.split(",");
            Deque<TreeNode> q = new LinkedList<>();
            int pos = 1;
            TreeNode root = new TreeNode(Integer.valueOf(values[0]));
            q.offer(root);
            while (pos < values.length) {
                TreeNode x = q.poll();
                String leftValue = values[pos++];
                if (!"null".equals(leftValue)) {
                    x.left = new TreeNode(Integer.valueOf(leftValue));
                    q.offer(x.left);
                }
                if (pos < values.length) {
                    String rightValue = values[pos++];
                    if (!"null".equals(rightValue)) {
                        x.right = new TreeNode(Integer.valueOf(rightValue));
                        q.offer(x.left);
                    }
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String tree = codec.serialize(TreeNode.of(2, 1, 3));
        System.out.println(codec.deserialize(tree));

        codec = new Codec();
        tree = codec.serialize(TreeNode.of(3,1,4,null,2));
        System.out.println(codec.deserialize(tree));
    }

}
