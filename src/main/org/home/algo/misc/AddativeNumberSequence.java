package org.home.algo.misc;

public class AddativeNumberSequence {

	private int inputnumber;

	/**
	 * @return the input number
	 */
	public int getInputnumber() {
		return inputnumber;
	}

	/**
	 * @param inputnumber
	 *            the input number to set
	 */
	public void setInputnumber(int inputnumber) {
		this.inputnumber = inputnumber;
	}

	public boolean isAddativeNumber(long number) {

		long[] digitsinnumber = NumberUtils.toArray(number);
		long numberofdigits = digitsinnumber.length;
		boolean result = true;
		boolean finalflag = false;
		for (int i = 0; i < numberofdigits / 3; i++) {
			for (int j = 0; j <= numberofdigits - 3 * (i + 1); j = j + i + 1) {
				long part1 = NumberUtils.makeNumberFromArray(digitsinnumber, j,
						j + i, i + 1);
				long part2 = NumberUtils.makeNumberFromArray(digitsinnumber, j
						+ i + 1, j + 2 * i + 1, i + 1);
				long part3 = NumberUtils.makeNumberFromArray(digitsinnumber, j
						+ 2 * (i + 1), j + 2 * (i + 1) + i, i + 1);
				if (part1 + part2 != part3 && !finalflag) {
					result = false;
					break;
				} else {
					result = true;
				}
			}
			if (result) {
				finalflag = true;
			} else {
				finalflag = false;
			}
		}
		return finalflag;
	}

	public void findAddativeNumberIn(long start, long end) {
		long tempstart = start;
		while (tempstart <= end) {
			if (isAddativeNumber(tempstart)) {
				System.out.print(tempstart + " ,");
			}
			tempstart++;
		}
	}

}
