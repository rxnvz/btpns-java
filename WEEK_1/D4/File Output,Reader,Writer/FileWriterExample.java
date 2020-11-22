import java.io.FileWriter;

public class FileWriterExample {  
    public static void main(String args[]){    
         try{    
           FileWriter fw=new FileWriter("testout3.txt"); //Cuma bisa nulis ke file, ngga bisa ke socket gtgt
           fw.write("Welcome to G2");    
           fw.close();    
          }catch(Exception e){System.out.println(e);}    
          System.out.println("Success...");    
     }    
} 

