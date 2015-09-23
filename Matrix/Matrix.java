/*
 * Author: Calvin Yeung
 * Date: 16/09/15
 * Class Description:
 * This class contains a blueprint for a Matrix
 * object; operations are defined in the MatrixMath
 * class
 */

public class Matrix {
	
	//Instance variables
	private double[][] table;
	
	// Default constructor
	public Matrix(int n, int m) {
		
		// Initialize matrix with 0s
		table = new double[n][m];
		
		for(int j = 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth(); i++)
				table[j][i] = 0;
	}
	
	// Initialization constuctor
	public Matrix(double[][] table) {
		this.table = table;
	}
	
	// Accessor Methods
	// Returns the width of the matrix
	public int getWidth() {
		return table[0].length;
	}
	
	// Returns the height of the matrix
	public int getHeight() {
		return table.length;
	}
	
	// Returns the value at location n, m
	public double getValue(int n, int m) {
		return table[n][m];
	}
	
	// Modifier Method
	// Sets value at n, m to specified value
	public void setValue(double value, int n, int m) {
		table[n][m] = value;
	}
	
	// String representation of matrix
	public String toString() {
		String matrix = "";
		int max = findMaxLength();
		
		for(int j = 0; j < getHeight(); j++) {
			String row = "";
			
			for(int i = 0; i < getWidth(); i++) {
				int length = ("" + table[j][i]).length();
				row = row + table[j][i];
				
				for(int k = 0; k < max - length + 1; k++)
					row = row + " ";
			}
			
			matrix = matrix + "| " + row + "|";
			
			if(j != getHeight() - 1) matrix = matrix + "\n";
		}
		
		return matrix;
	}
	
	// Returns the longest number in matrix (for formatting)
	private int findMaxLength() {
		int max = Integer.MIN_VALUE;
		
		for(int j = 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth(); i++)
				if(("" + table[j][i]).length() > max)
					max = ("" + table[j][i]).length();
		
		return max;
	}
}