package Tries;

import java.util.ArrayList;
import java.util.List;

/***
 * R-way tries provide fast search in the constant number of character compares
 * R-way tries mean try all R link to find the value
 * Space:O(RN) with R is the number of Link or the number of alphabet like R = 27 from a to z
 * N is the total numbers of key character
 * Insert + search time: O(L) with L is the length of the input string
 * Pros: time performance
 * Cons: Space with R*N
 */
public class TriesST<Value> {

    // Range represent all the char value
    public static int Range = 123;
    // root value will always be null
    // asciiTable will contains link to other node
    public Node root;

    public static class Node{
        public Object value;
        public Node[] asciiTable = new Node[Range];
    }

    /***
     * @param key as the String to find
     * @return value associated with last character in the key if search hits
     */
    public Value get(String key){
        // get the node based on the input string
        Node node = get(root,key,0);
        // if node is null then return null
        if (node == null) return null;
        return (Value)  node.value;
    }

    /***
     *
     * Time: O(N) + 1 with N is the length of key and 1 is the root
     * @param node to traverse through tries
     * @param key as String to search
     * @param keyLength as 0 and recursively search til keyLength == key.length
     * @return
     */
    public Node get(Node node, String key, int keyLength){
        // if hit the null then return
        if(node == null ) return null;
        // if hit the length of string then return Node
        if(keyLength == key.length()){
            return node;
        }
        // go on to the nextChar in the Node array of current node
        char nextChar = key.charAt(keyLength);
        // Use the nextChar as index since it will get to the position of the char
        // in the asciiTable. For instance, a will have the position of 97 in ascii table
        // so node.asciiTable['a'] will return the node a at position 97
        return get(node.asciiTable[nextChar],key, keyLength + 1);
    }

    public void put(String key, Value value){
        root = put(root,key,value,0);
    }

    /***
     * For key = shells and value = 3
     * Caution: Node s at beginnning of "shells" will be different from the
     * s at the end since s at the end will have asciitable at the position 5 or null point to Node with value = 3 but have all null value in the asciiTable
     * But s at the beginning will have not value and asciiTable have 2 non-null Node at h .
     * See tha page 734 in the book for further understanding
     */
    public Node put(Node node, String key, Value value, int keyLength){
        // if node is null then init new node
        if(node == null) node = new Node();
        // if the keyLength then update the value at that node
        if(key.length() == keyLength){ node.value = value; return node;}
        // retrieve next char to update the node
        char nextChar = key.charAt(keyLength);
        // update the axciiTable with the next char index
        node.asciiTable[nextChar] = put(node.asciiTable[nextChar],key,value,keyLength+1);
        return node;
    }

    /***
     * takes pre as string argument
     * @param pre = string
     * @return all the keys in the symbol table having pre as prefix
     */
    public Iterable<String> keysWithPrefix(String pre){
        List<String> list = new ArrayList<>();
        // lastCharPre is the node of last character in the string pre
        // For instance, in the case of pre = "sh"
        // -> lastCharPre = 'h' with the character e not null in the asciiTable
        // if we have the node root then we have b,s,t not null in the asciiTable
        Node lastCharPre = get(root,pre,0);
        // start at the root
        collect(lastCharPre,list,pre);
        return list;
    }

    public void collect(Node root, List<String> list, String pre){
        // if the node is null then we know that we just
        // got to the end of the tries
        if(root == null) return;
        // if the root.value is not null then we know that
        // we have a valid string in the tries
        if(root.value != null){
            list.add(pre);
        }
        // traverse through 256 char value in the asciiTable and check for
        // null node -> if the char value has asciiTable initialized or the node.value
        // then that node is not null
        for(char nextChar = 0; nextChar < Range; nextChar++) collect(root.asciiTable[nextChar], list,pre + nextChar);
    }

    /***
     * Wildcard match
     * takes a string as argument
     * @return all the keys in the symbol table that match that string
     * For instance, ".he" will return she ans the
     * */
    public Iterable<String> keysThatMatch(String string){
        List<String> list = new ArrayList<>();
        collectKeyMatch(root,"",string,list);
        return list;
    }

    public void collectKeyMatch(Node root,String pre, String string, List<String> list){
        int preLength = pre.length();
        if(root == null) return;
        // if found the word that match when pre get to the size of string
        if(preLength == string.length() && root.value != null){
            list.add(pre);
        }
        // if not found when get to the size of string but the value of last char is null
        if(preLength == string.length()) return;
        char nextChar = string.charAt(preLength);
        for(char c = 0; c < Range; c++){
            // Adding '.' so we can check all the possibility
            // For instance, ".he" will check all possibility of first char like 's' or t can form 'she' or 'the'
            if(nextChar == '.' || nextChar == c){
                collectKeyMatch(root.asciiTable[c],pre + c,string,list);
            }
        }
    }

    /***
     * longestPrefixOf finds the longest prefix that exists in tries
     * @param string as argument
     * @return the longest key in the symbol table that is a prefix of that string
     * For instance, "shell" return she and "shellsort" return shells
     */
    public String longestPrefixOf(String string){
        int maxIndex = maxIndex(root,string,0,0);
        return string.substring(0,maxIndex);
    }

    public int maxIndex(Node root, String string, int countLength, int maxLength){
        if(root == null || countLength == string.length()) return maxLength;
        // not count the whole word as longest prefix
        if(root.value != null && countLength < string.length() - 1) maxLength = countLength;
        char nextChar = string.charAt(countLength);
        return maxIndex(root.asciiTable[nextChar],string, countLength + 1,maxLength);
    }

    public void delete(String string){
        root = delete(root, string, 0);
    }

    public Node delete(Node root, String string, int startIndex){
        // if the node is null then return
        if(root == null) return null;
        // get to the end char of the deleted string
        // then set the value of last char to null
        if(startIndex == string.length() ){
            root.value = null;
        }
        // if not get to the last character then continue to do so
        else{
            char nextChar = string.charAt(startIndex);
            root.asciiTable[nextChar] = delete(root.asciiTable[nextChar],string, startIndex + 1);
        }

        /***
         *  if(root.value != null) and the for loop is the condition to return all the node that should
         *  not be deleted at the string. For example: if deleted shells then we just want to delete
         *  lls and keep she and this condition will keep she
         */
        // return the most recent node has non null value since we do not want to remove it
        if(root.value != null) return root;
        for(char c = 'a'; c < Range; c++){
            // keep all the value from the most recent non-null value node all the way up to the root
            if(root.asciiTable[c] != null){
                return root;
            }
        }
        /***
         * delete lls in the above example of shells
         */
        // delete all the value on the way from the last character in the deleted string
        // to the most recent char on the way with value = non-null
        return null;
    }


    public static void main(String[] args){
        TriesST<Integer> tries = new TriesST<>();
        tries.put("by",4);
        tries.put("sea",2);
        tries.put("sells",1);
        tries.put("she",0);
        tries.put("shells",3);
//        tries.put("shellsort",7);
        tries.put("the",5);
        System.out.println("search value = "+ tries.get("shells"));
        System.out.println("All the string with the prefix = ");
        for(String string: tries.keysWithPrefix("sh")) System.out.println(string);
        System.out.println("All the string with the key match = ");
        for(String string: tries.keysThatMatch(".ll.")) System.out.println(string);
        System.out.println("longest prefix of shells = "+ tries.longestPrefixOf("shellsort"));
        tries.delete("shells");
//        System.out.println("search value = "+ tries.get("she"));
        System.out.println("All the string with the prefix s = ");
        for(String string: tries.keysWithPrefix("s")) System.out.println(string);

    }


}

