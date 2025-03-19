import java.util.LinkedList;

class Chain<K, V> {
    private LinkedList<Entry<K, V>>[] table;//Array buat nyimpen linked list
    
    @SuppressWarnings("unchecked")//biar ignore warning di line 8
    public Chain(int capacity) {
        table = new LinkedList[capacity];//buat array linked list disini
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {//buat nambah key & value ke dalam tabel hash
        int index = key.hashCode() % table.length;// ngitung indeks sesuai hash key
        table[index].add(new Entry<>(key, value));// tambah entry bary ke linkedlist sesuai indeksnya
        System.out.println("Key yang di insert: " + key + " pada index: " + index);
    }

    public V get(K key) {//buat dapet value sesuai key yang dipunya
        int index = key.hashCode() % table.length;//ngitung indeks sesuai hash key
        for (Entry<K, V> entry : table[index]) {//iterasi lewat linked list sesuai indeksnya
            if (entry.key.equals(key)) {//kalo nemu keynya
                return entry.value;//return nilainya
            }
        }
        return null; //return null kalo ga nemu keynya
    }

    public void Displaytabelhash() {//buat show ke output isi tabel hashnya
        System.out.println("Index\tKey\tValue");
        for (int i = 0; i < table.length; i++) {
            for (Entry<K, V> entry : table[i]) {
                System.out.println(i + "\t" + entry.key + "\t" + entry.value);
            }
        }
    }

    private static class Entry<K, V> {//class entry buat nyimpen pasangan key&valuenya
        K key;//ini keynya
        V value;//ini valuenya

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
