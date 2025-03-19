public class ProgramMain {
    public static void main(String[] args) {
        // Implementasi Linear Probing disini
        LinearProb<Integer, String> linearHash = new LinearProb<>(10);

        // Data yang kita punya
        int[] data = {4371, 1323, 6173, 4199, 4344, 9679, 1989};

        // Input data yang kita punya ke table hashnya
        for (int key : data) {
            linearHash.put(key, Integer.toString(key));
        }

        // Show hasil dari tabel hash
        System.out.println("\nLinear Probing Hash Table:");
        linearHash.Displaytabelhash();
        System.out.println();

        // Implementasi Quadratic Probing
        QuadProb<Integer, String> quadraticHash = new QuadProb<>(10);
        for (int key : data) {
            quadraticHash.put(key, Integer.toString(key));
        }

        // show hasil dari tabel hash
        System.out.println("\nQuadratic Probing Hash Table:");
        quadraticHash.Displaytabelhash();
        System.out.println();

        // Implementasi Separate Chaining
        Chain<Integer, String> chainingHash = new Chain<>(10);
        for (int key : data) {
            chainingHash.put(key, Integer.toString(key));
        }

        // Show hasil dari tabel hash
        System.out.println("\nSeparate Chaining Hash Table:");
        chainingHash.Displaytabelhash();
        System.out.println();
    }
}
