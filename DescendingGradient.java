public class DescendingGradient {
    // Private Variables
    private double beta_0;
    private double beta_1;
    private double[] setX;
    private double[] setY;
    private double sumX;
    private double sumY;
    private int n;
    private float partialDerivateB0;
    private float partialDerivateB1;
    
    // Constructor
    DescendingGradient(double[] _setX, double[] _setY){
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
    public double[] getSetX() {
        return this.setX;
    }
    public double[] getSetY() {
        return this.setY;
    }
    public double getSumX() {
        return this.sumX;
    }
    public double getSumY() {
        return this.sumY;
    }
    public int getN() {
        return this.n;
    }
    public float getPartialDerivateB0() {
        return this.partialDerivateB0;
    }
    public float getPartialDerivateB1() {
        return this.partialDerivateB1;
    }

    // Setters
    public void setSumX(double [] _sumX){
        double aux = 0;
        for (int i = 0; i < _sumX.length; i++) {
            aux = aux + _sumX[i];
        }
        this.sumX = aux;
    }
    public void setSumY(double [] _sumY){
        double aux = 0;
        for (int i = 0; i < _sumY.length; i++) {
            aux = aux + _sumY[i];
        }
        this.sumY = aux;
    }
    public void setN(int _n) {
        this.n = _n;
    }
    public void setPartialDerivateB0(){
        float aux = 0;
        aux = (float) ((-2/this.n)*(this.sumY-(this.beta_0+(this.beta_1*this.sumX))));
        this.partialDerivateB0 = aux;
    }
    public void setPartialDerivateB1(){
        float aux = 0;
        aux = (float) (((-2/this.n)*(this.sumX))*(this.sumY-(this.beta_0+(this.beta_1*this.sumX))));
        this.partialDerivateB1 = aux;
    }
}