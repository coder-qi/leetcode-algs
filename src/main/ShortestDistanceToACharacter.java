import java.util.Arrays;

/**
 * 821. 字符的最短距离：https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 */
public class ShortestDistanceToACharacter {

    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                int left = i - 1;
                while (left >= 0 && s.charAt(left) != c) {
                    int len = i - left;
                    if (result[left] != 0 && len >= result[left]) {
                        break;
                    }
                    result[left] = len;
                    left--;
                }
                int right = i + 1;
                while (right < n && s.charAt(right) != c) {
                    int len = right - i;
                    if (result[right] != 0 && len >= result[right]) {
                        break;
                    }
                    result[right] = len;
                    right++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e'))); // [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
        System.out.println(Arrays.toString(shortestToChar("aaab", 'b'))); // [3, 2, 1, 0]
    }

}
