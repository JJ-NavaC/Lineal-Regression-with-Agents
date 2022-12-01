public class DescendingGradient {
    // Private Variables
    private double beta_0 = 0;
    private double beta_1 = 0;
    private int[] setX;
    private int[] setY;
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

    // Setters
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
        double aux1 = 0;
        for (int i = 0; i < getN(); i++) {
            aux = aux + (setY[i] - (getBeta_0() + (getBeta_1() * setX[i])));
        }
        aux1 = (-2 / getN()) * aux;
        partialDerivateB0 = aux1;
    }

    public void setPartialDerivateB1() {
        double aux = 0;
        double aux1 = 0;
        for (int i = 0; i < getN(); i++) {
            aux = aux + ((setX[i]) * (setY[i] - (getBeta_0() + (getBeta_1() * setX[i]))));
        }
        aux1 = (-2 / getN()) * aux;
        partialDerivateB1 = aux1;
    }

    public void calculateError() {
        double aux = 0;
        double aux1 = 0;
        for (int i = 0; i < getN(); i++) {
            aux = aux + ((setY[i] - (getBeta_0() + (getBeta_1() * setX[i]))));
        }
        aux1 = (1 / getN()) * (aux*aux);
        setError(aux1);
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