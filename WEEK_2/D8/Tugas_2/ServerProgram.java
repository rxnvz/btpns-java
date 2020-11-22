import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.net.*;  

public class ServerProgram {
    public static void main(String[] args){ 
        Properties prop = new Properties();
        InputStream input = null;
        String file = args[0];

        String unamef ="";
        String passwf ="";
        
        String uname = "";
        String passw = "";

        String strClient = "";
        
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            
            FileReader fru = new FileReader("usernameADM.txt");
            FileReader frp = new FileReader("passwordADM.txt");
            BufferedReader bru = new BufferedReader(fru);
            BufferedReader brp = new BufferedReader(frp);

            input = new FileInputStream(file);
            prop.load(input);
            int port = Integer.parseInt(prop.getProperty("port"));

            int i;
            int j;
            while ((i=bru.read())!=-1) {
                unamef += (char)i;
            }
            bru.close();    
            fru.close(); 

            while ((j=brp.read())!=-1) {
                passwf += (char)j;
            }
            brp.close();    
            frp.close();

            System.out.print("Masukkan username: ");
            uname = br.readLine();
            System.out.print("Masukkan password: ");
            passw = br.readLine();

            if (Pattern.matches("\\w*@gmail.com", uname) && Pattern.matches("\\w{8,20}+", passw)) {
                if (uname.equals(unamef) && passw.equals(passwf)) {
                    ServerSocket ss = new ServerSocket(port);  
                    Socket s = ss.accept();

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                    strClient = (String)dis.readUTF();

                    FileReader frf = new FileReader(strClient);
                    BufferedReader brf = new BufferedReader(frf);

                    int k;
                    String data = "";

                    while ((k=brf.read())!=-1) {
                        data += (char)k;
                    }
                    brf.close();    
                    frf.close();

                    String[] isi = data.split("\\n");
                    for (String string : isi) {
                        String[] datanya = string.split(",");
                        for (int l = 0; l < datanya.length; l++) {
                            if (l == 0) {
                                System.out.println("Nama: " + datanya[l]);
                            } else if (l == 1) {
                                System.out.println("Nilai Fisika: " + datanya[l]);
                            } else if (l == 2) {
                                System.out.println("Nilai Biologi: " + datanya[l]);
                            } else if (l == 3){
                                System.out.println("Nilai Kimia: " + datanya[l] + "\n");
                            }
                        }
                    }

                    dout.writeUTF("\nData Done Processing.\n\n");
                    ss.close();
                } else {
                    System.out.println("Email dan password tidak sesuai!");
                }
            } else {
                System.out.println("Gunakan format email dan password yang benar!");
            }
        } catch (Exception e) {
            System.out.println("ERROR! " + e);
        }
    }
}
