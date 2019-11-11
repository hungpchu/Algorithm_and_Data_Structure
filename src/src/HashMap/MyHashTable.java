package HashMap;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable<Key,Value>{

    class Node<T>{
        public Key key;
        public Value value;
        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    public Node[] hashTable;
    public int size;

    public MyHashTable(int num){
        size = 0;
        hashTable = new Node[num];
    }

    public int hash(Key key){
        if(key instanceof String) return hashString((String) key);
        return (key.hashCode() % 0x7fffffff) % hashTable.length;

    }

    public int hashString(String s){
        int hashIndex = 0;
        for(int i = 0; i < s.length(); i++) hashIndex = (2 * hashIndex +(s.charAt(i))) % hashTable.length;
        return hashIndex ;
    }

    public void put(Key key, Value value){
        if(key == null) return;
        if(value == null) return;
        int hashIndex = hash( key);
//        System.out.println("hashIndex = "+ hashIndex);
        size++;
        if(size == hashTable.length / 2) resize();
        hashTable[hashIndex] = new Node(key,value);
    }

    public Value get(Key key){
        int hashIndex = hash(key);
        return (Value) hashTable[hashIndex].value;
    }

    public void remove(Key key){
        int hashIndex = hash( key);
        if( hashTable[hashIndex] == null) return;
        hashTable[hashIndex] = null;
        size--;
    }

    public boolean containsKey(Key key){ return hashTable[hash(key)] != null;}

    public int size(){ return hashTable.length;}

    public void resize(){
        Node[] resizeHashtable = new Node[hashTable.length*2];
        for(int i = 0; i < hashTable.length; i++){
            if(hashTable[i] != null) resizeHashtable[i] = hashTable[i];
        }
        this.hashTable = resizeHashtable;
    }

    public Iterable<Key> keys(){
        List<Key> list = new ArrayList<>();
        for(Node node:hashTable){
            if(node != null) list.add(0,(Key) node.key);
        }

        return list;
    }
    public static void main(String[] args){
        // choose array size with odd and unique number
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>(25);
        myHashTable.put("Hung",17);
        myHashTable.put("Phuc",9);
        myHashTable.put("Chu",16);
        myHashTable.put("Dep",1);
        myHashTable.put("Trai",3);
        myHashTable.put("Google",2);
        myHashTable.put("Microsoft",43);
        System.out.println("hash table size = "+ myHashTable.hashTable.length);
        System.out.println("My hashTable look like  = ");
        for(String key: myHashTable.keys()) System.out.println("The key is " + key + " with the value of " + myHashTable.get(key));
        System.out.println("Will my hash table have Hung? " + myHashTable.containsKey("Hung"));
        myHashTable.remove("Hung");
        System.out.println("Will my hash table have Hung? " + myHashTable.containsKey("Hung"));
        System.out.println("My hashTable after delete look like = ");
        for(String key: myHashTable.keys()) System.out.println("The key is " + key + " with the value of " + myHashTable.get(key));

        MyHashTable<Integer,Integer> myHashTable1 = new MyHashTable<>(69);
        myHashTable1.put(6,9);
        myHashTable1.put(16,9);
        myHashTable1.put(19,97);
        System.out.println("My hashTable integer look like = ");
        for(int key: myHashTable1.keys()) System.out.println("The key is " + key + " with the value of " + myHashTable1.get(key));
        System.out.println("Will my hash table have 6? " + myHashTable1.containsKey(6));
        myHashTable1.remove(6);
        System.out.println("Will my hash table have 6? " + myHashTable1.containsKey(6));
        System.out.println("My hashTable1 after delete look like = ");
        for(int key: myHashTable1.keys()) System.out.println("The key is " + key + " with the value of " + myHashTable1.get(key));


    }
}
