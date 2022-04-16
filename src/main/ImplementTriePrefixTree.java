/**
 * 实现 Trie (前缀树)：https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));;   // 返回 True
        System.out.println(trie.search("app"));;     // 返回 False
        System.out.println(trie.startsWith("app"));; // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True


        trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.startsWith("jan"));
    }

}

class Trie {

    private Node root;

    public Trie() {
    }

    public void insert(String word) {
       root = insert(root, word, 0);
    }

    private Node insert(Node x, String word, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == word.length()) {
            x.b = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c - 'a'] = insert(x.next[c - 'a'], word, d + 1);
        return x;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node x, String word, int d) {
        if (x == null) {
            return false;
        }
        if (d == word.length()) {
            return x.b;
        }
        char c = word.charAt(d);
        return search(x.next[c - 'a'], word, d + 1);
    }

    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(Node x, String prefix, int d) {
        if (x == null) {
            return false;
        }
        if (d == prefix.length()) {
            return true;
        }
        char c = prefix.charAt(d);
        return startsWith(x.next[c - 'a'], prefix, d + 1);
    }

    static class Node {
        boolean b;
        Node[] next = new Node[26];
    }

}

