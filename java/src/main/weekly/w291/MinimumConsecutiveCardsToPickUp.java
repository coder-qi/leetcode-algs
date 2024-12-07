package weekly.w291;

import java.util.HashMap;
import java.util.Map;

/**
 * 6048. 必须拿起的最小连续卡牌数：https://leetcode-cn.com/problems/minimum-consecutive-cards-to-pick-up/
 */
public class MinimumConsecutiveCardsToPickUp {

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                ans = Math.min(ans, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

    }

}
