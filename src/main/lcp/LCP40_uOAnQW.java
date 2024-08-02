package lcp;

import java.util.Arrays;

/**
 * LCP 40. 心算挑战：https://leetcode.cn/problems/uOAnQW
 */
public class LCP40_uOAnQW {

    public static int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int ans = 0;
        int i = cards.length - 1;
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int j = 0; j < cnt; j++, i--) {
            ans += cards[i];
            if ((cards[i] & 1) == 0) {
                minEven = cards[i];
            } else {
                minOdd = cards[i];
            }
        }
        if ((ans & 1) == 0) {
            return ans;
        }
        int maxOdd = -1;
        int maxEven = -1;
        for (int j = 0; j <= i; j++) {
            if ((cards[j] & 1) == 0) {
                maxEven = cards[j];
            } else {
                maxOdd = cards[j];
            }
        }
        // 去掉前面的奇数，取后面偶数
        int diff = Integer.MAX_VALUE;
        if (minOdd != Integer.MAX_VALUE && maxEven != -1) {
            diff = Math.min(diff, minOdd - maxEven);
        }
        // 去掉前面的偶数，取后面的奇数
        if (minEven != Integer.MAX_VALUE && maxOdd != -1) {
            diff = Math.min(diff, minEven - maxOdd);
        }
        return diff == Integer.MAX_VALUE ? 0 : ans - diff;
    }

    public static void main(String[] args) {
        System.out.println(maxmiumScore(new int[] {9, 7, 1, 4, 9}, 1)); // 4
    }

}
