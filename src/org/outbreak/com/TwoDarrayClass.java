package org.outbreak.com;

public class TwoDarrayClass {
	 
		
	public static void main(String[] args) {
	    final Room[][] noInfectionMatrix = Consts.MATRIX.noInfection;
		final Room[][] horizontalTrueMatrix = Consts.MATRIX.horizontalTrue;
		final Room[][] verticalTrueMatrix = Consts.MATRIX.verticalTrue;
		final String pattern = Consts.MATRIX.isInfected;

	    /**
	     *  Read the input parameters as deault in case
	     */

	    if (args.length > 0) {
	      try {
	      }
	      catch (NumberFormatException e) {
	        System.out.println("First argument to Simulation is not an number.");
	      }
	    }

	    if (args.length > 1) {
	      try {
	      }
	      catch (NumberFormatException e) {
	        System.out.println("Second argument to Simulation is not an number.");
	      }
	    }

	    Matrix matrixTest2 = new Matrix(horizontalTrueMatrix, pattern);
	    matrixTest2.diagnose(matrixTest2);
	    
	    Matrix matrixTest1 = new Matrix(noInfectionMatrix, pattern);
	    matrixTest1.diagnose(matrixTest1);
	    
	    Matrix matrixTest3 = new Matrix(verticalTrueMatrix, pattern);
	    matrixTest3.diagnose(matrixTest3);
	  }
}
 

