import java.util.Arrays;

/**
 * 338. 比特位计数：https://leetcode-cn.com/problems/counting-bits/
 */
public class CountingBits {

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = i % 2 == 0 ? result[i / 2] : result[i / 2] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2))); // [0,1,1]
        System.out.println(Arrays.toString(countBits(5))); // [0,1,1]
    }

}
