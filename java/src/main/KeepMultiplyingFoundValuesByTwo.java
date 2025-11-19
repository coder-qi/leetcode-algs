import java.util.HashSet;
import java.util.Set;

/**
 * 2154. 将找到的值乘以 2：https://leetcode.cn/problems/keep-multiplying-found-values-by-two
 */
public class KeepMultiplyingFoundValuesByTwo {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        while (s.contains(original)) {
            original *= 2;
        }
        return original;
    }

}
