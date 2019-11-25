package HashSet;

import java.util.Arrays;

public class MyHashSet {

    class Node{
        // no need node next
    }

    int[] hashset;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashset = new int[100001];
        Arrays.fill(hashset,-1);
    }

    public int hashKey(int key) {return (key & 0x7fffffff) % hashset.length;}

    public void add(int key) {

        int keyHash = hashKey(key);
        if(hashset[keyHash] == -1) hashset[keyHash] = key;
    }

    public void remove(int key) {
        key = hashKey(key);
        hashset[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (hashset[hashKey(key)] != -1) return true;
        else return false;
    }
}