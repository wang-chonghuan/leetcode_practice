package Hashing;

import java.util.HashSet;

/**
 * Check if the Sentence Is Pangram
 *
 * Solution
 * A pangram is a sentence where every letter
 * of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters,
 * return true if sentence is a pangram, or false otherwise.
 */
public class CheckExistP1N1832 {
    public boolean checkIfPangramWRONG(String sentence) {
        var charSet = new HashSet<Character>();
        // 这种情况会忽略刚好句子有26个字符的情况!!!!
        for(int i = 0; i < sentence.length(); i++) {
            if(charSet.size() >= 26) {
                return true;
            } else {
                charSet.add(sentence.charAt(i));
            }
        }
        return false;
    }

    public boolean checkIfPangramSTD(String sentence) {
        var charSet = new HashSet<Character>();
        for(int i = 0; i < sentence.length(); i++) {
            charSet.add(sentence.charAt(i));
        }
        return charSet.size() == 26;
    }
}
