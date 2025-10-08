import java.util.Arrays;

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
