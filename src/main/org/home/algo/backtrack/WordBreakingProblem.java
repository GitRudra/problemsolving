package org.home.algo.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

public class WordBreakingProblem {

    private Set<String> dictionary;

    public WordBreakingProblem(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public String breakIntoWord(String sentence){
        LinkedList<String> words = new LinkedList<>();
        if(breakStringRec(sentence,words)){
            StringBuilder sb = new StringBuilder();
            words.forEach(e->sb.append(e).append(" "));
            return sb.toString().trim();
        }
        return "";
    }

    private boolean breakStringRec(String sentence, LinkedList<String> words){
        if(sentence == null || sentence.length() == 0){
            return true;
        }
        boolean isFurtherBreakable = false;
        for(int i=1;i<=sentence.length();i++){
            String prefix = sentence.substring(0,i);
            if(dictionary.contains(prefix)){
                words.addLast(prefix);
                isFurtherBreakable = breakStringRec(sentence.substring(i),words);
                if(!isFurtherBreakable){
                    words.removeLast();
                }
            }
        }
        return isFurtherBreakable;
    }

    /**
     * Given a valid sentence without any spaces between the words and a
     * dictionary of valid English words, find all possible ways to break
     * the sentence in individual dictionary words.
     * @param sentence as input
     * @return list of all possible sentence
     */
    public ArrayList<String> breakSentence(String sentence){
        ArrayList<String> container = new ArrayList<>();
        if(sentence != null && sentence.length()!=0){
            breakSentenceUtil(sentence,sentence.length(),"",container);
        }
        Collections.sort(container);
        return container;

    }

    private void breakSentenceUtil(String sentence, int n, String result, ArrayList<String> container){
        //Process all prefixes one by one
        for(int i=1;i<=n;i++){
            //extract substring from 0 to i in prefix
            String prefix = sentence.substring(0,i);
            // if dictionary contains this prefix, then
            // we check for remaining string. Otherwise
            // we ignore this prefix (there is no else for
            // this if) and try next
            if(dictionary.contains(prefix)){
                if(i==n){
                    result += prefix;
                    container.add(result);
                    return;
                }
                breakSentenceUtil(sentence.substring(i),n-i,result+prefix+" ",container);
            }
        }
    }
}
