import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServer {
    public static void main(String argv[]) throws Exception
    {
        //create new socket
        ServerSocket Socket = new ServerSocket(6666);

        while(true) //servers run loop forever
        {
            //accept new connections to the socket

            Socket connectionSocket = Socket.accept();
            //create streams
            BufferedReader receive = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream send = new DataOutputStream(connectionSocket.getOutputStream());
            //get a new message from the socket
            String message = receive.readLine();
            System.out.println("Client: " + message);
            //modify the sentence
            String modifiedMsg = message.toUpperCase() + '\n';
            //send modified message back
            System.out.println("Sending: " + modifiedMsg);
            send.writeBytes(modifiedMsg);
        }
    }
}
