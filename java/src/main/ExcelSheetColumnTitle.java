/**
 * Excel表列名称：https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber != 0) {
            char c = (char) ((columnNumber - 1) % 26 + 'A');
            result.append(c);
            columnNumber = (columnNumber - 1) / 26;
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1)); // "A"
        System.out.println(convertToTitle(28)); // "AB"
        System.out.println(convertToTitle(701)); // "ZY"
        System.out.println(convertToTitle(2147483647)); // "FXSHRXW"
    }

}
