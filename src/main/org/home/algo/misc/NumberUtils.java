package org.home.algo.misc;

public class NumberUtils {

	public static long makeNumberFromArray(long[] numarray, int start, int end,
			int digitcount) {
		long sum = numarray[end];
		int prod = 1;
		int i = 1;
		while (i < digitcount) {
			prod *= 10;
			sum += numarray[end - i] * prod;
			i++;
		}
		return sum;
	}

	public static long[] toArray(long inputnumber) {
		long[] numberarray;
		int numlengthcount = 0;
		long tempnumber = inputnumber;
		while (tempnumber > 0) {
			numlengthcount++;
			tempnumber = tempnumber / 10;
		}
		numberarray = new long[numlengthcount];
		tempnumber = inputnumber;
		int i = 0;
		while (i < numlengthcount) {
			numberarray[numlengthcount - 1 - i] = tempnumber % 10;
			tempnumber = tempnumber / 10;
			i++;
		}
		return numberarray;
	}

}
