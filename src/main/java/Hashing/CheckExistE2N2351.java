package Hashing;

import java.util.HashSet;

/**
 * Example 2: 2351. First Letter to Appear Twice
 *
 * Given a string s, return the first character to appear twice.
 * It is guaranteed that the input will have a duplicate character.
 */
public class CheckExistE2N2351 {
    public char findFirstTwice(String s) {
        var charSet = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(charSet.contains(s.charAt(i))) {
                return s.charAt(i);
            } else {
                charSet.add(s.charAt(i));
            }
        }
        return 0;
    }
}
