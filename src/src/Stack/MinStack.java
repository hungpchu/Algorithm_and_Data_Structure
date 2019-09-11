package Stack;

import java.util.LinkedList;

public class MinStack<T> {

    class MinStackNode {
        int val;
        MinStackNode nextMin;
        MinStackNode nextMax;

        public MinStackNode(int val){
            this.val = val;
            nextMin = this;
            nextMax = this;
        }

    }

    /** initialize your data structure here. */
    LinkedList<MinStackNode> stack ;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        MinStackNode msn = new MinStackNode(x);
        if(stack.size() != 0){
            // get the last node from the linkedlist
            MinStackNode top = stack.getLast();
            // if the last node has smaller value then newNode.nextMin = lastNode.val
            // else if not then the newNode indeed has the smallest val. Then it will point to itself.
            if(top.nextMin.val < x){
                msn.nextMin = top.nextMin;
            }
            if(top.nextMax.val > x){
                msn.nextMax = top.nextMax;
            }
        }
        stack.add(msn);

    }

    public void pop() {
        if(stack.size() != 0){
            stack.pollLast();
        }
    }

    public int top() {

        if(stack.size() != 0){
            return stack.getLast().val;
        }
        return Integer.MIN_VALUE;
    }

    /***
     * min = val of the last value's next Min
     * @return
     */
    public int getMin() {

        if(stack.size() != 0){
            return stack.getLast().nextMin.val;
        }
        return Integer.MIN_VALUE;
    }

    public int getMax(){
        if(stack.size() != 0) return stack.getLast().nextMax.val;
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args){
        MinStack min = new MinStack();
        min.push(3);
        min.push(4);
        min.push(10);
        min.push(6);
        min.push(40);
        min.push(1);
        min.pop();
       System.out.println( min.getMin());
        System.out.println( min.getMax());
    }


}



