import java.util.Scanner;

/**
 * Author: Calvin Yeung
 * Date: 16/09/15
 * Class Description:
 * This class contains the main method, used to test
 * Matrix operations defined in Matrix and MatrixMath
 */

public class MatrixRunner {
	
	/**
	 * Entry point to application
	 */
	public static void main(String[] args) {
		
		// Local variables
		Scanner s = new Scanner(System.in);
		int row, col;
		
		// Gather Matrix data
		System.out.print("Input number of rows: ");
		row = s.nextInt();
		
		System.out.print("Input number of columns: ");
		col = s.nextInt();
		System.out.println();
		
		// Table that corresponds to matrix
		double[][] table = new double[row][col];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.printf("Value at (%d, %d): ", i, j);
				table[i][j] = s.nextDouble();
			}
		}
		
		// Create Matrix object
		Matrix m = new Matrix(table);
		
		// Print Matrix object
		System.out.println("\n---------------\n");
		System.out.println("Matrix:");
		System.out.println(m);
		
		// Print determinant if square
		if(row == col) {
			System.out.println("\nDeteriminant of Matrix:");
			System.out.println(MatrixMath.getDeterminant(m));
		}
		
		else {
			System.out.println("\nMatrix has no determinant!");
		}
	}
}