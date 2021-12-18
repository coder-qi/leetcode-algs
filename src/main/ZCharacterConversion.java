/**
 *  Z 字形变换：https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class ZCharacterConversion {

    /**
     * 思路：每一行的顺序为从上往下，所以可以针对每一行单独使用一个StringBuilder
     * 来存放其字符，最后拼接到一起就行了。
     *
     * 时间复杂：O(N)，空间复杂度O(N)
     */
    public static String convert_rowStrArr(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rowStrArr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rowStrArr[i] = new StringBuilder();
        }
        boolean down = true;
        for (int i = 0, row = 0; i < s.length(); i++) {
            rowStrArr[row % numRows].append(s.charAt(i));
            if (row == numRows - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder ans = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            ans.append(rowStrArr[i]);
        }
        return ans.toString();
    }

    /**
     * <p>按行访问
     * <p>思路：直接拼接每一行的下一个字符输出接口。
     * <li>第一行和最后一行的字符距离为：2 * numRows - 2
     * <li>中间行，向下时：(numRows - i - 1) * 2，向上时：i * 2
     *
     * <p>时间复杂：O(N)，空间复杂度O(N)
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            int pos = i;
            boolean down = true;
            while (pos < s.length()) {
                ans.append(s.charAt(pos));
                if (i == 0 || i == numRows - 1) {
                    pos += 2 * numRows - 2;
                } else {
                    if (down) {
                        pos += (numRows - i - 1) * 2;
                    } else {
                        pos += i * 2;
                    }
                    down = !down;
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
    }

}
