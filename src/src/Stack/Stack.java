package Stack;

/***
 * insert and delete at the beginning
 * Insert+ delete:O(1)
 * @param <Item>
 */
public class Stack<Item> {
    public class Node{
        public Item item;
        public Node next;
        public Node(Item item){
            this.item = item;
        }
    }

    public Node first;
    public int size;

    public Stack(){
        size = 0;
    }

    // push add at the beginning
    public void push(Item item){
        size++;
        if(first == null) first = new Node(item);
        else{
            Node newFirst = new Node(item);
            newFirst.next = first;
            first = newFirst;
        }
    }

    // delete at the beginning
    public Node pop(){
        Node deletedNode = first;
        if(first == null){
            return null;
        }else {
            size--;
            first = first.next;
        }

        return deletedNode;
    }

    public Node peek(){return first;}

    public int size(){return size();}

    public void show(){
        Node current = first;
        System.out.println("The stack looks like with the size " + size + " = ");
        while(current != null){
            System.out.print(current.item + ",");
            current = current.next;
        }

        System.out.println();
    }

    public Stack<Item> copyStack(){
        Stack<Item> copyStack = new Stack<Item>();
        if(first == null) return copyStack;
        copyStack.first = new Node(first.item);
        Node currentCopy = copyStack.first;
        Node current = first.next;
        while(current != null ){
            currentCopy.next = new Node(current.item);
            current = current.next;
            currentCopy = currentCopy.next;
        }

        return copyStack;
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.pop();
        stack.push(5);
        stack.show();
        Stack<Integer> stackCopy = stack.copyStack();
        stackCopy.pop();
        stackCopy.pop();
        stackCopy.show();

    }
}
