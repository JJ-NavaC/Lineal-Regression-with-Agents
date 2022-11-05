
public class Main {

        static int[] x = { 1, 2, 3, 4 };
        static int[] y = { 2, 4, 6, 8 };
        static double[] x1 = { 41.9, 43.4, 43.9, 44.5, 47.3, 47.5, 47.9, 50.2, 52.8,
                        53.2, 56.7, 57.0, 63.5, 65.3, 71.1,
                        77.0, 77.8 };
        static double[] x2 = { 29.1, 29.3, 29.5, 29.7, 29.9, 30.3, 30.5, 30.7, 30.8,
                        30.9, 31.5, 31.7, 31.9, 32.0, 32.1,
                        32.5, 32.9 };
        static double[] _y = { 251.3, 251.3, 248.3, 267.5, 273.0, 276.5, 270.3, 274.9,
                        285.0, 290.0, 297.0, 302.5, 304.5,
                        309.3, 321.7, 330.7, 349.0 };

        static int predicts = 3;
        static int predict = 20;

        public static void main(String[] args) {

                // SIMPLE LINEAL REGRESSION //! CORREGIDO
                System.out.println("SIMPLE LINEAL REGRESSION\n");
                RegressionLinealSimple regressionLinealSimple1 = new RegressionLinealSimple(x, y);
                System.out.println("Beta 0: " + regressionLinealSimple1.getBeta_0());
                System.out.println("Beta 1: " + regressionLinealSimple1.getBeta_1());
                System.out.println("Formula: " + regressionLinealSimple1.getFormula());
                regressionLinealSimple1.predecir(predicts);
                System.out.println("Formula Predict n = " + predicts + ": " + regressionLinealSimple1.getFormulaP());

                // MULTIPLE LINEAL REGRESSION BY MATRIX --- VECTORIZED //! ENTREGADO
                System.out.println("\nMULTIPLE LINEAL REGRESSION BY MATRIX --- VECTORIZED\n");
                RegressionLinealMultiple1 regressionLinealMultiple1 = new RegressionLinealMultiple1(x1, x2, _y);
                System.out.println("Betas Vector: ");
                regressionLinealMultiple1.printVector(regressionLinealMultiple1.getVectorBetas(), 3);
                System.out.println("Formula: " + regressionLinealMultiple1.getFormula());
                System.out.println("Formula Predict n = " + predict + ": "
                                + regressionLinealMultiple1.getFormulaP(predict));

                // MULTIPLE LINEAL REGRESSION BY DETERMINANTS --- CRAMMER //! POR ENTREGAR
                System.out.println("\nMULTIPLE LINEAL REGRESSION BY DETERMINANTS --- CRAMMER\n");
                RegressionLinealMultiple2 regressionLinealMultiple2 = new RegressionLinealMultiple2(x1, x2, _y);
                System.out.println("Beta 0: " + regressionLinealMultiple2.getBeta_0());
                System.out.println("Beta 1: " + regressionLinealMultiple2.getBeta_1());
                System.out.println("Beta 2: " + regressionLinealMultiple2.getBeta_2());
                System.out.println("Formula: " + regressionLinealMultiple2.getFormula());
                regressionLinealMultiple2.predict(predict);
                System.out.println("Formula Predict n = " + predict + ": " + regressionLinealMultiple2.getFormulaP());

                // DECENDING GRADIENT //! ENTREGADO
                System.out.println("DECENDING GRADIENT\n");
                DescendingGradient descendingGradient = new DescendingGradient(x, y, 0.1,
                                0.003);
                descendingGradient.process();
                System.out.println("\nFinal Error: " + descendingGradient.getError() +
                                " by a Learning Rate of " + descendingGradient.getLearningRate() +
                                " and an Error Tolerance of: " + descendingGradient.getErrorTorelance());
                System.out.println();
                descendingGradient.process_p(predict);
                System.out.println("\nFinal Error Predict n = " + predict + ": " +
                                descendingGradient.getError_p() + " by a Learning Rate of " +
                                descendingGradient.getLearningRate() + " and an Error Tolerance of: " +
                                descendingGradient.getErrorTorelance());
        }
}
