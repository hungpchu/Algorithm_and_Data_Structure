package Queue;

import Stack.Stack;

/***
 * insert + remove:O(1)
 * Add at the end
 * Remove at the beginning
 */
public class Queue<Item> extends Stack {

    // keep track of the beginning
    public Node first;
    public Node last;
    public int size;

    public void enqueue(Item item){
        size++;
        Node newNode = new Node(item);
        // if first is null the create first
        if(first == null)first = newNode;
        else{
            // if last is null then create last
            // and add first to next
            if (last == null){
                last = newNode;
                first.next = last;
            }
            // if lst not null then add new node to last
            // then last will be last.next
            else{
                last.next = newNode;
                last = last.next;
            }
        }
    }

    // dequeue at the beginning
    public Node dequeue(){
        Node deleteNode = first;
        if(first == null) return null;
        else{
            size--;
            first = first.next;
        }
        return deleteNode;
    }

    public void show(){
        Node current = first;
        System.out.print("The queue with the size of " + size + " looks like = ");
        while(current != null){
            System.out.print(current.item + ",");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Queue<Integer> queue = new Queue();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(69);
        queue.enqueue(6968);
        queue.show();


    }
}
