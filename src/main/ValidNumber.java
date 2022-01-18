import java.util.HashMap;
import java.util.Map;

/**
 * 有效数字：https://leetcode-cn.com/problems/valid-number/
 */
public class ValidNumber {
    static Map<State, Map<CharType, State>> transfer = new HashMap<>();
    static {
        transfer.put(State.STATE_INITIAL, new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }});
        transfer.put(State.STATE_INT_SIGN, new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }});
        transfer.put(State.STATE_INTEGER, new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }});
        transfer.put(State.STATE_POINT, new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }});
        transfer.put(State.STATE_POINT_WITHOUT_INT, new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }});
        transfer.put(State.STATE_FRACTION, new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
        }});
        transfer.put(State.STATE_EXP, new HashMap<>() {{
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }});
        transfer.put(State.STATE_EXP_SIGN, new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }});
        transfer.put(State.STATE_EXP_NUMBER, new HashMap<>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }});
    }

    public static boolean isNumber(String s) {
        State state = State.STATE_INITIAL;
        for (int i = 0; i < s.length(); i++) {
            CharType type = toCharType(s.charAt(i));
            state = transfer.get(state).get(type);
            if (state == null) {
                return false;
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT
            || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER
            || state == State.STATE_END;
    }

    private static CharType toCharType(char c) {
        if (c >= '0' && c <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (c == 'e' || c == 'E') {
            return CharType.CHAR_EXP;
        } else if (c == '.') {
            return CharType.CHAR_POINT;
        } else if (c == '+' || c == '-') {
            return CharType.CHAR_SIGN;
        }
        return CharType.CHAR_ILLEGAL;
    }

    enum State {
        STATE_INITIAL, STATE_INT_SIGN, STATE_INTEGER, STATE_POINT,
        STATE_POINT_WITHOUT_INT, STATE_FRACTION, STATE_EXP,
        STATE_EXP_SIGN, STATE_EXP_NUMBER, STATE_END
    }

    enum CharType {
        CHAR_NUMBER, CHAR_EXP, CHAR_POINT, CHAR_SIGN, CHAR_ILLEGAL
    }

    public static void main(String[] args) {
        String[] arr = { "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3",
            "3e+7", "+6e-1", "53.5e93", "-123.456e789" };
        System.out.println("-----------------true-----------");
        for (String str : arr) {
            System.out.println(isNumber(str));
        }

        String[] arr2 = { "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53" };
        System.out.println("-----------------false-----------");
        for (String str2 : arr2) {
            System.out.println(isNumber(str2));
        }
        System.out.println("-----------------example-----------");
        System.out.println(isNumber("e"));
        System.out.println(isNumber("."));
        System.out.println(isNumber(".1"));
        System.out.println(isNumber("4e+"));
    }

}
