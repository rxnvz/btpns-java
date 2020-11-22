import java.io.FileOutputStream;  
public class FileOutputStreamExample {  
    public static void main(String args[]){    
           try{    
             FileOutputStream fout=new FileOutputStream("test.txt");   
             fout.write(73);
             fout.write(114);
             fout.write(101);
             fout.write(110);
             fout.write(101);
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
      }    
}  

