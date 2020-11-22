import java.io.*;

public class ReadWrite {
    public static void main(String[] args) {
        try{    
            FileOutputStream fout=new FileOutputStream(args[0]); //Ini buat ngebuat filenya/masup ke filenya (kalo uda ada)
            FileInputStream fin=new FileInputStream(args[0]); //Ini buat baca filenya

            //Buat masukin data args[1] ke file args[0]
            String s= args[1];
            byte b[]=s.getBytes();//converting string into byte array    
            fout.write(b);    
            fout.close();    
            System.out.println("Data berhasil dibuat!");
            
            //Ini buat ngebaca yang ada didalem filenya
            int i=0;    
            while((i=fin.read())!=-1){    
             System.out.print((char)i);    
            }    
            fin.close();
          }catch(Exception e){System.out.println(e);}
    }
}
