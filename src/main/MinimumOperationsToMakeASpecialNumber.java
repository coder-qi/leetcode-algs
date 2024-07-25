/**
 * 2844. 生成特殊数字的最少操作：https://leetcode.cn/problems/minimum-operations-to-make-a-special-number
 */
public class MinimumOperationsToMakeASpecialNumber {

    public static int minimumOperations(String num) {
        if (num.length() == 1) {
            return num.charAt(0) == '0' ? 0 : 1;
        }
        // 25 50 75 100
        int N = num.length();
        int res = 0;
        char last = 0;
        char last2 = 0;
        boolean ok = false;
        for (int i = N - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            if (last == 0) {
                if (ch != '0' && ch != '5') {
                    res++;
                    continue;
                }
                last = ch;
                continue;
            }
            if (last == '5' || last2 == '5') {
                if (ch == '2' || ch == '7') {
                    if (last != 0 && last2 != 0) {
                        res++;
                    }
                    ok = true;
                    break;
                }
            }
            if (last == '0' || last2 == '0') {
                if (ch == '5' || ch == '0') {
                    if (last != 0 && last2 != 0) {
                        res++;
                    }
                    ok = true;
                    break;
                }
            }

            if (ch != '0' && ch != '5') {
                res++;
            } else {
                if (last2 == 0) {
                    last2 = ch;
                } else {
                    if (ch == '0') {
                        last2 = ch;
                    }
                    res++;
                }
            }
        }
        if (!ok) {
            if (last == '5') {
                res++;
            }
            if (last2 == '5') {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
       // System.out.println(minimumOperations("2908305"));
        //System.out.println(minimumOperations("15"));
        System.out.println(minimumOperations("51"));
        System.out.println(minimumOperations("35778477915111315314455696633"));
        // 25
        System.out.println(minimumOperations("86305094841399619139843436167737787457334866691767899648084608668568815311769746637"));
    }

}
