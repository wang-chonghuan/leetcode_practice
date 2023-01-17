package Deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * Example 2: 1047. Remove All Adjacent Duplicates In String
 *
 * You are given a string s. Continuously remove duplicates (two of the same character beside each other) until you can't anymore. Return the final string after this.
 *
 * For example, given s = "abbaca", you can first remove the "bb" to get "aaca". Next, you can remove the "aa" to get "ca". This is the final answer.
 */
public class StackStringE2N1047 {
    public String removeDuplicates(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            var curChar = s.charAt(i);
            if(dq.size() == 0) {
                dq.addFirst(curChar);
            } else {
                if(dq.peekFirst() == curChar) {
                    dq.removeFirst();
                } else {
                    dq.addFirst(curChar);
                }
            }
        }
        String s1 = dq.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
        String s2 = new StringBuilder(s1).reverse().toString();
        return s2;
    }
}
