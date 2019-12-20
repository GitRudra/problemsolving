package org.home.algo.misc;


public class MisseleniousProblems {

    /**
     * The method is used to find the missing elements of a sequence of numbers.
     * Ex: Input Sequence : 1,2,3,5,6,7,9,10
     * Output         : 4,8
     *
     * @param inputarray
     */
    public static void findMissingElementsInSeries(int[] inputarray) {
        boolean isfound = false;
        for (int i = 0, k = 0; i < inputarray.length; i++) {
            if (inputarray[i] != i + k + 1) {
                System.out.println((i + k + 1));
                k++;
                isfound = true;
            }
        }
        if (!isfound) {
            System.out.println("No missing elements found");
        }
    }

    /**
     * The method is used to rotate an integer array by k position
     * Ex: Input : 1,2,3,4,5,6,7 Rotate By 3 bit
     *     Output : 5,6,7,1,2,3,4
     * @param inputarray   input array of integer
     * @param rotatebybits the number position need to rotate
     */
    public static void rotateArrayByKBits(int[] inputarray, int rotatebybits) throws Exception {
        if(inputarray==null || inputarray.length==0){
            throw new Exception("Invalid Input");
        }
        int i, j;
        for (i = 0; i < inputarray.length - rotatebybits; i = i + rotatebybits) {
            for (j = 0; j < rotatebybits; j++) {
                swap(inputarray, i + j, inputarray.length - rotatebybits + j);
            }
        }
    }

    /**
     * Swap two integers of an array.
     *
     * @param inputarray
     * @param pos1
     * @param pos2
     */
    public static void swap(int[] inputarray, int pos1, int pos2) {
        int temp;
        temp = inputarray[pos1];
        inputarray[pos1] = inputarray[pos2];
        inputarray[pos2] = temp;
    }

    /**
     * @param series
     */
    public void subsequenceOfThreeNumbersHavingMaximumProduct(int[] series) {
        int result[] = {0, 0, 0};
        if (series.length < 3) {
            displayArray(series);
        }
        result = keepOrdering(result, series[0]);
        result = keepOrdering(result, series[1]);
        result = keepOrdering(result, series[2]);

        for (int i = 3; i < series.length; i++) {
            result = keepOrdering(result, series[i]);
        }
        displayArray(result);
    }

    public int[] keepOrdering(int[] result, int newelt) {

        if (newelt >= result[2]) {
            result[0] = result[1];
            result[1] = result[2];
            result[2] = newelt;
        } else if (newelt < result[2] && newelt >= result[1]) {
            result[0] = result[1];
            result[1] = newelt;
        } else if (newelt < result[1] && newelt >= result[0]) {
            result[0] = newelt;
        }
        return result;

    }

    /**
     * The method is used to reverse a sentence without reversing its words. Ex:
     * Input Sentence : I Love My India
     * output Sentence : India My Love I
     * Step 1] Stores the position of blank spaces in a list.
     * Step 2] Reverse the String.
     * Step 3] Reverse each word using the information of blank space.
     *
     * @param insentence , the input String
     */
    public void reverseSentence(String insentence) {
        char[] sentence = insentence.toCharArray();
        int[] blankposlist = new int[100];

        displayArray(sentence);
        int k = 0;
        blankposlist[k++] = -1;

        // storing the position of blank space in the input string.
        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i] == ' ') {
                blankposlist[k++] = i;
            }
        }
        blankposlist[k] = sentence.length;
        // reverse the input string
        reverseString(sentence, 0, sentence.length - 1);

        // Reverse each word
        for (int m = 0; m < sentence.length; ) {
            int reverselen = blankposlist[k] - blankposlist[k - 1] - 1;
            reverseString(sentence, m, m + reverselen - 1);
            m = m + reverselen + 1;
            k--;
        }

        displayArray(sentence);
    }

    /**
     * The method is used to reverse an array from <code>start</code> to <code>end</code> position
     *
     * @param inarray , The input array.
     * @param start   , The start position of the array.
     * @param end,    The end position of the array.
     */
    public void reverseString(char[] inarray, int start, int end) {
        char ch;
        for (int i = 0; i <= (end - start) / 2; i++) {
            ch = inarray[start + i];
            inarray[start + i] = inarray[end - i];
            inarray[end - i] = ch;
        }
    }

    /**
     * To display an character array
     *
     * @param inarray a character array
     */
    void displayArray(char[] inarray) {
        System.out.println("\n---- Displaying array ---");
        for (char element : inarray) {
            System.out.print(element);
        }
    }

    /**
     * To display an integer array
     *
     * @param inarray an integer array
     */

    void displayArray(int[] inarray) {
        System.out.println("\n---- Displaying array ---");
        for (int element : inarray) {
            System.out.print(element + " , ");
        }
    }

    public void findKthSmallestElementIn2DArray(int[][] input, int row, int col){

    }

    class MinHeap{
        int[] heapArray;

        MinHeap(int size){
            heapArray = new int[size];
        }
    }
}
