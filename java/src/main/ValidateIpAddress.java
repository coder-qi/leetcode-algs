import java.util.regex.Pattern;

/**
 * 468. 验证IP地址：https://leetcode.cn/problems/validate-ip-address/
 */
public class ValidateIpAddress {

    static final Pattern IPV4_PATTERN = Pattern.compile("(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])([.](\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
    static final Pattern IPV6_PATTERN = Pattern.compile("[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}");

    public static String validIPAddress(String queryIP) {
        if (IPV4_PATTERN.matcher(queryIP).matches()) {
            return "IPv4";
        } else if (IPV6_PATTERN.matcher(queryIP).matches()) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1")); // IPv4
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // IPv6
        System.out.println(validIPAddress("256.256.256.256")); // Neither
        System.out.println(validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334")); // IPv6
    }

}
