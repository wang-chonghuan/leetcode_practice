package ZLeetcode;

public class No278FirstBadVersion {

    private final int firstBadVersion = 2;

    private boolean isBadVersion(int currentVersion) {
        if(currentVersion == firstBadVersion) {
            return true;
        } else {
            return false;
        }
    }
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end) {
            //mid = (start + end) / 2;
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) { // mid is bad, it may be the first bad, so it may be the new end
                end = mid;
            } else if(!isBadVersion(mid)) { // mid is ok, it can't be the new start
                start = mid + 1;
            }
        }
        return start; // not mid
    }
}
