package org.home.algo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramUtils {
    public static boolean isTwoStringAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        boolean res = true;
        int[] countArray = new int[256];
        Arrays.fill(countArray, 0);
        for (int i = 0; i < str1.length(); i++) {
            countArray[str1.charAt(i)]++;
            countArray[str2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (countArray[i] != 0) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void printAnagramStringTogether(String[] strings) {
        if (strings == null || strings.length == 0) {
            return;
        }
        HashMap<String, ArrayList<String>> elements = new HashMap<>();
        for (String str : strings) {
            char[] keys = str.toCharArray();
            Arrays.sort(keys);
            String elemKey = new String(keys);
            if (elements.containsKey(elemKey)) {
                elements.get(elemKey).add(str);
            } else {
                ArrayList<String> arrays = new ArrayList<>();
                arrays.add(str);
                elements.put(elemKey, arrays);
            }
        }

        System.out.println(elements.values().stream().collect(Collectors.toList()));
    }

    public static int removeMinimumCharacterToConvertAnagram(String str1, String str2) {
        int x = 0;
        int[] frequencyArray = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            frequencyArray[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            frequencyArray[str2.charAt(i)]--;
        }

        for (int i = 0; i < frequencyArray.length; i++) {
            x += frequencyArray[i];
        }
        return x;
    }
}
