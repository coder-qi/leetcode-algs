import java.util.Arrays;

/**
 * 899. 有序队列：https://leetcode.cn/problems/orderly-queue/
 */
public class OrderlyQueue {

    public static void main(String[] args) {
        System.out.println(orderlyQueue("cba", 1)); // acb
        System.out.println(orderlyQueue("baaca", 3)); // aaabc
        System.out.println(orderlyQueue("kuh", 1)); // hku
    }

    public static String orderlyQueue(String s, int k) {
        if (k == 1) {
            int n = s.length();
            StringBuilder sb = new StringBuilder(s);
            String ans = s;
            for (int i = 1; i < n; i++) {
                char ch = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);
                String temp = sb.toString();
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

}
