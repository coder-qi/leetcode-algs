/**
 * 717. 1 比特与 2 比特字符：https://leetcode.cn/problems/1-bit-and-2-bit-characters/
 */
public class OneBitAndTwoBitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (bits[n - 1] == 1) {
            return false;
        }
        for (int i = 0; i < n - 1; i++) {
            if (bits[i] == 1) {
                if (i + 1 >= n - 1) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

}
