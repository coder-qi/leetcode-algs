import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2766. 重新放置石块：https://leetcode.cn/problems/relocate-marbles
 */
public class RelocateMarbles {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

}
