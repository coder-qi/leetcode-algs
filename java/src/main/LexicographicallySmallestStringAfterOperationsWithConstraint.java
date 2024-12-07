/**
 * 3106. 满足距离约束且字典序最小的字符串：https://leetcode.cn/problems/lexicographically-smallest-string-after-operations-with-constraint
 */
public class LexicographicallySmallestStringAfterOperationsWithConstraint {

    public static String getSmallestString(String s, int k) {
        StringBuilder res = new StringBuilder(s.length());
        int i = 0;
        while (k > 0 && i < s.length()) {
            char ch = s.charAt(i);
            int distance = Math.min(ch - 'a', 'z' - ch + 1);
            if (distance <= k) {
                res.append('a');
                k -= distance;
            } else {
                res.append((char)(ch - k));
                k = 0;
            }
            i++;
        }
        res.append(s.substring(i));
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString("xaxcd", 4));
    }


}
