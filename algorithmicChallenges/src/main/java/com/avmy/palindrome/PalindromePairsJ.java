package com.avmy.palindrome;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* {@link PalindromePairs }
*/
public class PalindromePairsJ {
    public static List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordIndexMap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++)
            wordIndexMap.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                for (int j = 0; j < words.length; j++) {
                    String w = words[j];
                    if (j != i && isPal(w)) {
                        ans.add(List.of(i, j));
                        ans.add(List.of(j, i));
                    }
                }
                continue;
            }
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            String wordReversed = sb.toString();
            if (wordIndexMap.containsKey(wordReversed)) {
                int res = wordIndexMap.get(wordReversed);
                if (res != i) ans.add(List.of(i, res));
            }
            for (int j = 1; j < wordReversed.length(); j++) {
                String substringRight = wordReversed.substring(j);
                if (wordIndexMap.containsKey(substringRight) && isPal(words[i] + substringRight)) {
                    ans.add(List.of(i, wordIndexMap.get(substringRight)));
                }
                String substringLeft = wordReversed.substring(0, j);
                if (wordIndexMap.containsKey(substringLeft) && isPal(substringLeft + words[i])) {
                    ans.add(List.of(wordIndexMap.get(substringLeft), i));
                }
            }
        }
        return ans;
    }

    private static boolean isPal(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
}
