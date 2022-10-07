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
    private double learningRate = 0.003;
    private double error;
    private double errorTolerance;

    // Constructor
    DescendingGradient(int[] _setX, int[] _setY, double _errorTolerance, double _learningRate) {
        this.setX = _setX;
        this.setY = _setY;
        this.errorTolerance = _errorTolerance;
        this.learningRate = _learningRate;
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

    public double getErrorTorelance() {
        return errorTolerance;
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

    public void setBeta_0(double beta_0) {
        this.beta_0 = beta_0;
    }

    public void setBeta_1(double beta_1) {
        this.beta_1 = beta_1;
    }

    public void setError(double error) {
        this.error = error;
    }

    public void setPartialDerivateB0() {
        double aux = 0;
        aux = (double) ((-2) / getN()) * (getSumY() - (getBeta_0() + (getBeta_1() * getSumX())));
        this.partialDerivateB0 = (double) aux;
    }

    public void setPartialDerivateB1() {
        double aux = 0;
        aux = (double) (((-2 / getN()) * (getSumX())) * (getSumY() - (getBeta_0() + (getBeta_1() * getSumX()))));
        this.partialDerivateB1 = (double) aux;
    }

    public void calculateError() {
        double aux = (double) (1 / getN()) * Math.pow((getSumY() - (getBeta_0() + (getBeta_1() * getSumX()))), 2);
        setError(aux);
    }

    // Main process
    public void process() {
        int c = 0;
        calculateError();
        while (!(getError() < getErrorTorelance())) {
            System.out.println("\nError (Lap " + (c) + "): " + getError());
            System.out.println("Beta 0: " + getBeta_0());
            System.out.println("Beta 1: " + getBeta_1());
            setBeta_0(getBeta_0() - getLearningRate() * getPartialDerivateB0());
            setBeta_1(getBeta_1() - getLearningRate() * getPartialDerivateB1());
            setPartialDerivateB0();
            setPartialDerivateB1();
            calculateError();
            c++;
        }
    }
}