import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class SLR_Agent extends Agent {
    // Private Variables
    private String[] _setX;
    private String[] _setY;
    private int beta_0;
    private int beta_1;
    private String _y;
    private int[] x;
    private int[] y;
    private int Xi = 0;
    private int Yi = 0;
    private int n;
    private int beta_0_p;
    private int beta_1_p;
    private String y_p;

    /*
     * public SLR_Agent(int[] _setX, int[] _setY) {
     * this.x = _setX;
     * this.y = _setY;
     * for (int i = 0; i < _setX.length; i++) {
     * this.Xi = this.Xi + _setX[i];
     * }
     * for (int i = 0; i < _setY.length; i++) {
     * this.Yi = this.Yi + _setY[i];
     * }
     * n = _setX.length;
     * calculateBeta_0();
     * calculateBeta_1();
     * setY(getFormula());
     * }
     */

    // Getters
    public String[] getSetXS() {
        return this._setX;
    }

    public String[] getSetYS() {
        return this._setY;
    }

    public int getBeta_0() {
        return beta_0;
    }

    public int getBeta_1() {
        return beta_1;
    }

    public String getY() {
        return _y;
    }

    public void getSetX() {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
        }
    }

    public void getSetY() {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
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

    public int getBeta_0_p() {
        return beta_0_p;
    }

    public int getBeta_1_p() {
        return beta_1_p;
    }

    public String getY_p() {
        return y_p;
    }

    // Setters
    public void setSetX(String[] a) {
        this._setX = a;
    }

    public void setSetY(String[] a) {
        this._setY = a;
    }

    public void setX(int i, int _x) {
        try {
            this.x[i] = Integer.valueOf(_x);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void setY(int i, int _y) {
        try {
            this.y[i] = Integer.valueOf(_y);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void setBeta_0(int _beta_0) {
        this.beta_0 = _beta_0;
    }

    public void setBeta_1(int _beta_1) {
        this.beta_1 = _beta_1;
    }

    /*
     * public void setSetX(int[] _x) {
     * this.x = _x;
     * }
     * 
     * public void setSetY(int[] _y) {
     * this.y = _y;
     * }
     */

    public void setXi(int _Xi) {
        this.Xi = _Xi;
    }

    public void setYi(int _Yi) {
        this.Yi = _Yi;
    }

    public void setN(int _n) {
        this.n = _n;
    }

    public void setY(String _y) {
        this._y = _y;
    }

    public void setBeta_0_p(int beta_0_p) {
        this.beta_0_p = beta_0_p;
    }

    public void setBeta_1_p(int beta_1_p) {
        this.beta_1_p = beta_1_p;
    }

    public void setY_p(String y_p) {
        this.y_p = y_p;
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

    public int calculateBeta_0(int _n) { // Predict
        int aux = 0;
        int numerator = 0;
        int denominator = 0;
        numerator = Yi - (getBeta_1_p() * Xi);
        denominator = _n;
        aux = numerator / denominator;
        setBeta_0_p(aux);
        return aux;
    }

    // Calculate beta_1
    public int calculateBeta_1() {
        int aux = 0;
        int numerator = 0;
        int denominator = 0;
        numerator = (n * Xi * Yi) - (Xi * Yi);
        denominator = (n * Xi * Xi) - (Xi * Xi);
        aux = numerator / denominator;
        setBeta_1(aux);
        return aux;
    }

    public int calculateBeta_1(int _n) { // Predict
        int aux = 0;
        int numerator = 0;
        int denominator = 0;
        numerator = (_n * Xi * Yi) - (Xi * Yi);
        denominator = (_n * Xi * Xi) - (Xi * Xi);
        aux = numerator / denominator;
        setBeta_1_p(aux);
        return aux;
    }

    // Set and Get ?? Formula
    public String getFormula() {
        this._y = "?? = " + beta_0 + " + " + beta_1 + "x + ??";
        return this._y;
    }

    public String getFormulaP() {
        return "?? = " + beta_0_p + " + " + beta_1_p + "x + ??";
    }

    public void predecir(int _n) {
        beta_0_p = calculateBeta_0(_n);
        beta_1_p = calculateBeta_1(_n);
        y_p = getFormulaP();
    }

    // Main Agent Method
    public void setup() {
        System.out.println("Hi, i'm the SLR_Agent");
        addBehaviour(new RecieveDataSetX());
        addBehaviour(new RecieveDataSetY());
        /* System.out.println(getBeta_0());
        System.out.println(getBeta_1());
        System.out.println(getFormula()); */
    }

    // Recibir DataSet X
    private class RecieveDataSetX extends SimpleBehaviour {
        private boolean fin = false;

        public void action() {
            ACLMessage mensaje = receive();
            if (mensaje != null) {
                System.out.println(getLocalName() + ": acaba de recibir un dataset x[]: ");
                System.out.println(mensaje.toString());
                System.out.println("Splited SetX: ");
                System.out.println(mensaje.getContent());
                String[] aux = mensaje.getContent().split(" ");
                setSetX(aux);
                int i = 0;
                for (String a : aux) {
                    if (a != "" && a != null) {
                        try {
                            setX(i, Integer.valueOf(a));
                            System.out.println("-" + Integer.valueOf(a));
                            i++;
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                }

                fin = true;
            }

        }

        public boolean done() {
            return fin;
        }
    }

    // Recibir DataSet Y
    private class RecieveDataSetY extends SimpleBehaviour {
        private boolean fin = false;

        public void action() {
            ACLMessage mensaje = receive();
            if (mensaje != null) {
                System.out.println(getLocalName() + ": acaba de recibir un dataset y[]: ");
                System.out.println(mensaje.toString());
                System.out.println("Splited SetY: ");
                System.out.println(mensaje.getContent());
                String[] aux = mensaje.getContent().split(" ");
                setSetY(aux);
                int i = 0;
                for (String a : aux) {
                    if (a != "" && a != null) {
                        try {
                            setY(i, Integer.valueOf(a));
                            System.out.println("-" + Integer.valueOf(a));
                            i++;
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                }

                fin = true;
            }
        }

        public boolean done() {
            return fin;
        }
    }
}
