/**
 * Excel 表列序号：https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("FXSHRXW"));
    }

}
