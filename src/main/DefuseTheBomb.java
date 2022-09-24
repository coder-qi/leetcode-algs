import java.util.Arrays;

/**
 * 1652. 拆炸弹：https://leetcode.cn/problems/defuse-the-bomb/
 */
public class DefuseTheBomb {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decrypt(new int[] {5,7,1,4}, 3))); // [12, 10, 16, 13]
        System.out.println(Arrays.toString(decrypt(new int[] {1,2,3,4}, 0))); // [0, 0, 0, 0]
        System.out.println(Arrays.toString(decrypt(new int[] {2,4,9,3}, -2))); // [12,5,6,13]
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
           return ans;
        }
        int step = k > 0 ? 1 : -1;
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < Math.abs(k); j++) {
                s += code[(i + step * (j + 1) + n) % n];
            }
            ans[i] = s;
        }
        return ans;
    }

}
