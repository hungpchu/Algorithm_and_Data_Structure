package Tree;

import java.util.*;

public class BinaryTree {

    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            visit(node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            visit(node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            visit(node.value);
        }
    }

    public void BFS() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.left != null) {
                nodes.add(node.right);
            }
        }
    }


    public void traverseInOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        stack.push(root);
        while(! stack.isEmpty()) {
            while(current.left != null) {
                current = current.left;
                stack.push(current);
            }
            current = stack.pop();
            visit(current.value);
            if(current.right != null) {
                current = current.right;
                stack.push(current);
            }
        }
    }

    public void traversePreOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        stack.push(root);
        while(! stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);

            if(current.right != null)
                stack.push(current.right);

            if(current.left != null)
                stack.push(current.left);
        }
    }

    public void traversePostOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node prev = root;
        Node current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    public void DFS(Node root){
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty() ){
            Node current = stack.pop();
            if(current.right != null) stack.add(current.right);
            if(current.left != null) stack.add(current.left);
            System.out.print(current.value  + " ");
        }
    }



    public static int countLeaf(Node root,int sum){
        if(root == null) return sum;
        if(root.left == null && root.right == null) sum++;
        if(root.left != null) sum = countLeaf(root.left,sum);
        if(root.right != null ) sum = countLeaf(root.right,sum);
        return sum;
    }

    public static int countLeftLeafs(Node root, int sum){
        if(root == null) return sum;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                sum++;
                sum = countLeftLeafs(root.left,sum);
            }else sum = countLeftLeafs(root.left,sum);
        }
        if(root.right != null) sum = countLeftLeafs(root.right,sum);

        return sum;
    }

    public static int countAllNodes(Node root, int sum){
        if(root == null ) return sum;
        sum++;
        if(root.left != null) sum = countAllNodes(root.left,sum);
        if(root.right != null ) sum = countAllNodes(root.right,sum);
        return sum;
    }

    // DFS : in-order, post-order & pre-order


    private void visit(int value) {
        System.out.print(" " + value);
    }

    // DFS : in-order, post-order & pre-order
    // BFS : pre-order
    //
    // Time Complexity : O( N )
    // Space Complexity : O( N )
    //
    List<List< Integer >> finalPathsList;

    public List<List<Integer>> pathSum(Node root, int sum) {
        finalPathsList = new ArrayList<>();

        if ( root == null ) return finalPathsList;

        ArrayList< Integer > defaultList = new ArrayList< Integer >();

        // 0. STARTING CASE
        // Add root, because I'm at root right now
        defaultList.add( root.value );

        // 0. START RECURSION
        getPathSum( root, new ArrayList< Integer >( defaultList ), sum );

        return finalPathsList;
    }

    public Node deleteNodeKey(Node root, int key){
            if(root == null) return null;
            if(key < root.value) root.left = deleteNodeKey(root.left,key);
            else if (key > root.value) root.right = deleteNodeKey(root.right,key);
            else{
                // Case 2: 1 child so check for each side.
                // assign value value to root.left so it will override the deleted node
                if (root.right == null) return root.left;
                if (root.left == null) return root.right;

                // Case 3: 2 children then goes all the way to left in the inorder
                // to take the value
                root.value = minValue(root.right);
                // then goes to the right to delete that min value
                root.right = deleteNodeKey(root.right,root.value);
            }

            return root;
    }

    public int minValue(Node root)
    {
        if (root == null ) return 0;
        if (root.left == null) return root.value;
        return minValue(root.left);
    }

    public int maxValue(Node root)
    {
        if (root == null ) return 0;
        if (root.right == null) return root.value;
        return minValue(root.right);
    }

    // 4. FROM 1, 2, 3 you would know what to pass as argument to recursive function
    public void getPathSum( Node h, List< Integer > path, int sumSoFar ) {
        //
        // 1. CORNER CASE
        //
        if ( h == null ) {
            return;
        }

        //
        // 2. FINAL CASE: Reach a leaf that satisfies
        //
        if ( ( h.left == null ) && ( h.right == null ) ) {
            if ( sumSoFar - h.value == 0 ) {
                finalPathsList.add( path );
            }
            return;
        }

        //
        // 3-1. RECURSIVE STEP ( continue searching to the left )
        //
        if ( h.left != null ) {
            // Create a new arraylist to pass to recursive function
            // copy to path to tmpPath
            List< Integer > tmpPath = new ArrayList< Integer >( path );
            // Add left node
            tmpPath.add( h.left.value );
            getPathSum( h.left, tmpPath, sumSoFar - h.value );
        }

        //
        // 3-2. RECURSIVE STEP ( continue searching to the right )
        //
        if ( h.right != null ) {
            // Create a new arraylist to pass to recursive function
            List< Integer > tmpPath = new ArrayList< Integer >( path );
            // Add right node
            tmpPath.add( h.right.value );
            getPathSum( h.right, tmpPath, sumSoFar - h.value );
        }
    }

    public Node deepestNode(Node root){
        if(root == null ) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.remove();
            if(root.left!= null) queue.add(root.left);
            if(root.right != null) queue.add(root.right);
        }

        return root;
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.addRecursive(tree.root,3);
        tree.addRecursive(tree.root,7);
        tree.addRecursive(tree.root,2);
        tree.addRecursive(tree.root,4);
        tree.addRecursive(tree.root,6);
        tree.addRecursive(tree.root,8);
        tree.addRecursive(tree.root,9);
        tree.traverseInOrder(tree.root);
        //tree.deleteNodeKey(tree.root,8);
        System.out.println();
        tree.traverseInOrder(tree.root);
    //    System.out.println(tree.minValue(tree.root));
//        System.out.println();
//        tree.DFS(tree.root);
//        System.out.println();
//        tree.BFS();
//        System.out.println();
//
//        BinaryTree tree = new BinaryTree();
//        tree.add(9);
//        tree.addRecursive(tree.root,7);
//        tree.addRecursive(tree.root,3);
//        tree.addRecursive(tree.root,15);
//        tree.addRecursive(tree.root,20);
//        tree.traverseInOrder(tree.root);
        System.out.println();
        System.out.println(tree.countLeaf(tree.root,0));
        System.out.println(tree.deepestNode(tree.root).value);

    }
}