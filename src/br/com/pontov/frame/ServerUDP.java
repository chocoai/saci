package br.com.pontov.frame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP extends Thread {


	public void run()  {
		// cria socket
				DatagramSocket serverSocket;
				try {
					serverSocket = new DatagramSocket(9876);
			
				byte[] receiveData = new byte[1024]; // byte de recebimento
				byte[] sendData  = new byte[1024]; // byte de envio

				while(true) { 

					DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); // montando pacote de recebimento 

					//System.out.println ("Waiting for datagram packet...");

					serverSocket.receive(receivePacket); // socket espera o recebimento do pacote

					String sentence = new String(receivePacket.getData()); // armazenamento do conetúdo do pacote da mensagem recebida

					InetAddress IPAddress = receivePacket.getAddress(); // obtendo o endereço IP do pacote da mensagem recebida

					int port = receivePacket.getPort(); // obtendo endereço da porta do pacote da mensagem

					String capitalizedSentence = sentence.toUpperCase(); // converte o conteúdo da mensagem para letras maiúsculas 

				
					System.out.println ("From: " + IPAddress + ":" + port);
					System.out.println ("Message: " + sentence);

					if (sentence == " MSG;1.0;1.0;1.0;1.0;1.0;#                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ")
					{
						System.out.println("Mensagem Chuablers");
					}
					else
					{
						System.out.println("SENTENCE"+sentence);
					}
					
					
					sendData = capitalizedSentence.getBytes(); // armazena a mensagem do usuário no byte de envio

					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); // montando pacote de envio

					serverSocket.send(sendPacket); // socket envia o pacote da mensagem
					
				} 
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	
}
