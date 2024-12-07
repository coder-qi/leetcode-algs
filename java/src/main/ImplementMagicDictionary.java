import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 676. 实现一个魔法字典：https://leetcode.cn/problems/implement-magic-dictionary/
 */
public class ImplementMagicDictionary {

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[] {"hello", "leetcode"});
        magicDictionary.search("hello"); // 返回 False
        magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        magicDictionary.search("hell"); // 返回 False
        magicDictionary.search("leetcoded"); // 返回 False
    }

}

class MagicDictionary {

    Trie root;

    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie x = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (x.child[idx] == null) {
                    x.child[idx] = new Trie();
                }
                x = x.child[idx];
            }
            x.finished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
        if (pos == searchWord.length()) {
            return modified && node.finished;
        }
        int idx = searchWord.charAt(pos) - 'a';
        if (node.child[idx] != null) {
            if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < node.child.length; i++) {
                if (i != idx && node.child[i] != null) {
                    if (dfs(searchWord, node.child[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Trie {
        boolean finished;
        Trie[] child;

        Trie() {
            child = new Trie[26];
        }
    }
}
