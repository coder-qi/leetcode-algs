package weekly.w287;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.ArrayUtils.matrix;

/**
 * 2225. 找出输掉零场或一场比赛的玩家：https://leetcode.cn/problems/find-players-with-zero-or-one-losses/
 */
public class FindPlayersWithZeroOrOneLosses {

    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            if (!map.containsKey(winner)) {
                map.put(winner, 0);
            }
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>(2);
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 2) {
                ans.get(entry.getValue()).add(entry.getKey());
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }

    public static void main(String[] args) {
        // [[1,2,10],[4,5,7,8]]
        System.out.println(findWinners(matrix("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]")));
        // [[1,2,5,6],[]]
        System.out.println(findWinners(matrix("[[2,3],[1,3],[5,4],[6,4]]")));

    }

}
