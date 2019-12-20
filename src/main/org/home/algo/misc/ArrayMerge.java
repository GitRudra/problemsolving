/**
 * The class is used to solve a particular problem of array.
 * Let array A contain N element in sorted order,
 * and array B of size M+N contains element in sorted order.
 * Merge A and B preserving the order.
 * Array B does not contain enough place to store all the elements of B.
 * Concern regarding the problem: 
 * 1. Suppose the elements in array A do not occur in B. Then how to merger A & B ?
 * 2. Suppose the number of elements in A which do not appear in B is larger than remaining place in B.
 * Then how the merge will possible ?
 * 
 * Here the algorithm developed based on the ideal case, i.e. the number of distinct element in A those do not occur in B 
 * is equal to the number of remaining blank places in B.
 */

package org.home.algo.misc;

public class ArrayMerge {
	private int[] firstarray = null;
	private int[] secondarray = null;
	private int actualdatalength = 0;

	public ArrayMerge(int[] firstarray, int[] secondarray) {
		this.firstarray = firstarray;
		this.secondarray = secondarray;
		getDataLength(secondarray);
	}

	public void mergeArray() {
		int arraylength1 = firstarray.length - 1;
		int arraylength2 = secondarray.length - 1;
		int templength = actualdatalength - 1;
		System.out.println("Actual data : " + templength);
		while (arraylength1 >= 0 && templength >= 0) {
			if (firstarray[arraylength1] > secondarray[templength]) {
				secondarray[arraylength2] = firstarray[arraylength1];
				arraylength1--;
				arraylength2--;
			} else if (firstarray[arraylength1] < secondarray[templength]) {
				secondarray[arraylength2] = secondarray[templength];
				templength--;
				arraylength2--;
			} else {
				secondarray[arraylength2] = secondarray[templength];
				templength--;
				arraylength1--;
				arraylength2--;
			}

			System.out.println("\nFirst Array : ");
			displayArray(firstarray);
			System.out.println("\nSecond Array : ");
			displayArray(secondarray);

		}
		if (arraylength1 == 0) {
			while (templength >= 0) {
				secondarray[arraylength2] = firstarray[templength];
				templength--;
				arraylength2--;
			}
		}
		if (templength == 0) {
			while (arraylength1 >= 0) {
				secondarray[arraylength2] = firstarray[arraylength1];
				arraylength1--;
				arraylength2--;
			}
		}
		System.out.println("\n Resulatent Array : ");
		displayArray(secondarray);
	}

	/**
	 * return the number of actual eligible element present in array B, assuming
	 * the blank places are filled by -1.
	 * 
	 * @param inarray
	 *            the input array
	 */
	public void getDataLength(final int[] inarray) {
		int i = 0;
		while (i < inarray.length && inarray[i] != -1) {
			actualdatalength++;
			i++;
		}

	}

	/**
	 * Display any array.
	 * 
	 * @param inarray
	 *            the input array
	 */
	private void displayArray(final int[] inarray) {
		for (int element : inarray) {
			System.out.print(element + " , ");
		}
	}
}
