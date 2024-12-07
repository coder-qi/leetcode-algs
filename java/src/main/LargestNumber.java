import java.util.Arrays;

/**
 * 最大数：https://leetcode-cn.com/problems/largest-number/
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, this::compareStr);
        if("0".equals(strs[0])) {
            return "0";
        }
        return String.join("", strs);
    }

    private int compareStr(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() || j < s2.length()) {
            i = i % s1.length();
            j = j % s2.length();
            char c1 = s1.charAt(i), c2 = s2.charAt(j);
            if (c1 != c2) {
                return c1 > c2 ? -1 : 1;
            }
            i++;
            j++;
        }
        return s1.length() > s2.length() ? -1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[] {10,2})); // 210
        System.out.println(new LargestNumber().largestNumber(new int[] {3,30,34,5,9})); // 9534330
        System.out.println(new LargestNumber().largestNumber(new int[] {34323,3432})); // 343234323
        System.out.println(new LargestNumber().largestNumber(new int[] {0,0})); // 0
    }

}
