package Tree;


import java.lang.reflect.Array;
import java.util.*;

/***
 * Best Case: logN node between the root and each null link
 * Worst Case: N nodes on the search path
 * Insert + search: O(logN)
 */
public class BinarySearchTree {

    static List<Node> path;
    static List<List<Node>> allPath;
    static int sumRootToLeaf;


    public class Node {
        // key
        public int key;
        // value associated with key
        public int value;
        // link to subtree
        public Node left, right;
        // Node in the subtree rooted
        public int N;

        public Node(int key, int value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public Node root;


    public int size() {
        return size(root);
    }

    public int size(Node root){
        if (root == null) return 0;
        else return root.N;
    }

    // look exactly like binary search
    public int getValue(Node root, int key){
        if(root == null ) return -1;
        if(key < root.key) return getValue(root.left,key);
        else if(key > root.key) return getValue(root.right,key);
        else return root.value;
    }

    // iteration search for key
    public int getValueIteration(Node root, int key){
        while(root != null){
            if (key < root.key ) root = root.left;
            else if (key > root.key) root = root.right;
            else return root.value;
        }

        return -1;
    }

    // put the new node in the tree
    public void putValue(int key, int val){
        root = putValue(root, key,val);
    }

    // recursizely add the new node to the tree
    // if found the null then add right there
    public Node putValue(Node root, int key, int val){
        // reset the link of each parents to its child
        if( root == null ) return new Node(key,val,1);
        if(key < root.key) root.left = putValue(root.left,key,val);
        else if (key > root.key) root.right = putValue(root.right,key,val);
        else root.value = val;
        // increment the count on the way up
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public void BFS(Node root){
        if(root == null) System.out.println("The tree is empty");
        System.out.println(" Breath first search of the tree is = ");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.remove();
            System.out.print(root.value + ",");
            if(root.left != null) queue.add(root.left);
            if(root.right != null) queue.add(root.right);
        }
        System.out.println();
    }

    public void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.value + ",");
        inOrder(root.right);
    }

    /*** go down to the end first
     * @param root
     */
    public void inOrderIteration(Node root){
        if(root == null ) System.out.println("There is no node in the tree");
        Stack<Node> stack  = new Stack<>();
        // hash Set so we will not check same node twice
        HashSet<Node> hs = new HashSet<>();
        System.out.println("The inOrder of tree with left -> root -> right = ");
        stack.add(root);
        while(!stack.isEmpty()) {
            Node rootLeft = root.left;
            // add all the left node
            while (!hs.contains(rootLeft) && rootLeft != null) {
                stack.add(rootLeft);
                rootLeft = rootLeft.left;
            }
            // then check left node first
            root = stack.pop();
            hs.add(root);
            System.out.print(root.value + ",");
            // after left node will be the right node
            if (root.right != null) {
                root = root.right;
                stack.add(root);
            }
        }
        System.out.println();
    }

    public void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.value + ",");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderIteration(Node root){
        if(root == null) System.out.println("The tree is empty");
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        System.out.println("The preOrder tree with root -> left -> right = ");
        while(!stack.isEmpty()){
            root = stack.pop();
            // go down to the left first
            while(root != null){
                System.out.print(root.value + ",");
                // along the way if there is right node then add
                if(root.right != null) stack.add(root.right);
                // break if there is not left node
                root = root.left;
             }
        }
        System.out.println();
    }

    public void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + ",");
    }

    public void postOrderIteration(Node root) {
        if (root == null) System.out.println("The tree is empty");
        System.out.println("The postOrder of tree with left -> right -> root = ");
        Stack<Node> stack = new Stack<>();
        List<Node> result = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(0,root);
            // add left node -> left node will always be checked after right node
            if(root.left != null) stack.add(root.left);
            // then add right node -> right node will always be checked first
            if( root.right != null) stack.add(root.right);
        }
        for(Node node: result) System.out.print(node.value + ",");
        System.out.println();
    }

    /***
     * Goes all until the left of tree
     * to find the min value
     */
    public Node minNode(Node root){
        // return node left before encouter null
        if(root.left == null) return root;
        return minNode(root.left);
    }

    public Node deleteMinNode(Node root){
        if(root.left == null){
            // 1 child
            if(root.right != null) return root.right;
            // 0 child
            else return null;
        }
        root.left = deleteMinNode(root.left);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public Node floor(Node root, int key){
        if(root == null ) return null;
        // check the root node
        if(root.key == key) return root;
        // check all the left node
        if(root.key > key) return floor(root.left,key);
        // at the end if root and left not satisfy then check right
        Node nodeRight = floor(root.right, key);
        if(nodeRight != null) return nodeRight;
        else return root;
    }

    /***
     * Post order traversal since it go all until the end and start check
     * node from bottom up
     */
    public Node deleteNode(Node root, int key){
        // if there is no node then return or
        // get to the null
        if(root == null) return null;
        // go to the left to find the key
        if(root.key > key) root.left = deleteNode(root.left,key);
        else if (root.key < key) root.right = deleteNode(root.right,key);
        // found the deleted node
        else{
            // if the key has 1 child
            // 1 child as left node
            if(root.right == null) return root.left;
            // 1 child as right node
            else if(root.left == null) return root.right;
            // there is 2 child then we need to replace deleted node
            // with its successor
            else{
                Node successor = minNode(root.right);
                // delete the value of deleted node
                root.value = successor.value;
                // delete the successor node
                root.right = deleteMinNode(root.right);
            }
        }
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public int rank(Node root, int key){
        // base case: if it is null then there is no node less
        // then it
        if(root == null) return 0;
        if(root.key > key ) return rank(root.left,key);
        // if key is on the right then it's rank is the root and all the node in the left
        else if(root.key < key) return 1 + size(root) + rank(root.right,key);
        // if key is the root then its rank is all the node in the left
        else return size(root.left);

    }

    public int height(Node root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public Iterable<Integer> rangeNode(int lo, int hi){
        Queue<Integer> queue = new LinkedList<>();
        rangeNode(queue,root,lo,hi);
        return queue;
    }

    public void rangeNode(Queue<Integer> queue, Node root, int lo, int hi){
        if(root == null) return;
        if(root.key > lo) rangeNode(queue,root.left,lo,hi);
         if(root.key  >= lo && root.key <= hi) queue.add(root.key);
         if (root.key < hi) rangeNode(queue,root.right,lo,hi);
    }

    // build from bottom up with post order traversal
    public static int maxPathSumFromRootToLeaf(Node root){
        if(root == null) return 0;
        int left = Math.max(maxPathSumFromRootToLeaf(root.left),0);
        int right = Math.max(maxPathSumFromRootToLeaf(root.right),0);
        int currentPath = root.value + Math.max(left,right);
        return currentPath;
    }
    // pre order traversal
    public static void allPaths(Node root){
        if(root == null) return;
        path.add(root);
        if(root.left == null && root.right == null){
            allPath.add(path);
            sumRootToLeaf += getNum(path);
            Node parent = path.get(0);
            path = new ArrayList<>();
            path.add(parent);
        }
        allPaths(root.left);
        allPaths(root.right);
    }

    public static int getNum(List<Node> list){
        int num = 0;
        for(Node n: list) num = num*10 + n.value;
        return num;
    }

    public void preOrder1(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            if(root.right != null) {
                stack.add(root.right);
//root =root.right;
            }
            System.out.print(root.value + " ");
            if(root.left != null) stack.add( root.left);

        }
    }

    public void inOrder1(Node root){
        if(root == null) return ;
        Stack<Node> stack = new Stack<>();
        HashSet<Node> hs = new HashSet<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.peek();
            while(root.left != null && !hs.contains(root.left)){
                stack.add(root.left);
                root = root.left;
            }
            hs.add(stack.peek());
            System.out.print(stack.pop().value + " ");
            if(root.right != null) stack.add(root.right);
        }
    }



    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.putValue(6,6);
        bst.putValue(7,7);
        bst.putValue(8,8);
        bst.putValue(9,9 );
        bst.putValue(5,5);
        bst.putValue(4,4);
        bst.putValue(1,1);
        bst.putValue(2,2);
        bst.putValue(3,3);
        path = new ArrayList<>();
        allPath = new ArrayList<>();
        sumRootToLeaf = 0;
        bst.BFS(bst.root);
//        System.out.println("Search for node 8 = "+ bst.getValue(bst.root,8));
//        bst.deleteMinNode(bst.root);
//        bst.deleteNode(bst.root,6);
        bst.inOrderIteration(bst.root);
        bst.preOrderIteration(bst.root);
        bst.postOrderIteration(bst.root);
        System.out.println(" Number of node in the tree = " + bst.root.N);
        System.out.println("height of tree = " + bst.height(bst.root));
        System.out.println("Range = ");
        for(int key: bst.rangeNode(2,7)) System.out.print(key +",");
        System.out.println();
        System.out.println("max Path = " + bst.maxPathSumFromRootToLeaf(bst.root));
        allPaths(bst.root);
        System.out.println("number of path = " + allPath.size());
        for(List<Node> list: allPath){
            System.out.print("Path = ");
            for(Node pa: list) System.out.print(pa.value + ", ");
            System.out.println();
        }
        System.out.println("sum from root to leaf = "+ sumRootToLeaf);

    }

}


