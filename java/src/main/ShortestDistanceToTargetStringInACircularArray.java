/**
 * 2515. 到目标字符串的最短距离：https://leetcode.cn/problems/shortest-distance-to-target-string-in-a-circular-array
 */
public class ShortestDistanceToTargetStringInACircularArray {

    public int closestTarget(String[] words, String target, int startIndex) {
        for (int i = 0; i < words.length; i++) {
            if (words[(startIndex + i) % words.length].equals(target) ||
                    words[(startIndex - i + words.length) % words.length].equals(target)) {
                return i;
            }
        }
        return -1;
    }

}
