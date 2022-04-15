import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 同构字符串：https://leetcode-cn.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                map.put(sc, tc);
                if (!set.add(tc)) {
                    return false;
                }
            } else if (map.get(sc) != tc) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("aa", "ab"));
    }

}
