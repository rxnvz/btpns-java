import java.util.*;
import java.io.*;

public class PrintAsc extends Thread {
    String file;

    public PrintAsc(String a) {
        file = a;
    }

    public void run() {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader brf = new BufferedReader(fr);

            FileWriter wr = new FileWriter("fileDataAsc.txt");
            BufferedWriter brw = new BufferedWriter(wr);

            String line ="";
            while ((line=brf.readLine())!=null) {
                String[] data = line.split(",");
                Arrays.sort(data);
                for (int i = 0; i < data.length; i++) {
                    brw.write(data[i] + "\n");
                }
            }
            brw.close();
        } catch (Exception e) {
            System.out.println("ERROR!: " + e);
        }
    }
}
