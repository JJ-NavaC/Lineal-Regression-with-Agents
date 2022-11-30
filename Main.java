
public class Main {
        static int[] x = { 1, 2, 3, 4 };
        static int[] y = { 2, 4, 6, 8 };
        static int predictX = 3;
        static double errorTolerance = 0.1;
        static double learningRate = 0.003;

        /*
         * static double[] x1 = { 41.9, 43.4, 43.9, 44.5, 47.3, 47.5, 47.9, 50.2, 52.8,
         * 53.2, 56.7, 57.0, 63.5, 65.3, 71.1,
         * 77.0, 77.8 };
         * static double[] x2 = { 29.1, 29.3, 29.5, 29.7, 29.9, 30.3, 30.5, 30.7, 30.8,
         * 30.9, 31.5, 31.7, 31.9, 32.0, 32.1,
         * 32.5, 32.9 };
         * static double[] _y = { 251.3, 251.3, 248.3, 267.5, 273.0, 276.5, 270.3,
         * 274.9,
         * 285.0, 290.0, 297.0, 302.5, 304.5,
         * 309.3, 321.7, 330.7, 349.0 };
         * 
         * static double predictX1 = 77.0;
         * static double predictX2 = 30.9;
         */

        static double[] x1 = { 1, 4, 2 };
        static double[] x2 = { 1, 2, 4 };
        static double[] _y = { 0, 1, 1 };
        static double predictX1 = 1;
        static double predictX2 = 1;

        public static void main(String[] args) {

                // SIMPLE LINEAL REGRESSION //? LISTO
                System.out.println("\nSIMPLE LINEAL REGRESSION\n");
                RegressionLinealSimple regressionLinealSimple1 = new RegressionLinealSimple(x, y);
                System.out.println("Beta 0: " + regressionLinealSimple1.getBeta_0());
                System.out.println("Beta 1: " + regressionLinealSimple1.getBeta_1());
                System.out.println("Formula: " + regressionLinealSimple1.getFormula());
                System.out.println("Predict for X1: " + predictX + " | y = "
                                + regressionLinealSimple1.predict(predictX));

                // MULTIPLE LINEAL REGRESSION BY MATRIX --- VECTORIZED //? LISTO
                System.out.println("\nMULTIPLE LINEAL REGRESSION BY MATRIX --- VECTORIZED\n");
                RegressionLinealMultiple1 regressionLinealMultiple1 = new RegressionLinealMultiple1(x1, x2, _y);
                System.out.println("Betas Vector: ");
                regressionLinealMultiple1.printVector(regressionLinealMultiple1.getVectorBetas(), 3);
                System.out.println("Formula: " + regressionLinealMultiple1.getFormula());
                System.out.println("Predict for X1: " + predictX1 + " and X2: " + predictX2 + " | y = "
                                + regressionLinealMultiple1.predict(predictX1, predictX1));

                // MULTIPLE LINEAL REGRESSION BY DETERMINANTS --- CRAMMER //? LISTO
                System.out.println("\nMULTIPLE LINEAL REGRESSION BY DETERMINANTS --- CRAMMER\n");
                RegressionLinealMultiple2 regressionLinealMultiple2 = new RegressionLinealMultiple2(
                                x1,
                                x2, _y);
                System.out.println("Beta 0: " + regressionLinealMultiple2.getBeta_0());
                System.out.println("Beta 1: " + regressionLinealMultiple2.getBeta_1());
                System.out.println("Beta 2: " + regressionLinealMultiple2.getBeta_2());
                System.out.println("\nFormula: " + regressionLinealMultiple2.getFormula());
                System.out.println("Predict for X1: " + predictX1 + " and X2 = " + predictX2 + " | y = "
                                + regressionLinealMultiple2.predict(predictX1, predictX2));

                // DECENDING GRADIENT //? LISTO
                System.out.println("\nDECENDING GRADIENT");
                DescendingGradient descendingGradient = new DescendingGradient(x, y, errorTolerance,
                                learningRate);
                descendingGradient.process();
                System.out.println("\nBetas Vector: ");
                System.out.println("Beta 0: " + descendingGradient.getBeta_0());
                System.out.println("Beta 1: " + descendingGradient.getBeta_1());
                System.out.println("Final Error: " + descendingGradient.getError() +
                                "\nBy a Learning Rate of " + descendingGradient.getLearningRate() +
                                " and an Error Tolerance of: " + descendingGradient.getErrorTorelance());
                System.out.println();
        }
}
