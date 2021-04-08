import java.net.Socket;
import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

public class server_tcp {

	public static void main (String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		//Cr�ation de la socket du serveur
		ServerSocket socket_serv = new ServerSocket(2000);

		//Ecoute sur un port et l'attente d'un paquet
		System.out.println("Serveur en �coute sur le port " + socket_serv.getLocalPort() + "." );

		Socket clientSocket = socket_serv.accept();

		//Reception des donn�es re�ues
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String msg_recu = in.readLine();
		System.out.println("Client : " + msg_recu); // affichage du message envoy� par le client

		//Cr�ation de la r�ponse
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		System.out.println("Veuillez saisir votre message : ");
		String msg_send = sc.nextLine();

		out.write(msg_send +"\n");
		out.flush();

		//Fermeture des sockets
		socket_serv.close();
		sc.close();
	}
	
	public static void pause(int ms) {
	    try {
	        Thread.sleep(ms);
	    } catch (InterruptedException e) {
	        System.err.format("IOException: %s%n", e);
	    }
	}

}
