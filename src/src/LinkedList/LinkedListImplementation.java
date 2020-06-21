package LinkedList;

public class LinkedListImplementation {

    // properties belong to LinkedList class
    private  Node head;
    public  int numNodes;

class Node
{
    //Properties belong to class Node
    // current node will have node next as one of the properties
    private Node next;
    // data will belong to newly created node
    private Object data;

    // constructing new Node and
    public Node(Object dat)
    {
        data = dat;
    }

    // method for class Node
    public Object getData()
    {
        return data;
    }
}

public Node createNode(Object dat){
    Node newNode = new Node(dat);
    return newNode;

}


    public void addAtHead(Object dat)
    {
        Node temp = head;
        head = new Node(dat);
        head.next = temp;
        numNodes++;
    }

    public void addAtTail(Object dat)
    {
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new Node(dat);
        numNodes++;
    }

    public  void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /***
     * Have 3 node current, next and prev
     */
    public  void reverse(){
       Node current = head;
       Node prev = null;
       Node next = null;
       while(current != null){
           // update next to next of current
           next = current.next;
           // point current backward
           current.next = prev;
           // update prev to current for future
           prev = current;
           // update current point to forward
           current = next;
       }
       // update head to prev which = current
       head = prev;

    }

    public  Object middleNode(){
        Node slow = head;
        Node fast = head;
        while( fast.next != null ){
            slow = slow.next;
            if (fast.next.next != null){
                fast = fast.next.next;
            }else fast = fast.next;
        }

        return slow.getData();
    }

    public  Node  getMiddleNode(Node head){
        if (head == null) return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /***
     *
     * @param head1
     * @param head2
     * @return head of the new linkedlist represent the sum of
     */
    public Node add2Number(Node head1, Node head2){
        if (head1 == null) return head2;
        if (head2 == null ) return head1;

        Node result = new Node(0);
        Node resultHead = result;

        int sum = 0;
        Node newNext;

        while(head1 != null && head2 != null){
            int num1 = (int) head1.getData();
            int num2 = (int) head2.getData();
            sum = sum + num1 + num2;
            if(sum > 9){
                newNext = new Node(sum % 10);
                sum = sum /10;
            }else {
                 newNext = new Node(sum);
                 sum = 0;
            }
            result.next = newNext;
            result = newNext;
            head1 = head1.next;
            head2 = head2.next;
        }

        if(sum != 0){
            newNext = new Node(sum);
            result.next = newNext;
        }

        return resultHead.next;
    }


    public int sizeRecursion(Node head){
        if(head == null){
            return 0;
        }
        return sizeRecursion(head.next) + 1;
    }


    public Node mergeSort(Node head){
        if (head == null || head.next == null) return head;
        Node middle = getMiddleNode(head);
        Node middleNext =  middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(middleNext);

        Node result = sortedMerge(left,right);
        return result;

    }

    public Node sortedMerge(Node a, Node b)
    {
         Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;
        /* Pick eitheq
        r a or b, and recur */
        if ((int)a.data <= (int)b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public Node merge(Node left, Node right){
        if(left == null) return right;
        if(right == null ) return left;
        Node result = null;
            if ( (int) left.data < (int) right.data) {
                result = left;
                result.next = merge(left.next,right);
            }else{
                result = right;
                result.next = merge(right.next,left);
            }

        return result;
    }





    public static void main(String[] args) {

        LinkedListImplementation ll = new LinkedListImplementation();
        ll.addAtHead(8);
        ll.addAtTail(7);
        ll.addAtTail(4);

        ll.mergeSort(ll.head);
        ll.printList(ll.head);

//        LinkedListImplementation ll1 = new LinkedListImplementation();
//        ll1.addAtHead(4);
//        ll1.addAtTail(7);
//        ll1.addAtTail(6);
//
//
//        ll.printList();
//        ll1.printList();
//
//        Node result = ll.add2Number(ll1.head,ll.head);
//        System.out.println(ll1.sizeRecursion(result));
//        while(result != null){
//            System.out.print(result.getData() + " ");
//            result = result.next;
//        }
    }

}
