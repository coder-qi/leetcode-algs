import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮：https://leetcode.cn/problems/fruit-into-baskets/
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[] {1, 2, 1})); // 3
    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = fruits.length, ans = 0;
        for (int right = 0, left = 0; right < n; right++) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (left < n && cnt.size() > 2) {
                int x = cnt.get(fruits[left]);
                if (x == 1) {
                    cnt.remove(fruits[left]);
                } else {
                    cnt.put(fruits[left], x - 1);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
