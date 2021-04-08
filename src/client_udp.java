import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Scanner;

public class client_udp {
	
	public static void main (String [] args) throws IOException {
		
		InetAddress serveur = InetAddress.getByName("localhost");	
		
		//Création de la socket client UDP
		DatagramSocket socket = new DatagramSocket();
			//Préparation du message à envoyer
			String message_a_envoye = "Ici Bahdon test test ?"; //Le message en type String
			byte [] msg_code = message_a_envoye.getBytes();//le String est converti en tableau de byte

			//Création du paquet
			DatagramPacket paquet = new DatagramPacket(msg_code, msg_code.length,serveur, 32592);

			//Envoi du message
			socket.send(paquet);

			//Attente de la réponse du serveur
			byte [] buffer = new byte [256];
			DatagramPacket msg_received = new DatagramPacket(buffer,buffer.length);
			//Lecture et affichage des données reçues

			System.out.println("Le client attend la réponse du serveur");
			socket.receive(msg_received);

			//Récupération des données et conversion en String
			//Affichage
			byte[] bytes = msg_received.getData();
			String str = new String(bytes, StandardCharsets.ISO_8859_1); 
			System.out.println(str);

			//Fermeture de la socket
			socket.close();
	}
}