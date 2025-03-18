public class QuadProb<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public QuadProb(int capacity) {
        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
        size = 0;
    }

    private int hashFunction(K key) {
        return key.hashCode() % keys.length;
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        int probeCount = 0;
        int i = 1;

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                values[index] = value; // Update value if key exists
                return;
            }
            probeCount++;
            index = (index + i * i) % keys.length; // Quadratic probing
            i++;
        }

        keys[index] = key;
        values[index] = value;
        size++;

        System.out.println("Inserted " + key + " at index " + index + " with " + probeCount + " probes.");
    }

    public V get(K key) {
        int index = hashFunction(key);
        int i = 1;

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + i * i) % keys.length; // Quadratic probing
            i++;
        }
        return null; // Key not found
    }

    public void displayHashTable() {
        System.out.println("Hash Table:");
        for (int i = 0; i < keys.length; i++) {
            System.out.println(i + ": " + keys[i] + " -> " + values[i]);
        }
    }
}
