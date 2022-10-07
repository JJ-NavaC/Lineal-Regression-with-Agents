public class RegressionLinealSimple {
    // Private Variables
    private int beta_0;
    private int beta_1;
    private String y;
    private int[] setX;
    private int[] setY;
    private int Xi = 0;
    private int Yi = 0;
    private int n;

    // Constructor
    public RegressionLinealSimple(int[] _setX, int[] _setY) {
        this.setX = _setX;
        this.setY = _setY;
        for (int i = 0; i < _setX.length; i++) {
            this.Xi = this.Xi + _setX[i];
        }
        for (int i = 0; i < _setY.length; i++) {
            this.Yi = this.Yi + _setY[i];
        }
        n = _setX.length;
    }

    // Getters
    public int getBeta_0() {
        return beta_0;
    }

    public int getBeta_1() {
        return beta_1;
    }

    public String getY() {
        return y;
    }

    public void getSetX() {
        for (int i = 0; i < setX.length; i++) {
            System.out.print(setX[i]);
        }
    }

    public void getSetY() {
        for (int i = 0; i < setY.length; i++) {
            System.out.print(setY[i]);
        }
    }

    public int getXi() {
        return Xi;
    }

    public int getYi() {
        return Yi;
    }

    public int getN() {
        return n;
    }

    // Setters
    public void setBeta_0(int beta_0) {
        this.beta_0 = beta_0;
    }

    public void setBeta_1(int beta_1) {
        this.beta_1 = beta_1;
    }

    public void setX(String x) {
        this.y = x;
    }

    public void setSetX(int[] x) {
        this.setX = x;
    }

    public void setSetY(int[] y) {
        this.setY = y;
    }

    public void setXi(int Xi) {
        this.Xi = Xi;
    }

    public void setYi(int Yi) {
        this.Yi = Yi;
    }

    public void setN(int n) {
        this.n = n;
    }

    // Calculate beta_0
    public int calculateBeta_0() {
        int aux = 0;
        int numerator = 0;
        int denominator = 0;
        numerator = Yi - (getBeta_1() * Xi);
        denominator = n;
        aux = numerator / denominator;
        setBeta_0(aux);
        return aux;
    }

    // Calculate beta_1
    public int calculateBeta_1() {
        int aux = 0;
        int numerator = 0;
        int denominator = 0;
        numerator = (n * Xi * Yi) - (Xi * Yi);
        denominator = (n * Xi + Xi) - (Xi * Xi);
        aux = numerator / denominator;
        setBeta_1(aux);
        return aux;
    }

    // Set and Get ŷ Formula
    public String getFormula() {
        this.y = "ŷ = " + beta_0 + " + " + beta_1 + "x + ε";
        return this.y;
    }
}