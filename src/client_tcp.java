import java.net.Socket;
import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;
import java.net.InetAddress;
import java.util.Scanner;

public class client_tcp {
	
	public static void main(String[] args) throws IOException {
		InetAddress serveur = InetAddress.getByName("localhost"); 
		//c'est mon ip on aurait pu très bien mettre localhost ou 127.0.0.1 ...
		
		//Création de la socket client
		Socket socket_client = new Socket(serveur , 2000);
		Scanner sc = new Scanner(System.in);
		
		//Préparation et envoi du message au serveur
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket_client.getOutputStream()));
		System.out.println("Veuillez saisir votre message : ");
		String msg_send = sc.nextLine();
		out.write(msg_send + "\n");
		out.flush();
		
		//...
		
		//Attente de la réponse du serveur
		BufferedReader in = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
		String msg_recu = in.readLine();
		
		//Affichage de la réponse reçue
		System.out.println("Serveur : " + msg_recu);
		
		//Fermeture de la connexion
		socket_client.close();
		sc.close();
		
	}

}
