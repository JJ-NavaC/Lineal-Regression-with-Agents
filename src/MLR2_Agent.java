import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class MLR2_Agent extends Agent {
    private String[] setX1;
    private String[] setX2;
    private String[] setY;
    private double[] x1;
    private double[] x2;
    private double[] y;

    // Getters
    public String[] getSetX1() {
        return this.setX1;
    }

    public String[] getSetX2() {
        return this.setX2;
    }

    public String[] getSetY() {
        return this.setY;
    }

    public double[] getX1() {
        return this.x1;
    }

    public double[] getX2() {
        return this.x2;
    }

    public double[] getY() {
        return this.y;
    }

    // Setters
    public void setSetX1(String[] _setX1) {
        this.setX1 = _setX1;
    }

    public void setSetX2(String[] _setX2) {
        this.setX2 = _setX2;
    }

    public void setSetY(String[] _setY) {
        this.setY = _setY;
    }

    public void setX1(int i, double _x1) {
        try {
            this.x1[i] = Double.valueOf(_x1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void setX2(int i, double _x2) {
        try {
            this.x1[i] = Double.valueOf(_x2);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void setY(int i, double _y) {
        try {
            this.y[i] = Double.valueOf(_y);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Main Agent Method
    public void setup() {
        System.out.println("Hi, i'm the MLR2_Agent");        
        addBehaviour(new RecieveDataSetX1());
        addBehaviour(new RecieveDataSetX2());
        addBehaviour(new RecieveDataSetY());
    }

    // Recibir DataSet X1
    private class RecieveDataSetX1 extends SimpleBehaviour {
        private boolean fin = false;

        public void action() {
            ACLMessage mensaje = receive();
            if (mensaje != null) {
                System.out.println(getLocalName() + ": acaba de recibir un dataset x[]: ");
                System.out.println(mensaje.toString());
                System.out.println("Splited SetX1: ");
                System.out.println(mensaje.getContent());
                String[] aux = mensaje.getContent().split(" ");
                setSetX1(aux);
                int i = 0;
                for (String a : aux) {
                    if (a != "" && a != null) {
                        try {
                            setX1(i, Double.valueOf(a));
                            System.out.println("-" + Double.valueOf(a));
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

    // Recibir DataSet X2
    private class RecieveDataSetX2 extends SimpleBehaviour {
        private boolean fin = false;

        public void action() {
            ACLMessage mensaje = receive();
            if (mensaje != null) {
                System.out.println(getLocalName() + ": acaba de recibir un dataset x[]: ");
                System.out.println(mensaje.toString());
                System.out.println("Splited SetX2: ");
                System.out.println(mensaje.getContent());
                String[] aux = mensaje.getContent().split(" ");
                setSetX2(aux);
                int i = 0;
                for (String a : aux) {
                    if (a != "" && a != null) {
                        try {
                            setX2(i, Double.valueOf(a));
                            System.out.println("-" + Double.valueOf(a));
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