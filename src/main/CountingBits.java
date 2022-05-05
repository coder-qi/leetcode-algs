import java.util.Arrays;

/**
 * 338. 比特位计数：https://leetcode-cn.com/problems/counting-bits/
 */
public class CountingBits {

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i, count = 0;
            while (num != 0) {
                if ((num & 1) != 0) {
                    count++;
                }
                num >>= 1;
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2))); // [0,1,1]
        System.out.println(Arrays.toString(countBits(5))); // [0,1,1]
    }

}
