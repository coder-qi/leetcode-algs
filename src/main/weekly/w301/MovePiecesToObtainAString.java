package weekly.w301;

/**
 * 6114. 移动片段得到字符串：https://leetcode.cn/problems/move-pieces-to-obtain-a-string/
 */
public class MovePiecesToObtainAString {

    public static boolean canChange(String start, String target) {
        if (!start.replace("_", "").equals(
                target.replace("_", ""))) {
            return false;
        }
        for (int i = 0, j = 0; i < start.length() && j < start.length(); i++) {
            char ch = target.charAt(i);
            if (ch == '_') {
                continue;
            }
            int p = start.indexOf(ch, j);
            if (p == -1 || (ch == 'L' && p < i) || (ch == 'R' && p > i)) {
                return false;
            }
            j = p + 1;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(canChange("_L__R__R_", "L______RR")); // true
        System.out.println(canChange("R_L__R__R_", "_L______RR")); // false
    }

}
