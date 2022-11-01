import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class DG_Agent extends Agent {
    private String[] setX;
    private String[] setY;
    private int[] x;
    private int[] y;

    // Getters
    public String[] getSetX() {
        return this.setX;
    }

    public String[] getSetY() {
        return this.setY;
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    // Setters
    public void setSetX(String[] _setX) {
        this.setX = _setX;
    }

    public void setSetY(String[] _setY) {
        this.setY = _setY;
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

    // Main Agent Method
    public void setup() {
        System.out.println("Hi, i'm the DG_Agent");
        addBehaviour(new RecieveDataSetX());
        addBehaviour(new RecieveDataSetY());        
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