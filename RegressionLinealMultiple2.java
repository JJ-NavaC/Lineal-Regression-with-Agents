// Determiant Method
public class RegressionLinealMultiple2 {
    // Privete Variables
    private String y;
    private double[] setX1;
    private double[] setX2;
    private double[] setY;
    private double beta_0;
    private double beta_1;
    private double beta_2;
    private double[][] matrix;
    private double[][] matrixB0;
    private double[][] matrixB1;
    private double[][] matrixB2;
    private double sumX1;
    private double sumX2;
    private double sumY;
    private int n;
    private double detT = 0;
    private double detB0 = 0;
    private double detB1 = 0;
    private double detB2 = 0;

    // Constructor
    RegressionLinealMultiple2(double[] _setX1, double[] _setX2, double[] _setY) {
        this.setX1 = _setX1;
        this.setX2 = _setX2;
        this.setY = _setY;
        this.n = _setX1.length;
        setSumX1();
        setSumX2();
        setSumY();
        setMatrix();
        setMatrixB0();
        setMatrixB1();
        setMatrixB2();
        setDetMatrixT();
        setDetMatrixB0();
        setDetMatrixB1();
        setDetMatrixB2();
        setBeta0();
        setBeta1();
        setBeta2();
    }

    // Getters
    public String getY() {
        return y;
    }

    public double[] getSetX1() {
        return setX1;
    }

    public double[] getSetX2() {
        return setX2;
    }

    public double[] getSetY() {
        return setY;
    }

    public double getBeta_0() {
        return beta_0;
    }

    public double getBeta_1() {
        return beta_1;
    }

    public double getBeta_2() {
        return beta_2;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[][] getMatrixB0() {
        return matrixB0;
    }

    public double[][] getMatrixB1() {
        return matrixB1;
    }

    public double[][] getMatrixB2() {
        return matrixB2;
    }

    public double getN() {
        return n;
    }

    public double getSumX1() {
        return sumX1;
    }

    public double getSumX2() {
        return sumX2;
    }

    public double getSumY() {
        return sumY;
    }

    public double getDetT() {
        return detT;
    }

    public double getDetB0() {
        return detB0;
    }

    public double getDetB1() {
        return detB1;
    }

    public double getDetB2() {
        return detB2;
    }

    public float getDetMatrix(double[][] x) {
        float det = (float) ((x[0][0] * x[1][1] * x[2][2])
                + (x[0][1] * x[1][2] * x[2][0])
                + (x[0][2] * x[1][0] * x[2][1])
                - (x[2][0] * x[1][1] * x[0][2])
                - (x[2][1] * x[1][2] * x[0][0])
                - (x[2][2] * x[1][0] * x[0][1]));
        return (float) det;
    }

    // Setters
    public void setSumX1() {
        for (int i = 0; i < this.n; i++) {
            this.sumX1 = (double) this.sumX1 + (double) this.setX1[i];
        }
    }

    public void setSumX2() {
        for (int i = 0; i < this.n; i++) {
            this.sumX2 = (double) this.sumX2 + (double) this.setX2[i];
        }
    }

    public void setSumY() {
        for (int i = 0; i < this.n; i++) {
            this.sumY = (double) this.sumY + (double) this.setY[i];
        }
    }

    public void setMatrix() {
        this.matrix = new double[3][3];
        this.matrix[0][0] = (double) this.n;
        this.matrix[0][1] = (double) this.sumX1;
        this.matrix[0][2] = (double) this.sumX2;
        this.matrix[1][0] = (double) this.sumX1;
        this.matrix[1][1] = (double) this.sumX1 * (double) this.sumX1;
        this.matrix[1][2] = (double) this.sumX1 * (double) this.sumX2;
        this.matrix[2][0] = (double) this.sumX2;
        this.matrix[2][1] = (double) this.sumX1 * (double) this.sumX2;
        this.matrix[2][2] = (double) this.sumX2 * (double) this.sumX2;
        // System.out.println("Matrix: ");
        // printMatrix(matrix);
    }

    public void setMatrixB0() {
        this.matrixB0 = new double[3][3];
        this.matrixB0[0][0] = (double) this.sumY;
        this.matrixB0[0][1] = (double) this.sumX1;
        this.matrixB0[0][2] = (double) this.sumX2;
        this.matrixB0[1][0] = (double) this.sumY * (double) this.sumX1;
        this.matrixB0[1][1] = (double) this.sumX1 * (double) this.sumX1;
        this.matrixB0[1][2] = (double) this.sumX1 * (double) this.sumX2;
        this.matrixB0[2][0] = (double) this.sumY * (double) this.sumX2;
        this.matrixB0[2][1] = (double) this.sumX1 * (double) this.sumX2;
        this.matrixB0[2][2] = (double) this.sumX2 * (double) this.sumX2;
        // System.out.println("Matrix B0: ");
        // printMatrix(matrixB0);
    }

    public void setMatrixB1() {
        this.matrixB1 = new double[3][3];
        this.matrixB1[0][0] = (double) this.n;
        this.matrixB1[0][1] = (double) this.sumY;
        this.matrixB1[0][2] = (double) this.sumX2;
        this.matrixB1[1][0] = (double) this.sumX1;
        this.matrixB1[1][1] = (double) this.sumY * (double) this.sumX1;
        this.matrixB1[1][2] = (double) this.sumX1 * (double) this.sumX2;
        this.matrixB1[2][0] = (double) this.sumX2;
        this.matrixB1[2][1] = (double) this.sumY * (double) this.sumX2;
        this.matrixB1[2][2] = (double) this.sumX2 * (double) this.sumX2;
        // System.out.println("Matrix B1: ");
        // printMatrix(matrixB1);
    }

    public void setMatrixB2() {
        this.matrixB2 = new double[3][3];
        this.matrixB2[0][0] = (double) this.n;
        this.matrixB2[0][1] = (double) this.sumX1;
        this.matrixB2[0][2] = (double) this.sumY;
        this.matrixB2[1][0] = (double) this.sumX1;
        this.matrixB2[1][1] = (double) this.sumX1 * (double) this.sumX1;
        this.matrixB2[1][2] = (double) this.sumY * (double) this.sumX1;
        this.matrixB2[2][0] = (double) this.sumX2;
        this.matrixB2[2][1] = (double) this.sumX1 * (double) this.sumX2;
        this.matrixB2[2][2] = (double) this.sumY * (double) this.sumX2;
        // System.out.println("Matrix B2: ");
        // printMatrix(matrixB2);
    }

    public void setDetMatrixT() {
        this.detT = (float) getDetMatrix(this.matrix);
        // printDetProcess(this.matrix);
    }

    public void setDetMatrixB0() {
        this.detB0 = (float) getDetMatrix(this.matrixB0);
        // printDetProcess(this.matrixB0);
    }

    public void setDetMatrixB1() {
        this.detB1 = (float) getDetMatrix(this.matrixB1);
        // printDetProcess(this.matrixB1);
    }

    public void setDetMatrixB2() {
        this.detB2 = (float) getDetMatrix(this.matrixB2);
        // printDetProcess(this.matrixB2);
    }

    public void setBeta0() {
        this.beta_0 = (float) this.detB0 / this.detT;
    }

    public void setBeta1() {
        this.beta_1 = (float) this.detB1 / this.detT;
    }

    public void setBeta2() {
        this.beta_2 = (float) this.detB2 / this.detT;
    }

    // Print Functions
    public void printMatrix(double[][] x) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printDetProcess(double[][] x) {
        System.out.println("+" + x[0][0] + "*" + x[1][1] + "*" +
                x[2][2]);
        System.out.println("+" + x[0][1] + "*" + x[1][2] + "*" +
                x[2][0]);
        System.out.println("+" + x[0][2] + "*" + x[1][0] + "*" +
                x[2][1]);
        System.out.println("-" + x[2][0] + "*" + x[1][1] + "*" +
                x[0][2]);
        System.out.println("-" + x[2][1] + "*" + x[1][2] + "*" +
                x[0][0]);
        System.out.println("-" + x[2][2] + "*" + x[1][0] + "*" +
                x[0][1]);
        System.out.println((x[0][0] * x[1][1] *
                x[2][2]));
        System.out.println("+ " + (x[0][1] * x[1][2] *
                x[2][0]));
        System.out.println("+ " + (x[0][2] * x[1][0] *
                x[2][1]));
        System.out.println("- " + (x[2][0] * x[1][1] *
                x[0][2]));
        System.out.println("- " + (x[2][1] * x[1][2] *
                x[0][0]));
        System.out.println("- " + (x[2][2] * x[1][0] *
                x[0][1]));
    }

    public String getFormula() {
        this.y = "ŷ = " + this.beta_0 + " + " + this.beta_1 + "x1 + " + this.beta_2 + "x2 + ε";
        return this.y;
    }
}
