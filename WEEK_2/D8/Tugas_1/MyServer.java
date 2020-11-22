import java.io.*;
import java.util.*;
import java.net.*;  

public class MyServer {  
    public static void main(String[] args){  
        Properties prop = new Properties();
        InputStream input = null;
        String file = args[0];
        
        String strClient = "";
        String strServer = "";

        try {  
            input = new FileInputStream(file);
            prop.load(input);

            int port = Integer.parseInt(prop.getProperty("port"));

            ServerSocket ss = new ServerSocket(port);  
            Socket s = ss.accept();//establishes connection 

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            
            while (!strClient.equalsIgnoreCase("exit")) {
                strClient = dis.readUTF();  
                System.out.println("Client: " + strClient);

                if (strClient.equalsIgnoreCase("exit")) {
                    br.close();
                    r.close();
                    dout.close();
                    ss.close();  
                    input.close();
                } else {
                    System.out.print("Me: ");
                    strServer = br.readLine();
                    dout.writeUTF(strServer); 
                    dout.flush();                
                }
            }

        } catch(Exception e) {
            System.out.println(e);
        }  
    }  
}  

