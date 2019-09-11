package Queue;

import Stack.MinStack;

import java.util.LinkedList;
import Stack.MinStack;

public class queueImplement<T> {

    public int queueSize;
    public QueueElement head;
    public QueueElement last;

    class QueueElement{

        int value;
        QueueElement next;
         int min;
        int max;

        public QueueElement(int value){
            this.value = value;
            next = null;
            min = value;
            max = value;
        }
    }

    MinStack<QueueElement> minStack;
    LinkedList<QueueElement> queue;
    public queueImplement(){
         queue = new LinkedList<>();
    }
    public void printQueue(){
    while(head != null){
        System.out.print(head.value + " ");
        head = head.next;
    }
    System.out.println();
    }
    public int getSize(){ return queueSize;}

    public boolean isEmpty() {return queueSize == 0;}

    public void enQueue(int val){
        if(isEmpty()){
            head = new QueueElement(val);
            last = head;
            last.min = val;
            last.max = val;
            queue.add(head);
        }else{
            int min = last.min;
            int max = last.max;
            QueueElement newElement = new QueueElement(val);
            last.next = newElement;
            last = newElement;
            QueueElement top = queue.getFirst();
            if(top.min < val){
                newElement.min = top.min;
            }
            if(top.max > val){
                newElement.max = top.max;
            }


        }
        queueSize++;
    }

    public QueueElement peek(){
        return last;
    }

    public int getMin(){
        return queue.getFirst().min;
    }
    public int getMax(){
        return queue.getFirst().max;
    }

    public QueueElement dequeue(){
        QueueElement oldHead;
        if(isEmpty()){
            return null;
        }else{
           oldHead = head;
            head = head.next;
            queueSize--;
        }
        return oldHead;
    }

    public static void main(String[] args){
        queueImplement queue = new queueImplement();
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
//        System.out.println(queue.getMax() + " " + queue.getMin());
//        queue.dequeue();
//        System.out.println(queue.getMax() + " " + queue.getMin());
//        queue.dequeue();
        System.out.println(queue.last.max + " " + queue.last.min);
        queue.printQueue();
    }
}
