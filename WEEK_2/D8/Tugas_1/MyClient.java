import java.io.*;  
import java.net.*;  
import java.util.*;

public class MyClient {  
    public static void main(String[] args) { 
        Properties prop = new Properties();
        InputStream input = null;
        String file = args[0];
        
        String strClient = "";
        String strServer = "";
        try {
            input = new FileInputStream(file);
            prop.load(input);

            String ip = prop.getProperty("ip");
            int port = Integer.parseInt(prop.getProperty("port"));

            Socket s = new Socket(ip, port);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r); 

            while (!strClient.equalsIgnoreCase("exit")) {
                System.out.print("Me: ");
                strClient = br.readLine();
                dout.writeUTF(strClient);
                dout.flush();

                if (strClient.equalsIgnoreCase("exit")) {
                    br.close();
                    r.close();
                    dout.close();  
                    s.close();  
                    input.close();
                } else {            
                    strServer = dis.readUTF();  
                    System.out.println("Server: " + strServer);
                }

            }
        } catch(Exception e) {
            System.out.println(e);
        }  
    }  
}  

