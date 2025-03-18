import java.util.LinkedList;

class Chain<K, V> {
    private LinkedList<Entry<K, V>>[] table;

    public Chain(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = key.hashCode() % table.length;
        table[index].add(new Entry<>(key, value));
        System.out.println("Inserted key: " + key + " at index: " + index);
    }

    public V get(K key) {
        int index = key.hashCode() % table.length;
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Not found
    }

    public void displayHashTable() {
        System.out.println("Index\tKey\tValue");
        for (int i = 0; i < table.length; i++) {
            for (Entry<K, V> entry : table[i]) {
                System.out.println(i + "\t" + entry.key + "\t" + entry.value);
            }
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
