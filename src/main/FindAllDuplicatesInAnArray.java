import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static util.ArrayUtils.array;

/**
 * 442. 数组中重复的数据：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesInAnArray {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                result.add(num);
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(findDuplicates(array("[4,3,2,7,8,2,3,1]"))); // [2,3]
        System.out.println(findDuplicates(array("[1,1,2]"))); // [1]
        System.out.println(findDuplicates(array("[1]"))); // []
        System.out.println(findDuplicates(array(Files.readString(Paths.get(
            FindAllDuplicatesInAnArray.class.getResource("testcase/442-testcase-1.txt").toURI()))))); // []
    }

}
