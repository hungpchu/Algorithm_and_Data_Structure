package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class queue_init
{
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);

        while(!queue.isEmpty()){
            System.out.print(queue.peek() + ",");
            queue.remove();
        }
    }
}
