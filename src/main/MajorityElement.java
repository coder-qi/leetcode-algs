import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素：https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer cnt = map.get(nums[i]);
            if (cnt == null) {
                cnt = 0;
            }
            cnt += 1;
            if (cnt > (n >> 1)) {
                return nums[i];
            }
            map.put(nums[i], cnt);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[] {6,5,5}));
    }

}
