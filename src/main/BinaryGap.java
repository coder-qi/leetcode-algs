/**
 * 868. 二进制间距：https://leetcode-cn.com/problems/binary-gap/
 */
public class BinaryGap {

    public static int binaryGap(int n) {
        int result = 0, pos = 0, bitPos = 32;
        while (n != 0) {
            if ((n & 1) != 0) {
                result = Math.max(result, pos - bitPos);
                bitPos = pos;
            }
            pos++;
            n >>= 1;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(binaryGap(22)); // 2
        System.out.println(binaryGap(8)); // 0
        System.out.println(binaryGap(5)); // 2
    }

}
