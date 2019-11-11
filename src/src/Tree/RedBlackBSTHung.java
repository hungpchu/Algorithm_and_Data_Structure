package Tree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * Insert + Search: 2O(logN)
 * Link to explain delete code: https://www.cs.princeton.edu/~rs/talks/LLRB/RedBlack.pdf
 */
public class RedBlackBSTHung {
    public Node root;
    public static final boolean RED = true;
    public static final boolean BLACK = false;
    class Node{

        int key;
        int val;
        Node left,right;
        int N;
        boolean color;

        Node(int key, int val, int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }

    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isRed(Node root) {
        if (root == null) return false;
        // if the color == red
        return root.color == RED;
    }


    /***
     * Use when the right leaning of 3 node
     */
    public Node rotateLeft(Node root){
        Node rightNode = root.right;
        root.right = rightNode.left;
        rightNode.left = root;
        rightNode.color  = root.color;
        root.color = RED;
        rightNode.N = root.N;
        root.N = 1 + size(root.left) + size(root.right);
        return rightNode;
    }


    /***
     * use when there are 2 red link in the row
     */
    public Node rotateRight(Node root){
        Node leftNode = root.left;
        root.left = leftNode.right;
        // set old root to be right child new root aka leftNode
        leftNode.right = root;
        // reset the link to the new parent aka leftNode from the old parent aka root
        leftNode.color = root.color;
        root.color = RED;
        leftNode.N = root.N;
        root.N = 1 + size(root.left) + size(root.right);
        // set leftNode as the new root
        return leftNode;
    }


    /***
     * Use when there are 2 red link for the root.left and root.right
     * -> splitting the 4 node
     * -> pass red link up one level
     * flip to opposite color
     */
    public void flipColors(Node root){
        root.color = !root.color;
        root.left.color = !root.left.color;
        root.right.color = !root.right.color;
    }



    public int size() {
        return size(root);
    }

    public int size(Node root){
        if (root == null) return 0;
        else return root.N;
    }

    public void putValue(int key, int val){
        root = putValue(root,key,val);
        root.color = BLACK;
//        BFS(root);
//        System.out.println("root flip sau cung =" + root.val + " color = " + root.color);

    }

    public Node putValue(Node root, int key, int val){
        if(root == null) return new Node(key,val,1,RED);
        if(key < root.key) root.left = putValue(root.left,key,val);
        else if(key > root.key) root.right = putValue(root.right,key,val);
        else root.val = val;

        /***
         * Post order balancing
         * Balancing operation: rotate left, rotate right and flip color
         * Those operations are performed from the way up from the point of
         * insert
         */
        root = balance(root);

        return root;
    }

    public Node balance(Node root){
        if (root == null) return null;
        // enforce left leaning condition
        if(isRed(root.right) && !isRed(root.left)) root = rotateLeft(root);
        // balance a 4 node
        if(isRed(root.left) && isRed(root.left.left)) root = rotateRight(root);
        // split a 4 node
        if(isRed(root.left) && isRed(root.right)) flipColors(root);
        return root;
    }

    public Node moveRedLeft(Node root){
        // join the right child with root and left child to have 4 node
        flipColors(root);
        // root.right.left is red then there is an imbalance in the 4 -node
        if(isRed(root.right.left)){
            // balance the 4 node
            root.right = rotateRight(root.right);
            // lean red link to the left
            root = rotateLeft(root);
            // split the 4 node
            flipColors(root);
        }
        return root;
    }

    /***
     * Must goal: delete only if root or root.left is red
     * since root or root.left will be in the 2-node
     * @param root
     * @return
     */
    public Node deleteMin(Node root){
        // root must be red for deletion
        if(root.left == null) return null;
        /***
         * borrow from right sibling if both root.left and root.left.left are black
         * means that root.left and root.left.left are 2-node, not 3-node.Hence, we borrow
         * node from right child to make root.left and root.left.left become 3-node
         */
        if(!isRed(root.left) && !isRed(root.left.left)) root = moveRedLeft(root);
        root.left = deleteMin(root.left);
        // after post traverse to delete the min node
        // then balance the tree on the way up
        return balance(root);
    }

    public void deleteMin(){
        // if the right child and left child is black then color parent red
        if(!isRed(root.left) && !isRed(root.right)) root.color = RED;
        // delete the min node
        root = deleteMin(root);
        // color the parent black again after deletion
        if(!isEmpty()) root.color = BLACK;
    }


    public  Node moveRedRight(Node root) {
        // join 2 node to become 4 node
        flipColors(root);
        // carry the red link from the left child to the right child
        if (isRed(root.left.left)) {
            // right sibling borrows node from left sibling to become 3 node
            root = rotateRight(root);
            // split 4-node
            flipColors(root);
        }
        return root;
    }

    public void deleteMax() {

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;

    }

    // delete the key-value pair with the maximum key rooted at h
    public Node deleteMax(Node h) {
        // lean 3 node to the right so that we can easily delete node in 3n node
        // without violation
        if (isRed(h.left)) h = rotateRight(h);

        // hit the base case then return h.right as null aka deletion
        // h must be red so that it is in 3 node
        if (h.right == null)  return null;

        /***
         * borrow from sibling to turn into 3-node instead of just 2-node
         */
        if (!isRed(h.right) && !isRed(h.right.left)) h = moveRedRight(h);

        h.right = deleteMax(h.right);

        return balance(h);
    }

    public void delete(int key){
        // pre-condition: root color should be red if both of its child is black
        if(!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = delete(root,key);
        if(!isEmpty()) root.color = BLACK;
    }

    public Node delete(Node root, int key){
        // if key < root then move to the left
        if(root.key > key){
            // if the root.left and root.left.left is black then borrow
            // from the right sibling
            if(!isRed(root.left) && !isRed(root.left.left)) root = moveRedLeft(root);
            root.left = delete(root.left,key);
         // if the key is on the right or equal to root
        }else{
            // lean right to form 3 node
            if(isRed(root.left)) root = rotateRight(root);
            if(root.key == key && root.right == null) return null;
            /***
             * borrow from sibling to turn into 3-node instead of just 2-node
             */
            if(!isRed(root.right) && !isRed(root.right.left)) root = moveRedRight(root);
            // if found the deleted key
            if(key == root.key){
                // replace deleted node with its successor
                root.val = get(root.right,getMin(root.right).key);
                root.key = getMin(root.right).key;
                // delete its sucessor
                root.right = delete(root.right,getMin(root.right).key);
            }
            // go to the right
            else root.right = delete(root.right,key);
        }
        // balance from the way up
        return balance(root);
    }

    public Node getMin(Node root){
        if(root.left == null) return root;
        return getMin(root.left);
    }

    public int get(Node root,int key){
        while(root != null){
            if(root.key > key) root = root.left;
            else if(root.key < key) root = root.right;
            else return root.val;
        }
        return -1;
    }


    public void BFS(Node root){
        if(root == null) System.out.println("The tree is empty");
        System.out.println(" Breath first search of the tree is = ");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.remove();
            if(root != null){
                System.out.print("[" + root.val + ",");
                if(root.color) System.out.print("red" +"],");
                else System.out.print("black" +"],");
            }

            else System.out.print("null" + ",");
            if (root != null)queue.add(root.left);
            if (root != null) queue.add(root.right);
        }
        System.out.println();
    }

    public static void main(String[] args){
        RedBlackBSTHung rbst = new RedBlackBSTHung();
        rbst.putValue(6,6);
        rbst.putValue(7,7);
        rbst.putValue(8,8);
        rbst.putValue(9,9 );
        rbst.putValue(5,5);
        rbst.putValue(4,4);
        rbst.putValue(1,1);
        rbst.putValue(2,2);
        rbst.putValue(3,3);
        rbst.putValue(0,0);
        rbst.BFS(rbst.root);
        rbst.delete(rbst.root,5);
        rbst.BFS(rbst.root);
    }
}
