public class SortSearch {
    public static void main(String[] args) {
        int[] arr = {21, 23, 26, 12, 15}; //define array masukkannya

        printData(arr); //untuk memanggil fungsi print untuk array aslinya
        sorting(arr); //untuk memanggil fungsi sort 
        searching(arr); //untuk memanggil fungsi searching dari array yang sudah diurutkan sebelumnya
    }

    public static void printData(int[] a) {
        System.out.print("Array masukkannya: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", "); //print data input
        }
    }

    public static void sorting(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j + 1] < a[j]) { //kalo, data yang sekarang (idx j) lebih besar dari setelahnya (idx j+1)
                    int temp = a[j]; //variable sementara buat nyimpen data yang sekarang (idx j) soalnya mau dipindahin
                    a[j] = a[j + 1]; //data yang sekarang (idx j) diisi sama data dari index selanjutnya (idx j+1)
                    a[j + 1] = temp; //data index selanjutnya (idx j+1) diisi sama data dari index sekarang (idx j)
                }
            }
        }

        System.out.print("\nSetelah diurutkan: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    public static void searching(int[] a) {
        int target = 23; // inisialisasi data yang ingin dicari
        int left = 0; //inisialisasi titik awal
        int middle; // deklarasi titik tengah
        int right = a.length - 1; //inisialisasi titik akhir 
        while (left <= right) { //kalo, data di titik awal lebih kecil atau sama dengan titik akhir
            middle = (left + right) / 2; //inisialisasi titik tengah
            if (a[middle] == target) { //kalo, titik tengah sama dengan data yang dicari
                System.out.println("\nHasil searching: " + target + " found at index " + middle); //print
                break; //ini kalo, takutnya, data yang dicari double, jadi yang di print yang pertama ketemu aja
            } else if (a[middle] < target) { //kalo, data di titik tengah kurang dari data target
                left = middle + 1; //titik awal = titik tengah + 1
            } else if (a[middle] > target) { // kalo, data di titik tengah lebih dari data target
                right = middle - 1; //titik akhir = titik tengah - 1
            }
        }
    }
}
