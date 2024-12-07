/**
 * 904. 水果成篮：https://leetcode.cn/problems/fruit-into-baskets/
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[] {1, 2, 1})); // 3
    }

    public static int totalFruit(int[] fruits) {
        int n = fruits.length, ans = 0;
        int[] cnt = new int[n + 1];
        int kind = 0;
        for (int right = 0, left = 0; right < n; right++) {
            if (cnt[fruits[right]] == 0) {
                kind++;
            }
            cnt[fruits[right]]++;
            while (left < n && kind > 2) {
                cnt[fruits[left]]--;
                if (cnt[fruits[left]] == 0) {
                    kind--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
