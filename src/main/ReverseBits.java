/**
 * 颠倒二进制位：https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32 - str.length(); i++) {
            sb.append('0');
        }
        sb.append(str).reverse();
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(reverseBits(-3)));
        System.out.println(Integer.toBinaryString(reverseBits(964176192)));
    }

}
