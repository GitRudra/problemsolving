package org.home.leetcode;

public class TestBadVersion {

    private boolean[] versionArray;
    private int comparison;

    public TestBadVersion(boolean[] versionArray) {
        this.versionArray = versionArray;
    }

    private boolean isBadVersion(int version){
        return versionArray[version];
    }

    public int firstBadVersion(int n) {
        int startPos = 1;
        int endPos = n;
        int midPos;
        boolean isBad = false;

        while (startPos<endPos){
            midPos = (startPos+endPos)/2;
            isBad = isBadVersion(midPos);
            if(isBad){
                endPos = midPos-1;
            }else{
                startPos = midPos+1;
            }
        }
        return startPos;

    }
}
