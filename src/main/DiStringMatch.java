import java.util.Arrays;

/**
 * 942. 增减字符串匹配：https://leetcode.cn/problems/di-string-match/
 */
public class DiStringMatch {

    public static int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        int min = 0, max = n;
        for (int i = 0; i < n; i++) {
            result[i] = s.charAt(i) == 'I' ? min++ : max--;
        }
        result[n] = min;
        return result;
    }

    public static void main(String[] args) {
        // [0,4,1,3,2]
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        // [0,1,2,3]
        System.out.println(Arrays.toString(diStringMatch("III")));
        // [3,2,0,1]
        System.out.println(Arrays.toString(diStringMatch("DDI")));
    }

}
