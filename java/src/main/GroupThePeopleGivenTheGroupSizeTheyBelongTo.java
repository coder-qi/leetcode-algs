import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[] {3,3,3,3,3,1,3})); // [[5],[0,1,2],[3,4,6]]
        System.out.println(groupThePeople(new int[] {2,1,3,3,3,2})); // [[1],[0,5],[2,3,4]]
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> countGroups = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            countGroups.computeIfAbsent(groupSizes[i], ArrayList::new).add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : countGroups.entrySet()) {
            int count = entry.getKey();
            List<Integer> list = entry.getValue();
            for (int i = 0; i < list.size() / count; i++) {
                ans.add(list.subList(i * count, (i + 1) * count));
            }
        }
        return ans;
    }

}
