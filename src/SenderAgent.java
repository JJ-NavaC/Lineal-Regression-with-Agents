import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class SenderAgent extends Agent {
    static int[] x = { 1, 2, 2, 3 };
    static int[] y = { 1, 2, 3, 6 };

    protected void setup() {
        System.out.println("Hi, i'm the Sender Agent");
        addBehaviour(new SendDataSetX());
    }

    private class SendDataSetX extends SimpleBehaviour {
        boolean fin = false;

        public void action() {
            String SetX = "";
            for (int i = 0; i < x.length; i++) {
                SetX = SetX + "," + String.valueOf(x[i]);
            }
            System.out.println(SetX);
            System.out.println(getLocalName() + " buscando receptor para mandar datasets");
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

}
