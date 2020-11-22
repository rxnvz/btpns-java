public class VolumeArray {
    public static void main(String[] args) {
        if (args[0].equalsIgnoreCase("1")) { //Hitung Volume Kubus
            System.out.println("Volume Kubus: " + volumeBangun(Integer.parseInt(args[1])));
         } else if (args[0].equalsIgnoreCase("2")) { //Hitung Volume Bola
            System.out.println("Volume Bola: " + volumeBangun(Double.parseDouble(args[1])));
         } else if (args[0].equalsIgnoreCase("3")) { //Bikin Array
            newArray(Integer.parseInt(args[1]));
         } else {
            System.out.println("Periksa kembali input yang anda berikan!");
         }
    }

    //Volume Kubus
    public static int  volumeBangun(int sisi) {
        int volume;
        volume = sisi * sisi * sisi;
        return volume;
    }
    //Volume bola
    public static double volumeBangun(double jari) {
        double volume;
        volume = (4 * 3.14 * jari * jari)/3;
        return volume;
    }
    //Print Array
    public static void newArray(int x) {
        if (x == 2) {
            String[][] arr = {
                {"satu", "dua", "tiga", "empat"},
                {"lima", "enam"}
            };
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } else if (x == 3) {
            String[][] arr = {
                {"satu", "dua", "tiga", "empat"},
                {"lima", "enam"},
                {"tujuh", "delapan", "sembilan"}
            };
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
