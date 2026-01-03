import java.util.ArrayList;
import java.util.List;

/**
 * 1411. 给 N x 3 网格图涂色的方案数：https://leetcode.cn/problems/number-of-ways-to-paint-n-3-grid
 */
public class NumberOfWaysToPaintN3Grid {

    public int numOfWays(int n) {
        int mod = 1000000007;
        int[] f = new int[((1 << 2) | (1 << 5) | (1 << 8)) + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }
                    f[(1 << i) | (1 << (j + 3)) | (1 << (k + 6))] = 1;
                }
            }
        }
        int[] t = new int[f.length];
        for (int x = 2; x <= n; x++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k < 3; k++) {
                        if (k == j) {
                            continue;
                        }
                        int color = (1 << i) | (1 << (j + 3)) | (1 << (k + 6));
                        t[color] = 0;
                        for (int l = 1; l < f.length; l++) {
                            if ((l & color) == 0) {
                                t[color] = (t[color] + f[l]) % mod;
                            }
                        }
                    }
                }
            }
            int[] tmp = t;
            t = f;
            f = tmp;
        }

        long ans = 0;
        for (int x : f) {
            ans += x;
        }
        return (int) (ans % mod);
    }


    public int numOfWays2(int n) {
        int mod = 1000000007;
        int[][] f = new int[2][3 * 2 * 2];
        int[] colors = new int[3 * 2 * 2];
        for (int i = 0, l = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }
                    colors[l] = (1 << i) | (1 << (j + 3)) | (1 << (k + 6));
                    f[0][l++] = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < colors.length; j++) {
                long res = 0;
                for (int k = 0; k < colors.length; k++) {
                    if ((colors[j] & colors[k]) == 0) {
                        res += f[(i - 1) % 2][k];
                    }
                }
                f[i % 2][j] = (int) (res % mod);
            }
        }

        long ans = 0;
        for (int x : f[(n - 1) % 2]) {
            ans += x;
        }
        return (int) (ans % mod);
    }

    public int numOfWays3(int n) {
        int mod = 1000000007;
        int[][] f = new int[2][3 * 2 * 2];
        int[] colors = new int[3 * 2 * 2];
        for (int i = 0, l = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }
                    colors[l] = (1 << i) | (1 << (j + 3)) | (1 << (k + 6));
                    f[0][l++] = 1;
                }
            }
        }
        List<Integer>[] nexts = new List[12];
        for (int i = 0; i < nexts.length; i++) {
            nexts[i] = new ArrayList<>(8);
        }
        for (int j = 0; j < colors.length; j++) {
            for (int k = 0; k < colors.length; k++) {
                if ((colors[j] & colors[k]) == 0) {
                    nexts[j].add(k);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 12; j++) {
                long res = 0;
                for (int k : nexts[j]) {
                    res += f[(i - 1) % 2][k];
                }
                f[i % 2][j] = (int) (res % mod);
            }
        }

        long ans = 0;
        for (int x : f[(n - 1) % 2]) {
            ans += x;
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        NumberOfWaysToPaintN3Grid app = new NumberOfWaysToPaintN3Grid();
        System.out.println(app.numOfWays3(1)); // 12
        System.out.println(app.numOfWays3(2)); // 54
        System.out.println(app.numOfWays3(3)); // 246
        System.out.println(app.numOfWays3(7)); // 106494
        System.out.println(app.numOfWays3(5000));
    }

}
