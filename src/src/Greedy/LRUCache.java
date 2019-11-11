package Greedy;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache<Key,Value> {

    /***
     * Using linkedlist for a dynamic insert+ delete + get
     */
    LinkedList<Key> queue;
    /***
     * using hashmap to associated key with value
     */
    HashMap<Key,Value> hm;
    int size, fullSize;
    public LRUCache(int capacity) {
        // init the queue and linkedlist
        queue = new LinkedList<>();
        hm = new HashMap<>();
        // init the size to know if we need to delete for new element
        size = 0;
        fullSize = capacity;
    }

    public Value get(Key key) {
        // if (
        if(!hm.containsKey(key)) return null;
        updateList(key);
        return hm.get(key);
    }

    public void updateList(Key key){
        // find the most recently encoutered element in the queue and delete it
        if(queue.contains(key)) queue.removeFirstOccurrence(key);
        // add that element back to front of queue
        queue.addFirst(key);
    }

    public void put(Key key, Value value) {
        // if we have full size and we have a new key then should delete the existing key
        if(size == fullSize && !hm.containsKey(key)){
            // get the least most recently encoutered key at the end of the linkedlist
            // remove it from the queue
            Key keyDeleted = queue.pollLast();
            // remove it from the hashmap
            hm.remove(keyDeleted);
            // decrease the size
            size--;
        }
        // if we have new key
        if(!hm.containsKey(key)){
            // increase the size
            size++;
            // add the key to the front of queue since it is recently encoutered
            queue.addFirst(key);
            //if the key is already in the hashmap
        }else  updateList(key);
        // put the new value to the key
        hm.put(key,value);
    }
}