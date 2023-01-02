package ZLeetcode;

import java.util.HashMap;
import java.util.Map;

public class No205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> dictS = new HashMap<>();
        var dictT = new HashMap<Character, Integer>();
        String tempS = getTemplateString(s, dictS);
        String tempT = getTemplateString(t, dictT);
        return tempS.equals(tempT);
    }

    private String getTemplateString(String oriStr, Map<Character, Integer> dict) {
        StringBuilder retStrBuf = new StringBuilder();
        int newReplacement = 1;
        for(int i = 0; i != oriStr.length(); ++i) {
            char curChar = oriStr.charAt(i);
            if(!dict.containsKey(curChar)) {
                dict.put(curChar, newReplacement++);
                retStrBuf.append(String.valueOf(newReplacement));
            } else {
                int oldReplacement = dict.get(curChar);
                retStrBuf.append(String.valueOf(oldReplacement));
            }
            retStrBuf.append(',');
        }
        return retStrBuf.toString();
    }
}
