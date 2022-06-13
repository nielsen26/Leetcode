package Stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '{' || cur == '(' || cur == '[') {
                stack.push(cur);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char cur_stack = stack.pop();
                if (cur == '}' && cur_stack != '{') {
                    return false;
                } else if (cur == ')' && cur_stack != '(') {
                    return false;
                } else if (cur == ']' && cur_stack != '[') {
                    return false;
                }
            }
        }

        if (stack.empty()) {
            return true;
        }

        return false;
    }
}
