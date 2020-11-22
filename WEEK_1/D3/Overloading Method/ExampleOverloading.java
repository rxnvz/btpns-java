public class ExampleOverloading {

    public static void main(String[] args) {
      int a = 2;
      int b = 6;
      int c = 5;
      double e = 10;

      int luasSegitiga = luasBangun(a, b);
      int luasPersegi = luasBangun(c);
      double luasLingkaran = luasBangun(e);

      System.out.println("Luas segitiga: " + luasSegitiga);
      System.out.println("Luas persegi: " + luasPersegi);
      System.out.println("Luas lingkaran: " + luasLingkaran);
    }

   //Luas segitiga
   public static int luasBangun(int alas, int tinggi) {
      int luas;
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
}
