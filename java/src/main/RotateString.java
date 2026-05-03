/**
 * 796. 旋转字符串：https://leetcode.cn/problems/rotate-string
 */
public class RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        s += s;
        return s.contains(goal);
    }

}
