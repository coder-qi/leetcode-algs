import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀：https://leetcode.cn/problems/binary-prefix-divisible-by-5
 */
public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>(nums.length);
        int x = 0;
        for (int num : nums) {
            x = ((x << 1) + num) % 5;
            res.add(x == 0);
        }
        return res;
    }

}
