package LinkedList;

public class LinkedList {

    // properties belong to LinkedList class
    private static Node head;
    private static int numNodes;


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

    public static void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args){

    LinkedList ll = new LinkedList();
    ll.addAtHead(1);
    ll.addAtTail(2);
    ll.addAtTail(3);

    ll.printList();

        }


}
