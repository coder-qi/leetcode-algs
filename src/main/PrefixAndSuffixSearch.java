/**
 * 745. 前缀和后缀搜索：https://leetcode.cn/problems/prefix-and-suffix-search/
 */
public class PrefixAndSuffixSearch {

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[] { "apple" });
        System.out.println(wordFilter.f("a", "e"));;

        wordFilter = new WordFilter(new String[] { "f", "f", "f" });
        System.out.println(wordFilter.f("f", "f"));;
    }

}

class WordFilter {

    Trie root = new Trie();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                Trie x = root;
                for (int k = j; k < word.length(); k++) {
                    int idx = words[i].charAt(k) - 'a';
                    if (x.child[idx] == null) {
                        x.child[idx] = new Trie();
                    }
                    x = x.child[idx];
                }
                if (x.child[x.child.length - 1] == null) {
                    x.child[x.child.length - 1] = new Trie();
                }
                x = x.child[x.child.length - 1];

                for (int m = 0; m < word.length(); m++) {
                    int idx = word.charAt(m) - 'a';
                    if (x.child[idx] == null) {
                        x.child[idx] = new Trie();
                    }
                    x.index = i;
                    x = x.child[idx];
                }
                x.index = i;
            }
        }
    }

    public int f(String pref, String suff) {
        String searchWord = suff + "{" + pref;
        return dfs(searchWord, root, 0);
    }

    private int dfs(String searchWord, Trie root, int pos) {
        if (root == null) {
            return -1;
        }
        if (pos == searchWord.length()) {
            return root.index;
        }
        return dfs(searchWord, root.child[searchWord.charAt(pos) - 'a'], pos + 1);
    }

    static class Trie {
        Trie[] child;
        int index = -1;

        Trie() {
            child = new Trie[27];
        }
    }
}
