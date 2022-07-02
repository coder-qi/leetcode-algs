package biweekly.w81;

/**
 * 2315. 统计星号：https://leetcode.cn/problems/count-asterisks/
 */
public class CountAsterisks {

    public static int countAsterisks(String s) {
        boolean mark = false;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '|') {
                mark = !mark;
            } else if (ch == '*' && !mark) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAsterisks("l|*e*et|c**o|*de|")); // 2
        System.out.println(countAsterisks("iamprogrammer")); // 0
        System.out.println(countAsterisks("yo|uar|e**|b|e***au|tifu|l")); // 5
    }

}
