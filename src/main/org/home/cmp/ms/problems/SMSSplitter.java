package org.home.cmp.ms.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SMSSplitter {

    public static void main(String[] args) {
        /*SMSSplitter sol = new SMSSplitter();
        int x =sol.splitSms("I Love My India Proud To Be Indian",5);
        System.out.println("Solution =" + x);*/
        double d = (double)Math.round((8.0/16) * 100000d) / 100000d;
        System.out.println(d);
    }

    public int splitSms(String S, int K) {
        if(S==null ||S.length()==0){
            return -1;
        }
        int sms = 0;
        String words[] = S.split("\\s");
        int curLength = 0;
        boolean notPossible = false;
        List<String> wordsForSen = new ArrayList();
        List<String> ooutput = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if(i==words.length-1){
                curLength += words[i].length();
            }else{
                curLength += words[i].length() + 1;
            }

            if (curLength > K) {
                if (wordsForSen.size() == 0 ) {
                    notPossible = true;
                    break;
                } else {
                    String res = buildSentence(wordsForSen);
                    ooutput.add(res);
                    wordsForSen = new ArrayList<>();
                    curLength = 0;
                    i--;
                }

            } else {
                wordsForSen.add(words[i]);
            }
        }
        if(!notPossible && wordsForSen.size()>0){
            ooutput.add(buildSentence(wordsForSen));
        }

        if (notPossible || ooutput.size()==0) {
            return -1;
        } else {
            return ooutput.size();
        }

    }

    public String buildSentence(List<String> input) {
        String sen = "";
        for (int i = 0; i < input.size(); i++) {
            sen = input.get(i) + " ";
        }

        return sen.trim();
    }
}
