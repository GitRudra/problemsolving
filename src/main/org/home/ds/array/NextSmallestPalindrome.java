package org.home.ds.array;

import java.util.ArrayList;

/**
 * Given a number, find the next smallest palindrome larger than this number.
 * For example, if the input number is “2 3 5 4 5”,
 * the output should be “2 3 6 3 2”.
 * And if the input number is “9 9 9”,
 * the output should be “1 0 0 1”.
 * The input is assumed to be an array.
 * Every entry in array represents a digit in input number.
 * Let the array be ‘num[]’ and size of array be ‘n’
 *
 * There can be three different types of inputs that need to be handled separately.
 * 1) The input number is palindrome and has all 9s.
 * For example “9 9 9”. Output should be “1 0 0 1”
 * 2) The input number is not palindrome.
 * For example “1 2 3 4”. Output should be “1 3 3 1”
 * 3) The input number is palindrome and dose not have all 9s.
 * For example “1 2 2 1”. Output should be “1 3 3 1”.
 */
public class NextSmallestPalindrome {
    public int[] findNextPalindrome(int[] input){


        if(input == null || input.length==0){
            return null;
        }
        ArrayList<Integer> result = new ArrayList();
        for(int x: input){
            result.add(x);
        }
        int digitCount = input.length;
        int i,j;
        if(digitCount%2 == 0){
            i= digitCount/2-1;
            j = digitCount/2;
        }else{
            i= digitCount/2-1;
            j= digitCount/2 +1;
        }
        while((i>=0 && j<digitCount) && input[i] == input[j]){
            i--;
            j++;
        }
        int carryForward = 0;
        int pos = 0;
        if(isBoundaryCrossed(i,j,digitCount)){
            carryForward =  incrementMidElement(result);
            if(carryForward == 1){
                propagateCarryToMSB(result);
            }
            if(result.size()%2 == 0){
                mirrorLeftToRight(result,result.size()/2-1,result.size()/2);
            }else{
                mirrorLeftToRight(result,result.size()/2-1,result.size()/2+1);
            }

        }else{
            if(result.get(i)>=result.get(j)){
                mirrorLeftToRight(result,i,j);
            }else{
                carryForward = incrementMidElement(result);
                if(carryForward == 1){
                   pos =  propagateCarryToMSB(result);

                }
                if(result.size()%2 == 0){
                    mirrorLeftToRight(result,result.size()/2-1,result.size()/2);
                }else{
                    mirrorLeftToRight(result,result.size()/2-1,result.size()/2+1);
                }
            }
        }

        //TODO: Implement the method
        int k=0;
        int[] resultArray = new int[result.size()];
        for(Integer x: result){
            resultArray[k++] = x.intValue();
        }
        return resultArray;
    }

    private void mirrorLeftToRight(ArrayList<Integer> result, int x, int y){
        while(x>=0){
            result.set(y,result.get(x));
            x--;
            y++;
        }
    }

    private int propagateCarryToMSB(ArrayList<Integer> result){
        int value = 0;
        int pos = (result.size()%2 == 0) ? (result.size()/2-2): result.size()/2-1;
        int i=0;
        for(i=pos;i>=0;i--){
            value = result.get(i)+1;
            if(value % 10 ==0){
                result.set(i,value%10);
                value = value/10;
            }else{
                result.set(i,value);
                break;
            }
        }
        if(value ==1){
            result.add(0,1);
        }
        return i;
    }

    private int incrementMidElement(ArrayList<Integer> input){
        int n = input.size();
        if(n%2 == 0){
            input.set(n/2,(input.get(n/2)+1));
            input.set(n/2-1,(input.get(n/2-1)+1));
            /*input[n/2] = input[n/2]+1;
            input[n/2-1] = (input[n/2-1]+1)%10;*/
        }else{
//            input[n/2] = input[n/2]+1;
            input.set(n/2,(input.get(n/2)+1));
        }
        int carryForward = 0;
        if(input.get(n/2) == 10){
            carryForward = 1;
            input.set(n/2,0);
        }

        return carryForward;
    }

    private boolean isBoundaryCrossed(int x, int y, int len){
        return (x<0 && y>=len);
    }
}
