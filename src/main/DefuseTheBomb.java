import java.util.Arrays;

/**
 * 1652. 拆炸弹：https://leetcode.cn/problems/defuse-the-bomb/
 */
public class DefuseTheBomb {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decrypt(new int[] {5,7,1,4}, 3))); // [12, 10, 16, 13]
        System.out.println(Arrays.toString(decrypt(new int[] {1,2,3,4}, 0))); // [0, 0, 0, 0]
        System.out.println(Arrays.toString(decrypt(new int[] {2,4,9,3}, -2))); // [12,5,6,13]
        System.out.println(Arrays.toString(decrypt(new int[] {10,5,7,7,3,2,10,3,6,9,1,6}, -4))); // [22,26,22,28,29,22,19,22,18,21,28,19]
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
           return ans;
        }
        int sign = k > 0 ? 1 : -1, s = 0;
        for (int i = 0, j = k > 0 ? 1 : n + k; i < sign * k - 1; i++) {
            s += code[(j + i) % n];
        }
        for (int i = 0, j = k > 0 ? k : n - 1; i < n; i++, j = (j + 1) % n) {
            s += code[j % n];
            ans[i] = s;
            s -= code[(j - (k * sign - 1) + n) % n];
        }
        return ans;
    }

}
