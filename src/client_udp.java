import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Scanner;

public class client_udp {
	
	public static void main (String [] args) throws IOException {
		
		InetAddress serveur = InetAddress.getByName("localhost");	
		
		//Cr�ation de la socket client UDP
		DatagramSocket socket = new DatagramSocket();
			//Pr�paration du message � envoyer
			String message_a_envoye = "Ici Bahdon test test ?"; //Le message en type String
			byte [] msg_code = message_a_envoye.getBytes();//le String est converti en tableau de byte

			//Cr�ation du paquet
			DatagramPacket paquet = new DatagramPacket(msg_code, msg_code.length,serveur, 32592);

			//Envoi du message
			socket.send(paquet);

			//Attente de la r�ponse du serveur
			byte [] buffer = new byte [256];
			DatagramPacket msg_received = new DatagramPacket(buffer,buffer.length);
			//Lecture et affichage des donn�es re�ues

			System.out.println("Le client attend la r�ponse du serveur");
			socket.receive(msg_received);

			//R�cup�ration des donn�es et conversion en String
			//Affichage
			byte[] bytes = msg_received.getData();
			String str = new String(bytes, StandardCharsets.ISO_8859_1); 
			System.out.println(str);

			//Fermeture de la socket
			socket.close();
	}
}