/*
 * Author: Calvin Yeung
 * Date: 16/09/15
 * Class Description:
 * This class contains the methods which operate
 * on Matrix objects
 */

import static java.lang.Math.pow;

public class MatrixMath {
	
	// Returns Matrix after scalar multiplication
	public static Matrix multiply(Matrix m, double d) {
		Matrix n = new Matrix(m.getWidth(), m.getHeight());
		for(int j = 0; j < m.getHeight(); j++)
			for(int i = 0; i < m.getWidth(); i++)
				n.setValue(d * m.getValue(j, i), j, i);
				
		return n;
	}
	
	// Returns determinant of matrix
	public static double getDeterminant(Matrix m) {
		double det = 0;
		
		// Check if matrix is square
		if(m.getWidth() != m.getHeight()) {
			System.out.println("Error: matrix must be square!");
			return -1;
		}
		
		// Solve base case: 2x2 matrix
		else if(m.getWidth() == 2) {
			double a = m.getValue(0, 0);
			double b = m.getValue(0, 1);
			double c = m.getValue(1, 0);
			double d = m.getValue(1, 1);
			
			det = a * d - b * c;
		}
		
		// Solve larger cases
		else {
			for(int i = 0; i < m.getWidth(); i++) {
				double[][] newTable = new double[m.getWidth() - 1][m.getHeight() - 1];
				int[] indicies = new int[m.getWidth() - 1];
				
				int z = 0;
				for(int j = 0; j < m.getWidth(); j++)
					if(j != i) indicies[z++] = j;
					
				for(int b = 0; b < m.getHeight() - 1; b++) {
					int a = 0;
					
					for(int d : indicies) {
						newTable[b][a++] = m.getValue(b + 1, d);
					}
				}
				
				// Solve for determinant recursively
				det += pow(-1, i) * getDeterminant(new Matrix(newTable)) * m.getValue(0, i);
			}
		}
		
		return det;
	}
}