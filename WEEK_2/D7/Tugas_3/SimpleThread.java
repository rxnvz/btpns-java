import java.util.*;
import java.io.*;

public class SimpleThread extends Thread {
    String file;

    public SimpleThread(String b) {

        file = b;
    }

    public void run() {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader brf = new BufferedReader(fr);

            String line ="";
            while ((line=brf.readLine())!=null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {
                    System.out.println(data[i]);
                }
            }
            System.out.print("Ketik menu yang ingin dilakukan: ");
        } catch (Exception e) {
            System.out.println("ERROR!: " + e);
        }
    }
}
