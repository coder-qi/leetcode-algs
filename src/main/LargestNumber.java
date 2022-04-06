import java.util.Arrays;

/**
 * 最大数：https://leetcode-cn.com/problems/largest-number/
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        /*Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });*/
        String result = String.join("", strs).replaceAll("^0+", "");
        if (result.isEmpty()) {
            return "0";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[] {10,2})); // 210
        System.out.println(new LargestNumber().largestNumber(new int[] {3,30,34,5,9})); // 9534330
        System.out.println(new LargestNumber().largestNumber(new int[] {34323,3432})); // 343234323
        System.out.println(new LargestNumber().largestNumber(new int[] {0,0})); // 0
    }

}
