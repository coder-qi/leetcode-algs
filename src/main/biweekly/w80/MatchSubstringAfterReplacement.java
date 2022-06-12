package biweekly.w80;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 6097. 替换字符后匹配：https://leetcode.cn/problems/match-substring-after-replacement/
 */
public class MatchSubstringAfterReplacement {

    public static boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < mappings.length; i++) {
            map.computeIfAbsent(mappings[i][0], HashSet::new).add(mappings[i][1]);
        }
        for (int i = 0; i <= s.length() - sub.length(); i++) {
            boolean matched = true;
            for (int j = 0; j < sub.length(); j++) {
                if (sub.charAt(j) != s.charAt(i + j)
                    && !map.getOrDefault(sub.charAt(j), Collections.EMPTY_SET).contains(s.charAt(i + j))) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
