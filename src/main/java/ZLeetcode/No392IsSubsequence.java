package ZLeetcode;

public class No392IsSubsequence {
    /**
     *
     * @param s
     * @param t
     * @return
     *
     * src: abc
     * tar: ahbgdce
     * 如果匹配到b以后,匹配不到c了,不需要从gdce再重新开始匹配abc,因为后面肯定没有c了,因此此时就是false
     * 我的错误思路就在于以为若有一个匹配不到,就回去重新匹配
     * c如果不在b的后面,也不会在ab之间,因为b是第一个出现的b,ab之间即使有c也没用
     *
     */
    public boolean isSubsequence(String s, String t) {
        int ptrSrc = 0;
        int ptrTar = 0;
        while(ptrSrc < s.length() && ptrTar < t.length()) {
            if(s.charAt(ptrSrc) == t.charAt(ptrTar)) {
                ++ptrSrc;
                ++ptrTar;
            } else {
                ++ptrTar;
            }
        }
        return ptrSrc == s.length();
    }
}
