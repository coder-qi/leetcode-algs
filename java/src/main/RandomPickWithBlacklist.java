import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 710. 黑名单中的随机数：https://leetcode.cn/problems/random-pick-with-blacklist/
 */
public class RandomPickWithBlacklist {

    static class Solution {

        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        int bound;

        public Solution(int n, int[] blacklist) {
            bound = n - blacklist.length;
            Set<Integer> blacks = new HashSet<>();
            for (int b : blacklist) {
                if (b >= bound) {
                    blacks.add(b);
                }
            }
            int w = bound;
            for (int b : blacklist) {
                if (b < bound) {
                    while (blacks.contains(w)) {
                        w++;
                    }
                    map.put(b, w);
                    w++;
                }
            }
        }

        public int pick() {
            int x = random.nextInt(bound);
           return map.getOrDefault(x, x);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution(7, new int[] {2, 3, 5});
        solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
        // 0、1、4和6的返回概率必须相等(即概率为1/4)。
        System.out.println(solution.pick()); // 返回 4
        System.out.println(solution.pick()); // 返回 1
        System.out.println(solution.pick()); // 返回 6
        System.out.println(solution.pick()); // 返回 1
        System.out.println(solution.pick()); // 返回 0
        System.out.println(solution.pick()); // 返回 4
    }

}
