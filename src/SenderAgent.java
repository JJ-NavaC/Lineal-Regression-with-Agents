import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class SenderAgent extends Agent {
    static int[] x = { 1, 2, 2, 3 };
    static int[] y = { 1, 2, 3, 6 };
    static double[] x1 = { 41.9, 43.4, 43.9, 44.5, 47.3, 47.5, 47.9, 50.2, 52.8,
            53.2, 56.7, 57.0, 63.5, 65.3, 71.1,
            77.0, 77.8 };
    static double[] x2 = { 29.1, 29.3, 29.5, 29.7, 29.9, 30.3, 30.5, 30.7, 30.8,
            30.9, 31.5, 31.7, 31.9, 32.0, 32.1,
            32.5, 32.9 };
    static double[] _y = { 251.3, 251.3, 248.3, 267.5, 273.0, 276.5, 270.3, 274.9,
            285.0, 290.0, 297.0, 302.5, 304.5,
            309.3, 321.7, 330.7, 349.0 };

    protected void setup() {
        System.out.println("Hi, i'm the Sender Agent");
        System.out.println("Sending DataSets to SLR_Agent...");
        addBehaviour(new SendDataSetX());
        addBehaviour(new SendDataSetY());
        System.out.println("Sending DataSets to DG_Agent...");
        addBehaviour(new SendDataSetX_1());
        addBehaviour(new SendDataSetY_1());
        System.out.println("Sending DataSets to MLR1_Agent...");
        addBehaviour(new SendDataSetX1_2());
        addBehaviour(new SendDataSetX2_2());
        addBehaviour(new SendDataSetY_2());
        System.out.println("Sending DataSets to MLR2_Agent...");
        addBehaviour(new SendDataSetX1_3());
        addBehaviour(new SendDataSetX2_3());
        addBehaviour(new SendDataSetY_3());
    }

    // Sending DataSet X to SLR_Agent
    private class SendDataSetX extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetX = "";
            for (int i = 0; i < x.length; i++) {
                SetX = SetX + " " + String.valueOf(x[i]);
            }
            System.out.println(SetX);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset X");
            AID id = new AID();
            id.setLocalName("SLR_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetX);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }

    // Sending DataSet Y to SLR_Agent
    private class SendDataSetY extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetY = "";
            for (int i = 0; i < y.length; i++) {
                SetY = SetY + " " + String.valueOf(y[i]);
            }
            System.out.println(SetY);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset Y");
            AID id = new AID();
            id.setLocalName("SLR_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetY);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }

    // Sending DataSet X to DG_Agent
    private class SendDataSetX_1 extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetX = "";
            for (int i = 0; i < x.length; i++) {
                SetX = SetX + " " + String.valueOf(x[i]);
            }
            System.out.println(SetX);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset X");
            AID id = new AID();
            id.setLocalName("DG_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetX);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }

    // Sending DataSet Y to DG_Agent
    private class SendDataSetY_1 extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetY = "";
            for (int i = 0; i < y.length; i++) {
                SetY = SetY + " " + String.valueOf(y[i]);
            }
            System.out.println(SetY);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset Y");
            AID id = new AID();
            id.setLocalName("DG_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetY);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }

    // Sending DataSet X1 to MLR1_Agent
    private class SendDataSetX1_2 extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetX1 = "";
            for (int i = 0; i < x1.length; i++) {
                SetX1 = SetX1 + " " + String.valueOf(x1[i]);
            }
            System.out.println(SetX1);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset X1");
            AID id = new AID();
            id.setLocalName("MLR1_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetX1);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }

    // Sending DataSet X2 to MLR1_Agent
    private class SendDataSetX2_2 extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetX2 = "";
            for (int i = 0; i < x2.length; i++) {
                SetX2 = SetX2 + " " + String.valueOf(x2[i]);
            }
            System.out.println(SetX2);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset X2");
            AID id = new AID();
            id.setLocalName("MLR1_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetX2);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }

    // Sending DataSet Y to MLR1_Agent
    private class SendDataSetY_2 extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetY = "";
            for (int i = 0; i < _y.length; i++) {
                SetY = SetY + " " + String.valueOf(_y[i]);
            }
            System.out.println(SetY);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset X2");
            AID id = new AID();
            id.setLocalName("MLR1_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetY);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }

    // Sending DataSet X1 to MLR2_Agent
    private class SendDataSetX1_3 extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetX1 = "";
            for (int i = 0; i < x1.length; i++) {
                SetX1 = SetX1 + " " + String.valueOf(x1[i]);
            }
            System.out.println(SetX1);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset X1");
            AID id = new AID();
            id.setLocalName("MLR2_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetX1);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }

    // Sending DataSet X2 to MLR2_Agent
    private class SendDataSetX2_3 extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetX2 = "";
            for (int i = 0; i < x2.length; i++) {
                SetX2 = SetX2 + " " + String.valueOf(x2[i]);
            }
            System.out.println(SetX2);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset X2");
            AID id = new AID();
            id.setLocalName("MLR2_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetX2);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }

    // Sending DataSet Y to MLR2_Agent
    private class SendDataSetY_3 extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetY = "";
            for (int i = 0; i < _y.length; i++) {
                SetY = SetY + " " + String.valueOf(_y[i]);
            }
            System.out.println(SetY);
            System.out.println(getLocalName() + " buscando receptor para mandar dataset X2");
            AID id = new AID();
            id.setLocalName("MLR2_Agent");

            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);

            mensaje.setSender(getAID());
            mensaje.setLanguage("English");
            mensaje.addReceiver(id);
            mensaje.setContent(SetY);
            send(mensaje);
            fin = true;
            System.out.println(getLocalName() + ": ... What are you up to");
            System.out.println(mensaje.toString());
        }

        public boolean done() {
            return fin;
        }
    }
}
