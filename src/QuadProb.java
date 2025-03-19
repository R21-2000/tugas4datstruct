public class QuadProb<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")//biar ignore warning di line 8&9
    public QuadProb(int capacity) {//Inisialisasi tabel hashnya sesuai kapasitas yang kita pengen
        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
        size = 0;
    }

    private int hashFunction(K key) {//Biar hash bisa ngitung indeks sesuai key yang ada
        return key.hashCode() % keys.length;
    }

    public void put(K key, V value) {//Nambahin key sama valuenya ke tabel hash kita
        int index = hashFunction(key);
        int probeCount = 0;
        int i = 0;

        while (keys[index] != null) {//kalo posisi seharusnya udah keisi
            index = (index - i * i + keys.length) % keys.length;//langsung probing quadratik disini
            probeCount++;
            i++;
        }

        keys[index] = key;// nyimpen keynya
        values[index] = value;//kalo ini nyimpen valuenya
        size++;

        System.out.println("Key yang di insert: " + key + " pada index: " + index + " dengan " + probeCount + " banyaknya prob.");
    }

    public V get(K key) {//Ngitung indeks awal
        int index = hashFunction(key);
        int i = 0;

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];//Return valuenya kalau nemu keynya
            }
            index = (index - i * i + keys.length) % keys.length;//Probing kuadratik disini
            i++;
        }

        return null; //balikin null ke output kalo ga nemu keynya
    }

    public void Displaytabelhash() {
        System.out.println("Index\tKey\tValue");
        for (int i = 0; i < keys.length; i++) {
            System.out.println(i + "\t" + keys[i] + "\t" + values[i]);
        }
    }
}
