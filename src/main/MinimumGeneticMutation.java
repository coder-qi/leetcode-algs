import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * 433. 最小基因变化：https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class MinimumGeneticMutation {

    public static int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        if (!set.contains(end)) {
            return -1;
        }
        set.remove(start);
        int ans = 1;
        Deque<String> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                String x = q.poll();
                for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
                    String next = iter.next();
                    if (check(x, next)) {
                        if (next.equals(end)) {
                            return ans;
                        }
                        q.offer(next);
                        iter.remove();
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private static boolean check(String s1, String s2) {
        int c = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                c++;
            }
        }
        return c == 1;
    }

    public static void main(String[] args) {
        // 1
        System.out.println(minMutation("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"}));
        // 2
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA","AACCGCTA","AAACGGTA"}));
        // 3
        System.out.println(minMutation("AAAAACCC", "AACCCCCC", new String[] {"AAAACCCC","AAACCCCC","AACCCCCC"}));
    }

}
