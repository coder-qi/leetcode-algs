import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址：https://leetcode.cn/problems/unique-email-addresses/
 */
public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        Set<String> s = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            int index = email.indexOf('@');
            int plusIndex = email.indexOf('+');
            String localName;
            if (plusIndex != -1) {
                localName = email.substring(0, plusIndex);
            } else {
                localName = email.substring(0, index);
            }
            localName = localName.replace(".", "");
            s.add(localName +  "@" + email.substring(index + 1));
        }
        return s.size();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"})); // 2
        System.out.println(numUniqueEmails(new String[] {"a@leetcode.com","b@leetcode.com","c@leetcode.com"})); // 3
    }

}
