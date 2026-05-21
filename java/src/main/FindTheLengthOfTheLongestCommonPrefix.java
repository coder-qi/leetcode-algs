/**
 * 3043. 最长公共前缀的长度：https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix
 */
public class FindTheLengthOfTheLongestCommonPrefix {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node root = buildTree(arr1);
        int ans = 0;
        for (int x : arr2) {
            ans = Math.max(ans, longestCommonPrefix(root, String.valueOf(x).toCharArray()));
        }
        return ans;
    }

    private int longestCommonPrefix(Node node, char[] str) {
        for (int i = 0; i < str.length; i++) {
            int j = str[i] - '0';
            if (node.next[j] == null) {
                return i;
            }
            node = node.next[j];
        }
        return str.length;
    }

    private Node buildTree(int[] arr) {
        Node root = new Node();
        for (int x : arr) {
            addNode(root, String.valueOf(x).toCharArray(), 0);
        }
        return root;
    }

    private void addNode(Node node, char[] str, int i) {
        if (i == str.length) {
            return;
        }
        int j = str[i] - '0';
        if (node.next[j] == null) {
            node.next[j] = new Node();
        }
        addNode(node.next[j], str, i + 1);
    }

    static class Node {
        Node[] next = new Node[10];
    }

}
