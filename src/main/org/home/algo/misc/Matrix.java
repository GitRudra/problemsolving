package org.home.algo.misc;

public class Matrix {

	public int row;
	public int column;
	public int[] values;

	public Matrix(int row, int column) {
		this.row = row;
		this.column = column;
		this.values = new int[row * column];
	}

	public void setValues(int[] values) {
		for (int i = 0; i < row * column; i++) {
			this.values[i] = values[i];
		}
	}

	public Matrix multiply(final Matrix M) {

		return M;
	}

	/**
	 * The method is used to calculate the Transpose of a matrix. let input
	 * matrix A(4X3) = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
	 * 
	 * Transpose of A T[A](3X4) = {1, 4, 7, 10, 2, 5, 8, 11, 3, 6, 9, 12}
	 * 
	 * @return Transpose of the matrix.
	 */
	public Matrix transposeMatrix() {
		Matrix transmat = new Matrix(this.column, this.row);
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				transmat.values[j * transmat.column + i] = this.values[i
						* column + j];
			}
			transmat.displayMatrix();
		}

		return transmat;
	}

	public void interchangeRows() {
		int n = this.column / 2;
		int temp;
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < n; j++) {
				temp = this.values[i * this.column + j];
				this.values[i * this.column + j] = this.values[i * this.column
						+ (this.column - 1 - j)];
				this.values[i * this.column + (this.column - 1 - j)] = temp;
			}
		}
	}

	public void displayMatrix() {
		System.out.println("\n------------");
		for (int i = 0; i < row; i++) {
			System.out.println("");
			for (int j = 0; j < column; j++) {
				System.out.print(values[i * column + j] + "  ");
			}
		}

	}
}
