/**
 * 比较版本号：https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        int i = 0, j = 0;
        while (i < m || j < n) {
            int num1 = 0;
            while (i < m && version1.charAt(i) != '.') {
                num1 += num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            int num2 = 0;
            while (j < n && version2.charAt(j) != '.') {
                num2 += num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("0.1", "1.1"));
    }

}
