/**
 * 2182. 构造限制重复的字符串：https://leetcode.cn/problems/construct-string-with-repeat-limit
 */
public class ConstructStringWithRepeatLimit {

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        int pre = -1;
        while (true) {
            int target = -1;
            int first = -1;
            for (int i = count.length - 1; i >= 0; i--) {
                if (count[i] > 0) {
                    if (first == -1) {
                        first = i;
                    }
                    if (i != pre) {
                        target = i;
                        break;
                    }
                }
            }
            if (target == -1) {
                break;
            }
            pre = target;
            int curLimit = first > target ? 1 : Math.min(count[target], repeatLimit);
            for (int i = 0; i < curLimit; i++) {
                char ch = (char) (target + 'a');
                ans.append(ch);
                count[target]--;
            }
        }
        return ans.toString();
    }
}
