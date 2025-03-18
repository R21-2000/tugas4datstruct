public class LinearProb<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public LinearProb(int capacity) {
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

        while (keys[index] != null) {
            // Reverse linear probing
            index = (index - 1 + keys.length) % keys.length;
            probeCount++;
        }

        keys[index] = key;
        values[index] = value;
        size++;

        System.out.println("Inserted key: " + key + " at index: " + index + " with " + probeCount + " probes.");
    }

    public V get(K key) {
        int index = hashFunction(key);
        int probeCount = 0;

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            // Reverse linear probing
            index = (index - 1 + keys.length) % keys.length;
            probeCount++;
        }

        return null; // Not found
    }

    public void displayHashTable() {
        System.out.println("Index\tKey\tValue");
        for (int i = 0; i < keys.length; i++) {
            System.out.println(i + "\t" + keys[i] + "\t" + values[i]);
        }
    }
}
