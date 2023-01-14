package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * 844. Backspace String Compare
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class StackStringE3N844 {
    public boolean backspaceCompare(String s, String t) {
        return reduce(s).equals(reduce(t));
    }

    private String reduce(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            var curChar = s.charAt(i);
            if(curChar == '#') {
                if(dq.size() != 0) {
                    dq.removeFirst();
                }
            } else {
                dq.addFirst(curChar);
            }
        }
        return dq.stream().map(Object::toString).collect(Collectors.joining());
    }
}
