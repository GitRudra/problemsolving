package org.home.algo.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class WordBreakingProblemTest {

    @Test
    public void testBreakIntoWordOne() {
        String input = "iamfrombengal";
        WordBreakingProblem problemSolver = new WordBreakingProblem(getDictionary());
        String expected = "i am from bengal";
        String actual = problemSolver.breakIntoWord(input);
        assertEquals(expected,actual);
    }

    @Test
    public void testBreakIntoWordTwo() {
        String input = "ilikeicecreamandmango";
        WordBreakingProblem problemSolver = new WordBreakingProblem(getDictionary());
        String expected = "i like ice cream and man go";
        String actual = problemSolver.breakIntoWord(input);
        assertEquals(expected,actual);
    }

    @Test
    public void testBreakIntoWordThree() {
        String input = "ilikeicecreamandmango";
        WordBreakingProblem problemSolver = new WordBreakingProblem(getDictionary());
       // String expected = "i like ice cream and man go";
        //String actual = problemSolver.breakIntoWord(input);
        ArrayList<String> resultList = problemSolver.breakSentence(input);
        if(resultList.isEmpty()){
            System.out.println("Cannot break the sentence");
        }else{
            resultList.forEach(e-> System.out.println(e));
        }
        //assertEquals(expected,actual);
    }

    private Set<String> getDictionary(){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("i");
        dictionary.add("am");
        dictionary.add("a");
        dictionary.add("from");
        dictionary.add("bengal");
        dictionary.add("man");
        dictionary.add("go");
        dictionary.add("mango");
        dictionary.add("like");
        dictionary.add("hike");
        dictionary.add("ice");
        dictionary.add("cream");
        dictionary.add("icecream");
        dictionary.add("and");
        return dictionary;
    }
}