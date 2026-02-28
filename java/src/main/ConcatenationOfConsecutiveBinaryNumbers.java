import java.util.ArrayList;
import java.util.List;

/**
 * 1680. 连接连续二进制数字：https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers
 */
public class ConcatenationOfConsecutiveBinaryNumbers {

    static List<Integer> resList = new ArrayList<>();

    static {
        resList.add(1);
    }

    public int concatenatedBinary(int n) {
        int mod = (int)1e9 + 7;
        while (resList.size() < n) {
            int a = resList.size() + 1;
            int b = 32 - Integer.numberOfLeadingZeros(a);
            long x = (((long) resList.getLast() << b) | a) % mod;
            resList.add((int) x);
        }
        return resList.get(n - 1);
    }

}
