package weekly.w295;

import java.util.HashMap;
import java.util.Map;

/**
 * 6078. 重排字符形成目标字符串：https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 */
public class RearrangeCharactersToMakeTargetString {

    public static int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> targetCnt = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            targetCnt.put(ch, targetCnt.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> sCnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (targetCnt.containsKey(ch)) {
                sCnt.put(ch, sCnt.getOrDefault(ch, 0) + 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetCnt.entrySet()) {
            int sc = sCnt.getOrDefault(entry.getKey(), 0);
            int tc = entry.getValue();
            if (sc == 0 || sc / tc == 0) {
                ans = 0;
                break;
            }
            ans = Math.min(ans, sc / tc);
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
