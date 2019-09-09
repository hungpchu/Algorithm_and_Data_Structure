package LinkedList;


public class Reverse_LinkedList {



    public static void main(String[] args){

        LinkedListImplementation ll = new LinkedListImplementation();
        ll.addAtHead(1);
        ll.addAtTail(2);
        ll.addAtTail(3);

        LinkedListImplementation ll1 = new LinkedListImplementation();
        ll1.addAtHead(4);
        ll1.addAtTail(5);
        ll1.addAtTail(6);
        ll1.addAtTail(7);


        ll.printList();
        ll1.printList();
    }

}
