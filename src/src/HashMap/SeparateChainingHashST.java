package HashMap;


import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/***
 *
 */
public class SeparateChainingHashST<Key,Value> {

    // number of linked Chain as value associated with key
    public int chainsNumber;
    // number of pairs key-value
    public int numberOfPairs;
    // array of linked-list
    // key as index and linked Chain as value
    public SequentialSearchST<Key,Value>[] linkedChains;


    // constructor for our hashmap
    public SeparateChainingHashST(int chainsNumber){
        this.chainsNumber = chainsNumber;
        // init the size for the linkedChain
        linkedChains = new SequentialSearchST[chainsNumber];
        // init each link-list in the chain
        for(int i = 0; i < chainsNumber; i++) linkedChains[i] = new SequentialSearchST<>();
    }

    // hash function to hash key to index
    public int hash(Key key){
        // mask off with address of Integer.MAX_VALUE to
        // have positive result
        return (key.hashCode() % 0x7fffffff) % chainsNumber;
    }

    // return the number of chains as value
    public int getChainsNumber() { return chainsNumber;}
    // return the number of pairs
    public int size() {
        return numberOfPairs;
    }

    // return the value associated with key
    public Value get(Key key){
        if(key == null) return null;
        // hash the key to have the index
        int keyIndex = hash(key);
        return linkedChains[keyIndex].get(key);
    }

    // if the get function return not null value then contains is true;
    public boolean contains(Key key) { return get(key) != null;}

    // put the new key-value or pair indside ourn hashMap
    public void put(Key key, Value value){
        // if the key is null then return
        if(key == null) return;
        // if the value is null then delete the key if exist
        if(value == null){
            deleteKey(key);
            return;
        }

        // hash the key to obtain index
        int hashIndex = hash(key);
        // check if the index of linkedChains contains the key
        if(!linkedChains[hashIndex].contains(key)){
            linkedChains[hashIndex].put(key,value);
            numberOfPairs++;
        }
    }

    // delete value based on key
    public void deleteKey(Key key){
        if(key == null) return;
        int hashIndex = hash(key);
        if(linkedChains[hashIndex].contains(key)) linkedChains[hashIndex].deleteKey(key);
        numberOfPairs--;
    }

    // return all pairs exist
    public Iterable<Key> keyList(){
        List<Key> list = new ArrayList<>();
        for(int i = 0; i < chainsNumber;i++){
            for(Key key: linkedChains[i].list()) list.add(0,key);
        }
        return list;
    }

    public static void main(String[] args){
        SeparateChainingHashST<String, Integer> hashMap = new SeparateChainingHashST<>(4);
        hashMap.put("Chu",16);
        hashMap.put("Phuc",1997);
        hashMap.put("ngon",9);
        System.out.println("The number of pairs = " + hashMap.size());
        System.out.println("The hash map looks like: " );
        for(String key: hashMap.keyList()) System.out.println("The key is " + key + " with the value of "+ hashMap.get(key));
        System.out.println("Will hashmap contains Hung ? " + hashMap.contains("ngon"));
        hashMap.deleteKey("Phuc");
        System.out.println("The hash map after delete looks like: " );
        for(String key: hashMap.keyList()) System.out.println("The key is " + key + " with the value of "+ hashMap.get(key));
        System.out.println("The number of pairs = " + hashMap.size());
    }
}
