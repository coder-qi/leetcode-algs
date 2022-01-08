/**
 * 外观数列：https://leetcode-cn.com/problems/count-and-say/
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String prev = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, count = 0; j < prev.length(); j++) {
                char c = prev.charAt(j);
                if (j == prev.length() - 1 || c != prev.charAt(j + 1)) {
                    sb.append(count + 1).append(c);
                    count = 0;
                } else {
                    count++;
                }
            }
            prev = sb.toString();
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(4));
    }

}
