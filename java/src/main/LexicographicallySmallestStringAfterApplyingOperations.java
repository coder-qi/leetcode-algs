import java.util.*;

/**
 * 1625. 执行操作后字典序最小的字符串：/leetcode.cn/problems/lexicographically-smallest-string-after-applying-operations
 */
public class LexicographicallySmallestStringAfterApplyingOperations {

    public String findLexSmallestString(String s, int a, int b) {
       HashSet<String> all = new HashSet<>(64);
       all.add(s);
       Deque<String> q = new ArrayDeque<>();
       q.add(s);
       String ans = s;
       while (!q.isEmpty()) {
           int size = q.size();
           for (int i = 0; i < size; i++) {
               String curr = q.poll();
               if (curr.compareTo(ans) < 0) {
                   ans = curr;
               }
               String s1 = add(curr, a);
               if (all.add(s1)) {
                   q.add(s1);
               }
               String s2 = rotate(curr, b);
               if (all.add(s2)) {
                   q.add(s2);
               }
           }
       }
       return ans;
    }

    private String rotate(String s, int b) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < b; i++) {
            sb.append(s.charAt(n - b + i));
        }
        for (int i = 0; i < n - b; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private String add(String s, int a) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if ((i & 1) == 0) {
                sb.append(s.charAt(i));
            } else {
                int f = s.charAt(i) - '0' + a;
                sb.append(f >= 10 ? f - 10 : f);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LexicographicallySmallestStringAfterApplyingOperations app = new LexicographicallySmallestStringAfterApplyingOperations();
        System.out.println(app.findLexSmallestString("5525", 9, 2)); // 2050
        System.out.println(app.findLexSmallestString("74", 5, 1)); // 24
        System.out.println(app.findLexSmallestString("0011", 4, 2)); // 0011
        System.out.println(app.findLexSmallestString("43987654", 7, 3)); // 00553311
        System.out.println(app.findLexSmallestString("593290172167", 7, 4)); // 206658319916
        System.out.println(app.findLexSmallestString("0828265976149473834240719308951729926225100715191213267697293340972124", 1, 19)); // 0000831589676556524225375807799017444079289979194950858790115227903068
    }

}
