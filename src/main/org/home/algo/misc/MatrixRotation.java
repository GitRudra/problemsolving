package org.home.algo.misc;


public class MatrixRotation {

	Matrix inmat = null;

	/**
	 * @param values
	 * @param row
	 * @param column
	 */
	public MatrixRotation(int[] values, int row, int column) {
		inmat = new Matrix(row, column);
		inmat.setValues(values);
	}

	/**
	 * The method is used to rotate a matrix clockwise 90 degree. Calculate
	 * transpose of the matrix and then reverse matrix based on middle row.
	 */
	public void rotateMatrixClockWise90Dgree() {
		inmat = inmat.transposeMatrix();
		inmat.interchangeRows();
		inmat.displayMatrix();
		/*
		 * Matrix resmat = new Matrix(inmat.row, inmat.column); for (int i = 0;
		 * i < inmat.row; i++) { for (int j = 0; j < inmat.column; j++) {
		 * resmat.values[j * inmat.column + (inmat.row - i - 1)] =
		 * inmat.values[i inmat.row + j]; } }
		 * System.out.println("\n input matrix"); inmat.displayMatrix();
		 * System.out.println("\n resultant matrix"); resmat.displayMatrix();
		 */
	}
}
