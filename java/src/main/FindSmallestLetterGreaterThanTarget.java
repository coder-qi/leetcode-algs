/**
 * 744. 寻找比目标字母大的最小字母：https://leetcode.cn/problems/find-smallest-letter-greater-than-target
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int l = 0, r = letters.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l == letters.length ? letters[0] : letters[l];
    }

}
