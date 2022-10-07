
public class Main {

        static int[] x = { 1, 2, 2, 3 };
        static int[] y = { 1, 2, 3, 6 };

        /*
         * static double[] x1 = { 41.9, 43.4, 43.9, 44.5, 47.3, 47.5, 47.9, 50.2, 52.8,
         * 53.2, 56.7, 57.0, 63.5, 65.3, 71.1,
         * 77.0, 77.8 };
         * static double[] x2 = { 29.1, 29.3, 29.5, 29.7, 29.9, 30.3, 30.5, 30.7, 30.8,
         * 30.9, 31.5, 31.7, 31.9, 32.0, 32.1,
         * 32.5, 32.9 };
         * static double[] y = { 251.3, 251.3, 248.3, 267.5, 273.0, 276.5, 270.3, 274.9,
         * 285.0, 290.0, 297.0, 302.5, 304.5,
         * 309.3, 321.7, 330.7, 349.0 };
         */

        public static void main(String[] args) {
                // SIMPLE LINEAL REGRESSION
                /*
                 * RegressionLinealSimple regressionLinealSimple1 = new
                 * RegressionLinealSimple(x, y);
                 * System.out.println("Xi: " + regressionLinealSimple1.getXi());
                 * System.out.println("Yi: " + regressionLinealSimple1.getYi());
                 * System.out.println("N: " + regressionLinealSimple1.getN());
                 * System.out.println("Beta 1: " + regressionLinealSimple1.calculateBeta_1());
                 * System.out.println("Beta 0: " + regressionLinealSimple1.calculateBeta_0());
                 * System.out.println("Formula: " + regressionLinealSimple1.getFormula());
                 * System.out.println("Program Ended");
                 */

                // MULTIPLE LINEAL REGRESSION BY MATRIX

                /*
                 * RegressionLinealMultiple1 regressionLinealMultiple1 = new
                 * RegressionLinealMultiple1(x1, x2, y);
                 * System.out.println("Matrix X");
                 * regressionLinealMultiple1.setMatrix();
                 * System.out.println("\nMatrix X'");
                 * regressionLinealMultiple1.setMatrixT();
                 * System.out.println("\nMatrix X'X");
                 * regressionLinealMultiple1.setMatrixMult(); // (X'X)
                 * regressionLinealMultiple1.setDetMatrix(); // Det (X'X)
                 * System.out.println("\nDet Matrix: " +
                 * regressionLinealMultiple1.getDetMatrix());
                 * regressionLinealMultiple1.setMatrixAdjT(); // *(X'X)'
                 * regressionLinealMultiple1.setMatrixInv(); // (X'X)-1
                 * System.out.println("\nVector X'y: ");
                 * regressionLinealMultiple1.setVectorXY();
                 * System.out.println("\nVector Betas: ");
                 * regressionLinealMultiple1.setVectorBetas();
                 * System.out.println("\nFormula: " + regressionLinealMultiple1.getFormula());
                 * System.out.println("Program Ended");
                 */

                // MULTIPLE LIENAL REGRESSION BY DETERMINANTS

                /*
                 * RegressionLinealMultiple2 regressionLinealMultiple2 = new
                 * RegressionLinealMultiple2(x1, x2, y);
                 * System.out.println("X1i: " + regressionLinealMultiple2.getSumX1());
                 * System.out.println("X2i: " + regressionLinealMultiple2.getSumX2());
                 * System.out.println("Yi: " + regressionLinealMultiple2.getSumY());
                 * regressionLinealMultiple2.setDetMatrixT();
                 * System.out.println("Det T: " + regressionLinealMultiple2.getDetT());
                 * regressionLinealMultiple2.setDetMatrixB0();
                 * System.out.println("Det B0: " + regressionLinealMultiple2.getDetB0());
                 * regressionLinealMultiple2.setDetMatrixB1();
                 * System.out.println("Det B1: " + regressionLinealMultiple2.getDetB1());
                 * regressionLinealMultiple2.setDetMatrixB2();
                 * System.out.println("Det B2: " + regressionLinealMultiple2.getDetB2());
                 * regressionLinealMultiple2.setBeta0();
                 * System.out.println("Beta 0: " + regressionLinealMultiple2.getBeta_0());
                 * regressionLinealMultiple2.setBeta1();
                 * System.out.println("Beta 1: " + regressionLinealMultiple2.getBeta_1());
                 * regressionLinealMultiple2.setBeta2();
                 * System.out.println("Beta 2: " + regressionLinealMultiple2.getBeta_2());
                 */

                // DECENDING GRADIENT
                DescendingGradient descendingGradient = new DescendingGradient(x, y);
                // System.out.println("Sum X: " + descendingGradient.getSumX());
                // System.out.println("Sum Y: " + descendingGradient.getSumY());
                // System.out.println("N: " + descendingGradient.getN());
                // System.out.println("Beta 0: " + descendingGradient.getBeta_0());
                // System.out.println("Beta 1: " + descendingGradient.getBeta_1());                
                // System.out.println("Partial Derivate B0: " + descendingGradient.getPartialDerivateB0()); 
                // System.out.println("Partial Derivate B1: " + descendingGradient.getPartialDerivateB1()); 
                
        }
}
