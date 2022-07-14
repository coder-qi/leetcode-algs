import java.util.Set;

/**
 * 745. 前缀和后缀搜索：https://leetcode.cn/problems/prefix-and-suffix-search/
 */
public class PrefixAndSuffixSearch {



    public static void main(String[] args) {

    }

}

class WordFilter {

    Trie root = new Trie();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie prefixTrie = new Trie();
            Trie x = prefixTrie;
            for (int j = 0; j < word.length(); j++) {
                int idx = words[i].charAt(i) - 'a';
                if (x.child[idx] == null) {
                    x.child[idx] = new Trie();
                    x.index = i;
                }
                x = x.child[idx];
            }
            for (int j = word.length() - 1; j >= 0; j--) {
                x = root;
                for (int k = j; k >= 0; k--) {
                    int idx = words[i].charAt(i) - 'a';
                    if (x.child[idx] == null) {
                        x.child[idx] = new Trie();
                    }
                    x = x.child[idx];


                }
            }
        }
    }

    public int f(String pref, String suff) {

    }

    static class Trie {
        Trie[] child;
        int index = -1;

        Trie() {
            child = new Trie[27];
        }
    }
}
