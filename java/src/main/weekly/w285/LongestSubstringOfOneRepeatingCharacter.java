package weekly.w285;

/**
 * 2213. 由单个字符重复的最长子字符串：https://leetcode.cn/problems/longest-substring-of-one-repeating-character/
 */
public class LongestSubstringOfOneRepeatingCharacter {

    char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        chars = s.toCharArray();
        int n = chars.length;
        Node root = buildTree(0, n - 1);
        int[] ans = new int[queryCharacters.length()];
        for (int i = 0; i < queryCharacters.length(); i++) {
            update(root, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = root.max;
        }
        return ans;
    }

    private Node buildTree(int l, int r) {
        if (l == r) {
            return new Node(l, r);
        }
        Node node = new Node(l, r);
        int mid = (r - l) / 2 + l;
        node.leftNode = buildTree(l, mid);
        node.rightNode = buildTree(mid + 1, r);
        merge(node);
        return node;
    }

    private void merge(Node node) {
        if (node.leftNode != null) {
            node.max = Math.max(node.leftNode.max, node.rightNode.max);
            node.pre = node.leftNode.pre;
            node.suf = node.rightNode.suf;
            if (chars[node.leftNode.right] == chars[node.rightNode.left]) {
                node.max = Math.max(node.max, node.leftNode.suf + node.rightNode.pre);
                if (node.leftNode.pre == node.leftNode.right - node.leftNode.left + 1) {
                    node.pre = node.leftNode.pre + node.rightNode.pre;
                }
                if (node.rightNode.suf == node.rightNode.right - node.rightNode.left + 1) {
                    node.suf = node.leftNode.suf + node.rightNode.suf;
                }
            }
        }
    }

    private void update(Node node, int index, char val) {
        if (node.left > index || node.right < index) {
            return;
        }
        if (node.left == index && node.right == index) {
            chars[index] = val;
            return;
        }
        update(node.leftNode, index, val);
        update(node.rightNode, index, val);
        merge(node);
    }

    static class Node {
        int left, right;
        int pre = 1, suf = 1, max = 1;
        Node leftNode, rightNode;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

}
