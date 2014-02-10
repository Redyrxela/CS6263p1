import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class tcpClient {
    public static void main(String argv[]) throws Exception
    {


        BufferedReader input = new BufferedReader( new InputStreamReader(System.in));

        //get Ip address (no verification... add later)
        System.out.println("Please enter an IP address (v4): ");
        String IPA = input.readLine();
        //create a socket with given ip address and port

        Socket clientSocket = new Socket(IPA, 6666);
        //network output stream
        DataOutputStream send = new DataOutputStream(clientSocket.getOutputStream());
        //network input stream
        BufferedReader receive = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //get a lowercase message from the user (no verification or anything)
        System.out.println("Please enter a message in lowercase: ");
        String message = input.readLine();
        //convert to bytes and write to stream
        System.out.println("Sending: " + message);
        send.writeBytes(message + '\n');
        //receive the message back from the server
        String modifiedMsg = receive.readLine();
        System.out.println("Server: " + modifiedMsg);
        //we are done here close the socket!
        clientSocket.close();
    }
}