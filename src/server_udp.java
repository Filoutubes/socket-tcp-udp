import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.net.DatagramPacket;

public class server_udp {
	
	public static void main (String[] args) throws IOException {
		final int port = 2000;
		final int taille = 256;
		
		//création de la socket serveur UDP
		DatagramSocket socket = new DatagramSocket(port);
		System.out.println("Serveur en écoute sur le port " + socket.getLocalPort());
		
		//création du buffer de réception
		byte[] buffer = new byte[taille];
		DatagramPacket packet = new DatagramPacket(buffer , buffer.length);
		
		//attente du paquet
		socket.receive(packet);
		
		//affichage des données reçues
		byte[] data = packet.getData();
		String str = new String(data , StandardCharsets.ISO_8859_1);
		System.out.println(str);
		
		//préparation du paquet réponse
		byte[] rep = "J'ai bien recu votre message".getBytes();
		DatagramPacket rep_serv = new DatagramPacket(rep , rep.length , packet.getAddress() , packet.getPort());
		
		//envoi de la réponse
		socket.send(rep_serv);
		
		//fermeture de la socket
		socket.close();
		
	}

}
