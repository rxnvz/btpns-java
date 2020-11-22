public class CommandLine {
   public static void main(String[] args) { 
      // System.out.println("args[" + i + "]: " +  args[i]);
      if (args[0].equalsIgnoreCase("1")) { //Hitung Luas Persegi
         System.out.println("Luas persegi: " + luasBangun(Integer.parseInt(args[1])));
      } else if (args[0].equalsIgnoreCase("2")) { //Hitung Luas Lingkaran
         System.out.println("Luas lingkaran: " + luasBangun(Double.parseDouble(args[1])));
      } else if (args[0].equalsIgnoreCase("3")) { //Hitung Luas Segitiga
         System.out.println("Luas segitiga: " + luasBangun(Float.parseFloat(args[1]), Float.parseFloat(args[2])));
      } else if (args[0].equalsIgnoreCase("4")) { //Hitung umur
         System.out.println("Umurnya: " + umur(Integer.parseInt(args[3])));
      }
   }

   //Luas segitiga
   public static float luasBangun(float alas, float tinggi) {
      float luas;
      luas = (alas * tinggi)/2;
      return luas;
   }
   //Luas persegi
   public static int  luasBangun(int sisi) {
      int luas;
      luas = sisi * sisi;
      return luas;
   }
   //Luas lingkaran
   public static double luasBangun(double jari) {
      double luas;
      luas = 3.14 * jari * jari;
      return luas;
   }
   //Umurnya
   public static int umur(int tahun) {
      int umur;
      umur = 2020 - tahun;
      return umur;
   }
}
