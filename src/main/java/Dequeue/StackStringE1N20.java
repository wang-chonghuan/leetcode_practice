package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 */
public class StackStringE1N20 {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            var curChar = s.charAt(i);
            if(dq.size() != 0) {
                if(isMatch(dq.peekFirst(), curChar)) {
                    dq.removeFirst();
                } else {
                    dq.addFirst(curChar);
                }
            } else {
                dq.addFirst(curChar);
            }
        }
        return dq.size() == 0;
    }

    private boolean isMatch(Character c1, Character c2) {
        if(c1 == '(' && c2 == ')')
            return true;
        if(c1 == '{' && c2 == '}')
            return true;
        if(c1 == '[' && c2 == ']')
            return true;
        return false;
    }
}
