/**
 * 1694. 重新格式化电话号码：https://leetcode.cn/problems/reformat-phone-number/
 */
public class ReformatPhoneNumber {

    public static void main(String[] args) {
        System.out.println(reformatNumber("1-23-45 6")); // "123-456"
        System.out.println(reformatNumber("123 4-567")); // "123-45-67"
        System.out.println(reformatNumber("123 4-5678")); // "123-456-78"
        System.out.println(reformatNumber("12")); // "12"
        System.out.println(reformatNumber("--17-5 229 35-39475 ")); // "175-229-353-94-7"
    }

    public static String reformatNumber(String number) {
        number = number.replaceAll("[ \\-]", "");
        StringBuilder ans = new StringBuilder();
        int pos = 0, n = number.length();
        for (; pos < n - 4; pos += 3) {
            ans.append(number, pos, pos + 3).append('-');
        }
        if (n - pos == 4) {
            ans.append(number, pos, pos + 2).append('-')
                .append(number, pos + 2, pos + 4);
        } else {
            ans.append(number, pos, n);
        }
        return ans.toString();
    }

}
