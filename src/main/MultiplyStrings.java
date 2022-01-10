/**
 * 字符串相乘：https://leetcode-cn.com/problems/multiply-strings/
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] nums = new int[n1 + n2];
        for (int i = 0; i < n2; i++) {
            int x = num2.charAt(n2 - 1 - i) - '0';
            for (int j = 0; j < n1; j++) {
                int y = num1.charAt(n1 - 1 - j) - '0';
                int z = x * y + nums[j + i];
                nums[j + i] = z % 10;
                nums[j + i + 1] += z / 10;
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = nums.length - 1;
        while (i >= 1 && nums[i] == 0) {
            i--;
        }
        for (; i >= 0; i--) {
           ans.append(nums[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("2", "3")); // 6
        System.out.println(multiply("123", "456")); // 56088
    }

}
