import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class SLR_Agent extends Agent {
    protected void setup() {
        System.out.println("Hi, i'm the SLR_Agent");
        addBehaviour(new RecieveDataSetX());
    }

    private class RecieveDataSetX extends SimpleBehaviour {
        private boolean fin = false;

        public void action() {
            ACLMessage mensaje = receive();
            if (mensaje != null) {
                System.out.println(getLocalName() + ": acaba de recibir un dataset x[]: ");
                System.out.println(mensaje.toString());
                System.out.println("Splited SetX: ");
                String[] aux = mensaje.getContent().split(",");               
                for (String string : aux) {
                    System.out.println(string);                             
                }

                fin = true;
            }

        }

        public boolean done() {
            return fin;
        }
    }
}
