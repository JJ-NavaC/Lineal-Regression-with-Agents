public class DescendingGradient {
    // Private Variables
    private double beta_0 = 0;
    private double beta_1 = 0;
    private int[] setX;
    private int[] setY;
    private double sumX;
    private double sumY;
    private double n;
    private double partialDerivateB0;
    private double partialDerivateB1;
    private double learningRate;
    private double error;

    // Constructor
    DescendingGradient(int[] _setX, int[] _setY) {
        this.setX = _setX;
        this.setY = _setY;
        setSumX(_setX);
        setSumY(_setY);
        setN(_setX.length);
        setPartialDerivateB0();
        setPartialDerivateB1();
    }

    // Getters
    public double getBeta_0() {
        return this.beta_0;
    }

    public double getBeta_1() {
        return this.beta_1;
    }

    public int[] getSetX() {
        return this.setX;
    }

    public int[] getSetY() {
        return this.setY;
    }

    public double getSumX() {
        return this.sumX;
    }

    public double getSumY() {
        return this.sumY;
    }

    public double getN() {
        return this.n;
    }

    public double getPartialDerivateB0() {
        return this.partialDerivateB0;
    }

    public double getPartialDerivateB1() {
        return this.partialDerivateB1;
    }

    public double getLearningRate() {
        return learningRate;
    }
    public double getError() {
        return error;
    }

    // Setters
    public void setSumX(int[] _sumX) {
        int aux = 0;
        for (int i = 0; i < _sumX.length; i++) {
            aux = aux + _sumX[i];
        }
        this.sumX = aux;
    }

    public void setSumY(int[] _sumY) {
        int aux = 0;
        for (int i = 0; i < _sumY.length; i++) {
            aux = aux + _sumY[i];
        }
        this.sumY = aux;
    }

    public void setN(int _n) {
        this.n = _n;
    }

    public void setPartialDerivateB0() {
        double aux = 0;
        aux = (double) ((-2) / this.n) * (this.sumY - (this.beta_0 + (this.beta_1 * this.sumX)));
        this.partialDerivateB0 = (double) aux;
    }

    public void setPartialDerivateB1() {
        double aux = 0;
        aux = (double) (((-2 / this.n) * (this.sumX)) * (this.sumY - (this.beta_0 + (this.beta_1 * this.sumX))));
        this.partialDerivateB1 = (double) aux;
    }

    public void setError(){

    }

    // Main process
    public void process() {
        
    }
}