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

    private double beta_0_p = 0;
    private double beta_1_p = 0;
    private double error_p;
    private double partialDerivateB0_p;
    private double partialDerivateB1_p;

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
        return this.learningRate;
    }

    public double getError() {
        return this.error;
    }

    public double getErrorTorelance() {
        return this.errorTolerance;
    }

    public double getBeta_0_p() {
        return this.beta_0_p;
    }

    public double getBeta_1_p() {
        return this.beta_1_p;
    }

    public double getError_p() {
        return this.error_p;
    }

    public double getPartialDerivateB0_p() {
        return this.partialDerivateB0_p;
    }

    public double getPartialDerivateB1_p() {
        return this.partialDerivateB1_p;
    }

    public double getErrorTolerance() {
        return this.errorTolerance;
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

    // Predict Methods

    public void setBeta_0_p(double _beta_0_p) {
        this.beta_0_p = _beta_0_p;
    }

    public void setBeta_1_p(double _beta_1_p) {
        this.beta_1_p = _beta_1_p;
    }

    public void setError_p(double _error_p) {
        this.error_p = _error_p;
    }

    public void setPartialDerivateB0_p(int _n) {
        double aux = 0;
        aux = (double) ((-2) / _n) * (getSumY() - (getBeta_0_p() + (getBeta_1_p() * getSumX())));
        this.partialDerivateB0_p = (double) aux;
    }

    public void setPartialDerivateB1_p(int _n) {
        double aux = 0;
        aux = (double) (((-2 / _n) * (getSumX())) * (getSumY() - (getBeta_0_p() + (getBeta_1_p() * getSumX()))));
        this.partialDerivateB1_p = (double) aux;
    }

    public void calculateError_p(int _n) {
        double aux = (double) (1 / _n) * Math.pow((getSumY() - (getBeta_0_p() + (getBeta_1_p() * getSumX()))), 2);
        setError_p(aux);
    }

    public void process_p(int _n) {
        setPartialDerivateB0_p(_n);
        setPartialDerivateB1_p(_n);
        int c = 0;
        calculateError_p(_n);
        System.out.println("ErrorP: " + getError_p());
        while (!(getError_p() < getErrorTorelance())) {
            System.out.println("\nError (Lap " + (c) + "): " + getError_p());
            System.out.println("Beta 0_p: " + getBeta_0_p());
            System.out.println("Beta 1_p: " + getBeta_1_p());
            setBeta_0_p(getBeta_0_p() - getLearningRate() * getPartialDerivateB0_p());
            setBeta_1_p(getBeta_1_p() - getLearningRate() * getPartialDerivateB1_p());
            setPartialDerivateB0_p(_n);
            setPartialDerivateB1_p(_n);
            calculateError_p(_n);
            c++;
        }
    }
}