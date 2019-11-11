package Tries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * TST are good when space are not available with log number of char compare
 * TST correspond to 3 way string quick sort
 * TST is the compact represent of R-way trie
 * @param <Value>
 */
public class TST<Value>{

    public Node<Value> root;
    class Node<Value> {
        char charValue;
        Node left,middle,right;
        Value value;
    }

    public Value get(String key){
        if(key == null) return null;
        Node lastNode = get(root,key,0);
        if(lastNode == null) return null;
        return (Value) lastNode.value;
    }

    public Node get(Node node, String key, int index){
        if( node == null) return null;
        char nextChar = key.charAt(index);
        // if char is less then the middle then go to the left
        if (node.charValue > nextChar) return get(node.left,key,index );
       // if char is bigger than the middle then go to the right
        else if (node.charValue < nextChar) return get(node.right,key,index);
        // if found the 1st char then increment index and get the the end of string
        else if (index < key.length() - 1) return get(node.middle, key, index + 1);
        // if get to the end of string key then return the node have value
        else return node;
    }


    public void put(String key, Value value){ root = put(root, key, value,0);}

    public Node put(Node node, String key, Value value, int index){
        char nextChar = key.charAt(index);
        if(node == null) {
            node = new Node();
            node.charValue = nextChar;
        }
        if(nextChar < node.charValue) node.left = put(node.left,key,value,index);
        else if(nextChar > node.charValue) node.right = put(node.right, key,value,index);
        // put all the next char made up the whole word string in the middle link
        else if(index < key.length() - 1) node.middle = put(node.middle,key,value,index + 1);
        else node.value = value;
        return node;
    }



    public void BFS(){
        if(root == null) System.out.println("The tree is empty");
        Node currenRoot = root;
        System.out.println(" Breath first search of the tree is = ");
        Queue<Node> queue = new LinkedList<>();
        queue.add(currenRoot);
        while(!queue.isEmpty()){
            currenRoot = queue.remove();
            if(currenRoot != null){
                System.out.print("[" + currenRoot.charValue + "," + currenRoot.value + "]");
            }else System.out.print("null" + ",");
            if (currenRoot != null)queue.add(currenRoot.left);
            if (currenRoot != null)queue.add(currenRoot.middle);
            if (currenRoot != null) queue.add(currenRoot.right);
        }
        System.out.println();
    }

    public String longestPrefixOf( String key){
        int index = 0,maxIndex = 0;
        Node currentRoot = root;
        while(currentRoot != null){
            char charValue = key.charAt(index);
            if(currentRoot.charValue > charValue) currentRoot = currentRoot.left;
            else if(currentRoot.charValue < charValue) currentRoot=currentRoot.right;
            else{
                index++;
                if(currentRoot.value != null && index < key.length()) maxIndex = index;
                currentRoot = currentRoot.middle;
            }
        }
        return key.substring(0,maxIndex);
    }

    public Iterable<String> keysThatMatch(String prefixKey){
        List<String> list = new ArrayList<>();
        // find to see if we get prefixKey in the tries
        Node preNode = get(root,prefixKey,0);
        // if the prefix null then return the list
        if(preNode == null) return list;
        // if the prefix not null then add the prefix
        if(preNode.value != null) list.add(prefixKey);
        // collect all remaining word match the prefix
        collect(preNode.middle,list,new StringBuilder(prefixKey));
        // return list
        return list;
    }

    // traverse through the tries to find the whole word
    public void collect(Node root, List<String> list, StringBuilder key){
        if(root == null) return;
        // check for prefix
            collect(root.left, list, key);
            //key.deleteCharAt(key.length() - 1);
             collect(root.right, list, key);
        if(root.value  != null) list.add(key.toString() + root.charValue);
        collect(root.middle,list,key.append(root.charValue));

    }

    public static void main(String[] args){
        TST<Integer> tst = new TST<>();
        tst.put("shealls",11);
//        tst.put("shea",10);
//        tst.put("by",4);
//        tst.put("are",12);
//        tst.put("the",8);
//        System.out.println("get the Hung = " + tst.get("by"));
        tst.BFS();
//        System.out.println("root = " + tst.root.charValue);
//        System.out.println("longest prefix of Hung = " + tst.longestPrefixOf("shealls"));
//        for(String s: tst.keysThatMatch("sh"))System.out.println(s);
}
}



