import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 854. 相似度为 K 的字符串：https://leetcode.cn/problems/k-similar-strings/
 */
public class KSimilarStrings {

    public static void main(String[] args) {
        System.out.println(new KSimilarStrings().kSimilarity("ab", "ba")); // 1
        System.out.println(new KSimilarStrings().kSimilarity("abc", "bca")); // 2
        System.out.println(new KSimilarStrings().kSimilarity("ffabc", "abffc")); // 2
        System.out.println(new KSimilarStrings().kSimilarity("abac", "baca")); // 2
    }

    public int kSimilarity(String s1, String s2) {
        Deque<Object[]> q = new ArrayDeque<>();
        Set<String> visit = new HashSet<>();
        q.offer(new Object[] {s1, 0});
        visit.add(s1);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Object[] pair = q.poll();
                String cur = (String) pair[0];
                int pos = (int) pair[1];
                if (cur.equals(s2)) {
                    return step;
                }
                while (pos < s2.length() && cur.charAt(pos) == s2.charAt(pos)) { // 跳过相同的字符
                    pos++;
                }

                // 找到需要进行交换的字符
                for (int j = pos + 1; j < s2.length(); j++) {
                    if (cur.charAt(j) == s2.charAt(j)) {
                        continue;
                    }
                    if (cur.charAt(j) == s2.charAt(pos)) {
                        String next = swap(cur, pos, j);
                        if (visit.add(next)) {
                            q.offer(new Object[] {next, pos + 1});
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

}
