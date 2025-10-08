import java.util.Arrays;
import java.util.Comparator;

/**
 * 2300. 咒语和药水的成功对数：https://leetcode.cn/problems/successful-pairs-of-spells-and-potions
 */
public class SuccessfulPairsOfSpellsAndPotions {

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] res = new int[n];

        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            res[i] = search(spells[i], potions, success);
        }
        return res;
    }

    public static int[] successfulPairs2(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = spells[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(potions);

        int[] res = new int[n];

        for (int i = 0, j = 0; i < n; i++) {
            while (j < m && (long) arr[i][0] * potions[j] < success) {
                j++;
            }
            res[arr[i][1]] = m - j;
        }
        return res;
    }

    private static int search(long spell, int[] potions, long success) {
        int m = potions.length;
        int lower = 0;
        int high = m - 1;
        while (lower <= high) {
            int mid = (lower + high) >>> 1;
            if (spell * potions[mid] < success) {
                lower = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return m - lower;
    }

}
