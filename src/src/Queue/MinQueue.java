package Queue;

import java.util.LinkedList;

public class MinQueue<T> {

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

    LinkedList<QueueElement> queue;
    public MinQueue(){
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
        MinQueue minQueue = new MinQueue();
        minQueue.enQueue(2);
        minQueue.enQueue(3);
        minQueue.enQueue(4);
        minQueue.enQueue(44);
        minQueue.dequeue();

        System.out.println(minQueue.last.max + " " + minQueue.last.min);
        minQueue.printQueue();
    }
}
