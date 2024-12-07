package weekly.w287;

/**
 * 2224. 转化时间需要的最少操作数：https://leetcode.cn/problems/minimum-number-of-operations-to-convert-time/
 */
public class MinimumNumberOfOperationsToConvertTime {

    static final int[] MS = {60, 15, 5, 1};
    
    public static int convertTime(String current, String correct) {
        int diff = parseMinutes(correct) - parseMinutes(current);
        int ans = 0;
        for (int m : MS) {
            ans += diff / m;
            diff %= m;
        }
        return ans;
    }

    private static int parseMinutes(String s) {
        int minutes = Integer.parseInt(s.substring(0, 2)) * 60;
        minutes += Integer.parseInt(s.substring(3));
        return minutes;
    }

    public static void main(String[] args) {
        System.out.println(convertTime("02:30", "04:35")); // 3
        System.out.println(convertTime("11:00", "11:01")); // 1
    }

}
