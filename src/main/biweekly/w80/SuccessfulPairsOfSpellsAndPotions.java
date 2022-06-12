package biweekly.w80;

import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 6096. 咒语和药水的成功对数：https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/
 */
public class SuccessfulPairsOfSpellsAndPotions {

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] pairs = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (potions[mid] * (long)spells[i] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (potions[left] * (long)spells[i] < success) {
                left++;
            }
            pairs[i] = m - left;
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(array("[5,1,3]"), array("[1,2,3,4,5]"), 7)));
        System.out.println(Arrays.toString(successfulPairs(array("[3,1,2]"), array("[8,5,8]"), 16)));
    }

}
