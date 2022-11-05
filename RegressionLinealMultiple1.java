// Matrix Method
public class RegressionLinealMultiple1 {
    // Private Variables
    private String y;
    private double[] setX1;
    private double[] setX2;
    private double[] setY;
    private double beta_0;
    private double beta_1;
    private double beta_2;
    private double[][] matrix;
    private double[][] matrixT;
    private double[][] matrixXX;
    private double[][] matrixInv;
    private double[][] matrixAdj;
    private double[][] matrixAdjT;
    private double[] vectorXY;
    private double[] vectorBetas;
    private double detMatrix = 0;
    private int n;

    // Constructor
    RegressionLinealMultiple1(double[] _setX1, double[] _setX2, double[] _setY) {
        this.setX1 = _setX1;
        this.setX2 = _setX2;
        this.setY = _setY;
        this.n = _setX1.length;
        setMatrix(); // Form X
        setMatrixT(); // Get X'
        setMatrixMult(); // Get (X'X)
        setDetMatrix(); // Get Det(X'X)
        setMatrixAdjT(); // Get *(X'X)'
        setMatrixInv(); // Get (X'X)-1
        setVectorXY(); // Get (X'Y)
        setVectorBetas(); // Get β
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

    public double[][] getMatrixT() {
        return matrixT;
    }

    public double[][] getMatrixXX() {
        return matrixXX;
    }

    public double[][] getMatrixInv() {
        return matrixInv;
    }

    public double[][] getMatrixAdj() {
        return matrixAdj;
    }

    public double[][] getMatrixAdjT() {
        return matrixAdjT;
    }

    public double[] getVectorXY() {
        return vectorXY;
    }

    public double getDetMatrix() {
        return detMatrix;
    }

    public int getN() {
        return n;
    }

    public String getFormula() {
        this.y = "ŷ = " + this.beta_0 + " + " + this.beta_1 + "x1 + " + this.beta_2 + "x2 + ε";
        return this.y;
    }

    public double[] getVectorBetas() {
        return vectorBetas;
    }

    // Setters
    public void setY(String y) {
        this.y = y;
    }

    public void setSetX1(double[] setX1) {
        this.setX1 = setX1;
    }

    public void setSetX2(double[] setX2) {
        this.setX2 = setX2;
    }

    public void setSetY(double[] setY) {
        this.setY = setY;
    }

    public void setBeta_0(int beta_0) {
        this.beta_0 = beta_0;
    }

    public void setBeta_1(int beta_1) {
        this.beta_1 = beta_1;
    }

    public void setBeta_2(int beta_2) {
        this.beta_2 = beta_2;
    }

    public void setMatrix() {
        this.matrix = new double[this.n][3];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    this.matrix[i][j] = 1;
                } else if (j == 1) {
                    this.matrix[i][j] = this.setX1[i];
                } else {
                    this.matrix[i][j] = this.setX2[i];
                }
            }
        }
        // System.out.println("Matrix X");
        // printMatrix(this.matrix, this.n, 3);
    }

    public void setMatrixT() {
        this.matrixT = new double[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.n; j++) {
                this.matrixT[i][j] = this.matrix[j][i];
            }
        }
        // System.out.println("Matrix X'");
        // printMatrix(this.matrixT, 3, this.n);
    }

    public void setMatrixMult() {
        this.matrixXX = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < this.n; k++) {
                    for (int l = 0; l < this.n; l++) {
                        if (j == k) {
                            this.matrixXX[j][i] = this.matrixXX[j][i] + (this.matrixT[k][l] * this.matrix[l][i]);
                        }
                    }
                }
            }
        }
        // System.out.println("\nMatrix X'X");
        // printMatrix(this.matrixXX, 3, 3);
    }

    public void setDetMatrix() {
        this.detMatrix = (this.matrixXX[0][0] * this.matrixXX[1][1] * this.matrixXX[2][2])
                + (this.matrixXX[0][1] * this.matrixXX[1][2] * this.matrixXX[2][0])
                + (this.matrixXX[0][2] * this.matrixXX[1][0] * this.matrixXX[2][1])
                - (this.matrixXX[2][0] * this.matrixXX[1][1] * this.matrixXX[0][2])
                - (this.matrixXX[2][1] * this.matrixXX[1][2] * this.matrixXX[0][0])
                - (this.matrixXX[2][2] * this.matrixXX[1][0] * this.matrixXX[0][1]);
    }

    public void setMatrixAdjT() {
        this.matrixAdj = new double[3][3];
        this.matrixAdj[0][0] = 1 * (this.matrixXX[2][2] * this.matrixXX[1][1])
                - (this.matrixXX[2][1] * this.matrixXX[1][2]);
        this.matrixAdj[0][1] = 1 * (this.matrixXX[2][2] * this.matrixXX[1][0])
                - (this.matrixXX[2][0] * this.matrixXX[1][2]);
        this.matrixAdj[0][2] = 1 * (this.matrixXX[2][1] * this.matrixXX[1][0])
                - (this.matrixXX[2][0] * this.matrixXX[1][1]);
        this.matrixAdj[1][0] = 1 * (this.matrixXX[2][2] * this.matrixXX[0][1])
                - (this.matrixXX[2][1] * this.matrixXX[0][2]);
        this.matrixAdj[1][1] = 1 * (this.matrixXX[2][2] * this.matrixXX[0][0])
                - (this.matrixXX[2][0] * this.matrixXX[0][2]);
        this.matrixAdj[1][2] = 1 * (this.matrixXX[2][1] * this.matrixXX[0][0])
                - (this.matrixXX[2][0] * this.matrixXX[0][1]);
        this.matrixAdj[2][0] = 1 * (this.matrixXX[1][2] * this.matrixXX[0][1])
                - (this.matrixXX[1][1] * this.matrixXX[0][2]);
        this.matrixAdj[2][1] = 1 * (this.matrixXX[1][2] * this.matrixXX[0][0])
                - (this.matrixXX[1][0] * this.matrixXX[0][2]);
        this.matrixAdj[2][2] = 1 * (this.matrixXX[1][1] * this.matrixXX[0][0])
                - (this.matrixXX[1][0] * this.matrixXX[0][1]);

        this.matrixAdj[0][1] = this.matrixAdj[0][1] * (-1);
        this.matrixAdj[1][0] = this.matrixAdj[1][0] * (-1);
        this.matrixAdj[1][2] = this.matrixAdj[1][2] * (-1);
        this.matrixAdj[2][1] = this.matrixAdj[2][1] * (-1);

        // System.out.println("\nMatrix Adj: ");
        // printMatrix(this.matrixAdj, 3, 3);

        this.matrixAdjT = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matrixAdjT[i][j] = this.matrixAdj[j][i];
            }
        }
        // System.out.println("\nMatrix AdjT: ");
        // printMatrix(this.matrixAdjT, 3, 3);
    }

    public void setMatrixInv() {
        this.matrixInv = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matrixInv[i][j] = this.matrixAdjT[i][j] / getDetMatrix();
            }
        }
        // System.out.println("\nMatrix (X'X)-1: ");
        // printMatrix(this.matrixInv, 3, 3);
    }

    public void setVectorXY() {
        this.vectorXY = new double[this.n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.n; j++) {
                this.vectorXY[i] = this.vectorXY[i] + (this.matrixT[i][j] * this.setY[j]);
            }
        }
        // System.out.println("\nVector X'y: ");
        // printVector(this.vectorXY, 3);
    }

    public void setVectorBetas() {
        this.vectorBetas = new double[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.vectorBetas[i] = this.vectorBetas[i] + (this.matrixInv[i][j] * this.vectorXY[j]);
            }
        }
        // System.out.println("\nVector Betas: ");
        // printVector(this.vectorBetas, 3);
        setBeta_0(this.vectorBetas[0]);
        setBeta_1(this.vectorBetas[1]);
        setBeta_2(this.vectorBetas[2]);
    }

    void setBeta_0(double x) {
        this.beta_0 = x;
    }

    void setBeta_1(double x) {
        this.beta_1 = x;
    }

    void setBeta_2(double x) {
        this.beta_2 = x;
    }

    // Print Methods
    public void printMatrix(double[][] x, int iSize, int jSize) {
        for (int i = 0; i < iSize; i++) {
            for (int j = 0; j < jSize; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printVector(double[] x, int vSize) {
        for (int i = 0; i < vSize; i++) {
            System.out.println(x[i]);
        }
    }

    public String getFormulaP(int p){
        if(p>getN()){
            return "ŷ = " + getBeta_0() + " + " + (getBeta_1()+setX1[getN()-1]/(2*p)) + "x1 + " + (getBeta_2()+setX1[getN()-1]/(2*p)) + "x2 + ε";        
        } else {
            return "ŷ = " + getBeta_0() + " + " + getBeta_1() + "x1 + " + getBeta_2() + "x2 + ε";        
        }
       
    }
}
