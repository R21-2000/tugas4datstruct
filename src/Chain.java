import java.util.LinkedList;

public class Chain<K, V> {
    private LinkedList<Entry<K, V>>[] table;

    public Chain(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        System.out.println("Inserted " + key + " at index " + index);
    }

    public V get(K key) {
        int index = hashFunction(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    public void displayHashTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            for (Entry<K, V> entry : table[i]) {
                System.out.print(entry.key + " -> " + entry.value + " | ");
            }
            System.out.println();
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
