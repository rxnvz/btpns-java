import java.util.*;
import java.io.*;

public class ThreadPool implements Runnable {
    String isi;

    public ThreadPool(String a) {
        isi = a;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Isi = " + isi);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
