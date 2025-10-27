/**
 * 2125. 银行中的激光束数量：https://leetcode.cn/problems/number-of-laser-beams-in-a-bank
 */
public class NumberOfLaserBeamsInABank {

    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prevCount = 0;
        for (String s : bank) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
            }
            if (count != 0) {
                res += prevCount * count;
                prevCount = count;
            }
        }
        return res;
    }

}
