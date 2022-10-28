import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteReceptor extends Agent {

    protected void setup() {
        addBehaviour(new ReceptorComportaminento());
    }

    private class ReceptorComportaminento extends SimpleBehaviour {
        private boolean fin = false;

        public void action() {
            // Obtiene el primer mensaje de la cola de mensajes
            ACLMessage mensaje = receive();

            if (mensaje != null) {
                System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                System.out.println(mensaje.toString());
                fin = true;
            }
        }

        public boolean done() {
            return fin;
        }
    }
}
