import java.io.*;  
import java.net.*;  
import java.util.*;
import java.util.regex.Pattern;

public class ClientProgram {
    public static Properties prop = new Properties();
    public static InputStream input = null;
    public static String file;

    public static Socket s;
    public static DataInputStream dis;
    public static DataOutputStream dout;

    public static String unamef ="";
    public static String passwf ="";
    
    public static String uname = "";
    public static String passw = "";

    public static String key = "";

    public static String strClient = "";
    public static String strServer = "";
    public static void main(String[] args) { 
        file = args[0];
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            
            FileReader fru = new FileReader("usernameUSR.txt");
            FileReader frp = new FileReader("passwordUSR.txt");
            BufferedReader bru = new BufferedReader(fru);
            BufferedReader brp = new BufferedReader(frp);

            input = new FileInputStream(file);
            prop.load(input);
            String ip = prop.getProperty("ip");
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
                    while (!key.equalsIgnoreCase("4")) {
                        
                        System.out.println("Selamat datang!" +
                        "\n1. Konek ke Socket" +
                        "\n2. Kirim data ke server" +
                        "\n3. Tutup Socket" +
                        "\n4. Keluar" +
                        "\nSilahkan pilih menu:");
                        key = br.readLine();
                        
                        switch (key) {
                            case "1":
                                s = new Socket(ip, port);
                                break;
                            
                            case "2":
                                dis = new DataInputStream(s.getInputStream());
                                dout = new DataOutputStream(s.getOutputStream());

                                System.out.print("Masukkan nama file (beserta extensionnya): ");

                                strClient = br.readLine();
                                dout.writeUTF(strClient);
                                dout.flush();

                                strServer = dis.readUTF();  
                                System.out.println(strServer);
                                break;

                            case "3":
                                dout.close();  
                                s.close();
                                break;
                        
                            default:
                                System.out.println("Terima kasih sudah menggunakan program ini!");
                                br.close();
                                r.close();
                        }
                    }
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
