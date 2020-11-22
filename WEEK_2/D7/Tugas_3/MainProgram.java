import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class MainProgram {
    public static void main(String[] args) throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        String file = args[0];
        int thd = Integer.parseInt(args[1]);
        
        String key = "";
        
        System.out.println("Selamat datang!" +
                            "\n1. Print ke layar" +
                            "\n2. Print ThreadPool" +
                            "\n3. Print ke layar + file asc&desc" +
                            "\n4. Keluar" +
                            "\nSilahkan pilih menu:");
        while(!key.equals("4")) {
            key = br.readLine();
            switch (key) {
                case "1": //done
                    SimpleThread t1 = new SimpleThread(file);
                    t1.start();
                    break;

                case "2": //done
                    ExecutorService executor = Executors.newFixedThreadPool(thd);

                    FileReader fr = new FileReader("data.txt");
                    BufferedReader brf = new BufferedReader(fr);

                    String line ="";
                    while ((line=brf.readLine())!=null) {
                        String[] isi = line.split(",");
                        for (int i = 0; i < isi.length; i++) {
                            Runnable worker = new ThreadPool("" + isi[i]);
                            executor.execute(worker);
                        }
                    }
                    executor.shutdown();
                    while (!executor.isTerminated()) {}
                    System.out.print("Ketik menu yang ingin dilakukan: ");
            
                    break;

                case "3":
                    SimpleThread st = new SimpleThread(file);
                    st.start();
                    PrintAsc pa = new PrintAsc(file);
                    pa.start();
                    PrintDesc pd = new PrintDesc(file);
                    pd.start();
                    break;
            
                default:
                    System.out.println("Terima kasih sudah menggunakan program ini!");
                    br.close();
                    r.close();
                    break;
            }
        }
    }
}
