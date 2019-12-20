package org.home.algo.string;

/**
 * Given a string, the task is to return the length of its longest possible chunked palindrome.
 * It means a palindrome formed by substring in the case when it is not formed by characters of the string.
 * For better understanding look at the example
 * <p>
 * Examples:
 * <p>
 * Input : ghiabcdefhelloadamhelloabcdefghi
 * Output : 7
 * (ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)
 * <p>
 * Input : merchant
 * Output : 1
 * (merchant)
 * <p>
 * Input : antaprezatepzapreanta
 * Output : 11
 * (a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)
 * <p>
 * Input : geeksforgeeks
 * Output : 3
 * (geeks)(for)(geeks)
 */
public class LongestPossibleChunkedPalindromeFinder {

    public static void findPalindromeChunk(String s) {
        int length = s.length();
        StringBuilder frontSb = new StringBuilder();
        StringBuilder midSB = new StringBuilder();
        int lastAccessedIndex;
        int start = 0;
        int lastCounter = s.length();
        int end = s.length() - 1;
        int charFoundAt = s.length() - 1;
        StringBuilder word = null;
        while (start < charFoundAt) {
            charFoundAt = findCharacterFromLast(s, s.charAt(start), lastCounter - 1);
            if (start == charFoundAt) {
                midSB.append("(");
                midSB.append(s.substring(start, lastCounter));
                midSB.append(")");
                break;
            }
            /*if(charFoundAt != -1){
                frontSb.append("(");
                endSb.append("(");
            }else{
                return;
            }*/
            boolean nomatch = false;
            word = new StringBuilder();
            for (int i = charFoundAt; i < lastCounter; i++) {
                if (s.charAt(start) == s.charAt(i)) {
                    word.append(s.charAt(start));
                    start++;
                } else {
                    nomatch = true;
                }
            }
            lastCounter = charFoundAt;
            if (!nomatch) {
                frontSb.append("(").append(word).append(")");
            }

        }

        String str = frontSb.toString();
        System.out.println(frontSb.append(midSB).append(str));
    }

    private static int findCharacterFromLast(String s, char ch, int startIndex) {
        while (startIndex >= 0) {
            if (s.charAt(startIndex) == ch) {
                return startIndex;
            }
            startIndex--;
        }
        return -1;

    }

    public static int findLPC(String str) {

        return findLPCRec(str, 0, 0, str);
    }

    private static int findLPCRec(String curStr, int len, int count, String str) {
        if (curStr == null || curStr.length() == 0) {
            return 0;
        }
        if (curStr.length() <= 1) {
            if (count != 0 && str.length() - len <= 1) {
                return count + 1;
            } else {
                return 1;
            }
        }
        int n = curStr.length();
        for (int i = 0; i < n / 2; i++) {
            if (curStr.substring(0, i + 1).equals(curStr.substring(n - 1 - i, n))) {
                return findLPCRec(curStr.substring(i + 1, n - 1 - i), (i + 1) * 2, count + 2, str);
            }
        }
        return count + 1;
    }
}
