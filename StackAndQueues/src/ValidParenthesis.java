import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]("));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> st = new Stack<>();
        return valid(s, st);
    }

    private static boolean valid(String s, Stack<Character> st) {
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                st.push(curr);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char topchar = st.pop();
                if ((curr == ')' && topchar != '(') || (curr == '}' && topchar != '{')
                        || (curr == ']' && topchar != '[')) {
                    return false;

                }
            }

        }
        return st.isEmpty();
    }
    
}
