package HashMap;

import java.util.ArrayList;
import java.util.List;

/***
 * represent a linked chains
 */
public class SequentialSearchST<Key,Value> {

    public int size;
    public Node first;

    public class Node{
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int getSize(){return size; }
    public boolean isEmpty(){ return size == 0;}

    public boolean contains(Key key){return get(key) != null; }

    public Value get(Key key){
        if(key == null) return null;
        for(Node x = first; x !=  null; x = x.next) if(key.equals(x.key)) return x.value;
        return null;
    }

    public void put(Key key, Value value){
        if(key == null) return;
        if(value == null){
            deleteKey(key);
            return;
        }
        for(Node node = first; node != null; node = node.next){
            if(key.equals(node.value)) return;
        }
        first = new Node(key,value,first);
        size++;
    }


    public void deleteKey(Key key){
        if(key == null) return;
        first = deleteKey(first,key);
    }

    public Node deleteKey(Node node, Key key){
        // base case
        if(node == null) return null;
        // inductive case
        if(key.equals(node.key)){
            size--;
            return node.next;
        }
        // if not found
        node.next = deleteKey(node.next,key);
        return node;
    }

    public Iterable<Key> list(){
        List<Key> list = new ArrayList<>();
        for(Node node = first; node != null; node = node.next) list.add(0,node.key);
        return list;
    }

    public static void main(String[] args){
        SequentialSearchST<String, Integer> linkedChain = new SequentialSearchST<>();
        linkedChain.put("Chu",16);
        linkedChain.put("Phuc",9);
        linkedChain.put("Hung",1997);
        System.out.println("The linked chain is: ");
        for(String key: linkedChain.list()) System.out.println("The key is " + key + " with the value is " + linkedChain.get(key));
        System.out.println("We delete value at Phuc");
        linkedChain.deleteKey("Phuc");
        System.out.println("The linked chain after deletion is: ");
        for(String key: linkedChain.list()) System.out.println("The key is " + key + " with the value is " + linkedChain.get(key));
        System.out.println("Will the linked chain contain Hung? " + linkedChain.contains("Hung"));
    }
}
