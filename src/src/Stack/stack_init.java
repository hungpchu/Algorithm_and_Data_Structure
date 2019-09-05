package Stack;

import java.util.Stack;

public class stack_init {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);

        while(!stack.isEmpty()){
            System.out.print(stack.peek() + ",");
            stack.pop();
        }
    }
}
