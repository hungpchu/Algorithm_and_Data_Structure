package HashMap;

import java.util.LinkedList;
import java.util.List;

/***
 * Time for Search + Insert:
 * Average:O(1)
 * worst case: O(logN)
 */
public class LinearProbingHashST<Key,Value> {
    private static final int INIT_CAPACITY = 4;

    private int numberOfPairs;           // number of key-value pairs in the symbol table
    private int hashTableSize;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values


    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        hashTableSize = capacity;
        numberOfPairs = 0;
        keys = (Key[])   new Object[hashTableSize];
        vals = (Value[]) new Object[hashTableSize];
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return numberOfPairs;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    // hash function for keys - returns value between 0 and M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % hashTableSize;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < hashTableSize; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        // assign the new resize array back to keys
        keys = temp.keys;
        // assign the new resize array of vals back to vals
        vals = temp.vals;
        // update size of hashTable to new one
        hashTableSize    = temp.hashTableSize;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (numberOfPairs >= hashTableSize/2) resize(2*hashTableSize);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % hashTableSize) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        numberOfPairs++;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        // loop through the array sequential until reach null value
        for (int i = hash(key); keys[i] != null; i = (i + 1) % hashTableSize)
            // if found return
            if (keys[i].equals(key))
                return vals[i];
            // if not found return null
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        // search for value base on the index of key
        while (!key.equals(keys[i])) {
            i = (i + 1) % hashTableSize;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % hashTableSize;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            numberOfPairs--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % hashTableSize;
        }

        numberOfPairs--;

        // halves size of array if it's 12.5% full or less
        if (numberOfPairs > 0 && numberOfPairs <= hashTableSize/8) resize(hashTableSize/2);

        assert check();
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     */
    public Iterable<Key> keys() {
        List<Key> list = new LinkedList<Key>();
        for (int i = 0; i < hashTableSize; i++)
            if (keys[i] != null) list.add(0,keys[i]);
        return list;
    }

    // integrity check - don't check after each put() because
    // integrity not maintained during a delete()
    private boolean check() {

        // check that hash table is at most 50% full
        if (hashTableSize < 2*numberOfPairs) {
            System.err.println("Hash table size m = " + hashTableSize + "; array size n = " + numberOfPairs);
            return false;
        }

        // check that each key in table can be found by get()
        for (int i = 0; i < hashTableSize; i++) {
            if (keys[i] == null) continue;
            else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }


    /**
     * Unit tests the {@code LinearProbingHashST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();

    }
}
