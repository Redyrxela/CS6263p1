
import java.io.*;
import java.net.*;

class udpClient
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //create new client socket
        DatagramSocket clientSocket = new DatagramSocket();
        String IPA;
        //get Ip address (no verification... add later)
        System.out.println("Please enter an IP address (v4): ");
        IPA = input.readLine();

        InetAddress ipAddress = InetAddress.getByName(IPA);
        //send and recieve data

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        //get a string from the user
        System.out.println("Please enter a message in lowercase: ");
        String inputMsg = input.readLine();
        System.out.println("Sending: "+ inputMsg);
        //put string into byte format
        sendData = inputMsg.getBytes();

        //create a new packet
        DatagramPacket packet = new DatagramPacket(sendData, sendData.length, ipAddress, 5555);
        //send new packet
        clientSocket.send(packet);
        //create a recieve packet type
        DatagramPacket rPacket = new DatagramPacket(receiveData, receiveData.length);
        //recieve a new packet from network
        clientSocket.receive(rPacket);
        //convert back to string from bytes
        String serverMsg = new String(rPacket.getData());
        //show the user what the packet says
        System.out.println("Server: " + serverMsg);

        //close the socket
        clientSocket.close();
    }
}
