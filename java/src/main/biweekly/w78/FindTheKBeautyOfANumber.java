package biweekly.w78;

/**
 * 5299. 找到一个数字的 K 美丽值：https://leetcode.cn/problems/find-the-k-beauty-of-a-number/
 */
public class FindTheKBeautyOfANumber {

    public static int divisorSubstrings(int num, int k) {
        int ans = 0;
        String str = String.valueOf(num);
        for (int i = 0; i <= str.length() - k; i++) {
            int v = Integer.parseInt(str.substring(i, i + k));
            if (v != 0 && num % v == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
