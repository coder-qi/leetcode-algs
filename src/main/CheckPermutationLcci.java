import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. 判定是否互为字符重排：https://leetcode.cn/problems/check-permutation-lcci/
 */
public class CheckPermutationLcci {

    public static void main(String[] args) {

    }

    public static boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> count1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            count1.put(s1.charAt(i), count1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        Map<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            count2.put(s2.charAt(i), count2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : count1.entrySet()) {
            if (entry.getValue() != count2.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
            count2.remove(entry.getKey());
        }
        return count2.isEmpty();
    }

}
