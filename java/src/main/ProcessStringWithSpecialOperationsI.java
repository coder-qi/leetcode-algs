/**
 * 3612. 用特殊操作处理字符串 I：https://leetcode.cn/problems/process-string-with-special-operations-i
 */
public class ProcessStringWithSpecialOperationsI {

    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                ans.append(c);
            } else if (c == '*') {
                if (!ans.isEmpty()) {
                    ans.deleteCharAt(ans.length() - 1);
                }
            } else if (c == '#') {
                ans.append(ans);
            } else {
                ans.reverse();
            }
        }
        return ans.toString();
    }

}
