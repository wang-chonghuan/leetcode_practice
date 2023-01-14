package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. Simplify Path
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 */
public class StackStringP1N71 {
    /**
     这题的诀窍是根据斜杠拆分字符串，千万不要一个字符一个字符分析
     坑 for deque还是逆序的，因为栈顶在first，所以要removeLast
     比较字符串必须必须必须必须用equal
     */
    public String simplifyPath(String path) {
        Deque<String> dq = new ArrayDeque<>();
        String[] sList = path.split("/");
        for(var s : sList) {
            if(s.equals("") || s.equals(".")) { // 有连续的斜杠
                continue;
            } else if(s.equals("..")) {
                if(dq.size() > 0) {
                    dq.removeFirst();
                }
            } else {
                dq.addFirst(s);
            }
        }
        var sb = new StringBuilder();
        while(dq.size() > 0) {
            sb.append('/');
            sb.append(dq.removeLast());
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
