package weekly.w287;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static util.ArrayUtils.matrix;

/**
 * 2225. 找出输掉零场或一场比赛的玩家：https://leetcode.cn/problems/find-players-with-zero-or-one-losses/
 */
public class FindPlayersWithZeroOrOneLosses {

    public static List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        Map<Integer, Integer> losers = new HashMap<>();
        for (int[] match : matches) {
            winners.add(match[0]);
            losers.put(match[1], losers.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>(2);
        List<Integer> ans0 = new ArrayList<>();
        ans.add(ans0);
        for (int i : winners) {
            if (!losers.containsKey(i)) {
                ans0.add(i);
            }
        }
        Collections.sort(ans0);

        List<Integer> ans1 = new ArrayList<>();
        ans.add(ans1);
        for (Map.Entry<Integer, Integer> entry : losers.entrySet()) {
            if (entry.getValue() == 1) {
                ans1.add(entry.getKey());
            }
        }
        Collections.sort(ans1);
        return ans;
    }

    public static void main(String[] args) {
        // [[1,2,10],[4,5,7,8]]
        System.out.println(findWinners(matrix("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]")));
        // [[1,2,5,6],[]]
        System.out.println(findWinners(matrix("[[2,3],[1,3],[5,4],[6,4]]")));

    }

}
