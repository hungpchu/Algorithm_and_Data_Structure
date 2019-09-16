package HashMap;

import java.util.Arrays;

public class MyHashMap {

    int[] hashmap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashmap = new int[100001];
        Arrays.fill(hashmap,-1);
    }

    public int hashKey(int key){ return key % hashmap.length;}

    /** value will always be non-negative. */
    public void put(int key, int value) {
        key = hashKey(key);
        hashmap[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashmap[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashmap[key] = -1;
    }
}

