import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 672. 灯泡开关 Ⅱ：https://leetcode.cn/problems/bulb-switcher-ii/
 */
public class BulbSwitcherII {

    public static void main(String[] args) {
        System.out.println(new BulbSwitcherII().flipLights(2, 1));
    }

    public int flipLights(int n, int presses) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 1 << 4; i++) {
            int[] pressArr = new int[4];
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (i >> j) & 1;
            }
            int sum = Arrays.stream(pressArr).sum();
            if (sum % 2 == presses % 2 && sum <= presses) {
                int status = pressArr[0] ^ pressArr[2] ^ pressArr[3];
                if (n >= 2) {
                    status |= (pressArr[0] ^ pressArr[1]) << 1;
                }
                if (n >= 3) {
                    status |= (pressArr[0] ^ pressArr[2]) << 2;
                }
                if (n >= 4) {
                    status |= (pressArr[0] ^ pressArr[1] ^ pressArr[3]) << 3;
                }
                seen.add(status);
            }
        }
        return seen.size();
    }

}
