import java.io.*;
import java.net.*;

public class udpServer {

    public static void main(String args[]) throws Exception
    {
       //create a socket
       DatagramSocket Socket = new DatagramSocket(5555);

       //send and recieve data
       byte[] receiveData = new byte[1024];
       byte[] sendData = new byte[1024];
       //server constantly runs so loop forever
       while(true)
       {
           //create a recieved packet type
           DatagramPacket rPacket = new DatagramPacket(receiveData, receiveData.length);
           //read a packet from the socket
           Socket.receive(rPacket);
           //convert it to a string
           String message = new String( rPacket.getData());
           //output
           System.out.println("Client: " + message);
           //read ip address from the packet
           InetAddress ipAddress = rPacket.getAddress();
           //read the port from the packet
           int port = rPacket.getPort();
           //modify the recieved message
           String modifiedMsg = message.toUpperCase();
           //convert back to byte form
           sendData = modifiedMsg.getBytes();
           System.out.println("Sending: " + modifiedMsg);
           //create new packet using the correct IP and port
           DatagramPacket Packet = new DatagramPacket(sendData, sendData.length, ipAddress, port);
           //send the packet!
           Socket.send(Packet);
       }
    }

}
