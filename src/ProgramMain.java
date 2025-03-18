class Student {
    private int nim;
    private String nama;

    Student(int nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return Integer.toString(nim) + " - " + nama;
    }
}

public class ProgramMain {
    public static void main(String[] args) {
        // Contoh penggunaan Linear Probing
        LinearProb<Integer, String> linearHash = new LinearProb<>(10);

        // Data yang akan dimasukkan
        int[] data = {4371, 1323, 6173, 4199, 4344, 9679, 1989};

        // Memasukkan data ke dalam tabel hash
        for (int key : data) {
            linearHash.put(key, Integer.toString(key));
        }

        // Menampilkan hasil tabel hash
        System.out.println("Linear Probing Hash Table:");
        linearHash.displayHashTable();
        System.out.println();

        // Contoh penggunaan Quadratic Probing
        QuadProb<Integer, String> quadraticHash = new QuadProb<>(10);
        for (int key : data) {
            quadraticHash.put(key, Integer.toString(key));
        }

        // Menampilkan hasil tabel hash
        System.out.println("Quadratic Probing Hash Table:");
        quadraticHash.displayHashTable();
        System.out.println();

        // Contoh penggunaan Separate Chaining
        Chain<Integer, String> chainingHash = new Chain<>(10);
        for (int key : data) {
            chainingHash.put(key, Integer.toString(key));
        }

        // Menampilkan hasil tabel hash
        System.out.println("Separate Chaining Hash Table:");
        chainingHash.displayHashTable();
        System.out.println();
    }
}
