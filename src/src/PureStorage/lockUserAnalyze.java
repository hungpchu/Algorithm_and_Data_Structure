package PureStorage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class lockUserAnalyze {


    public static int check_log_history(List<String> events) {
        Stack<String> stack = new Stack<>();
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < events.size(); i++  )
        {
            String[] eventToArray = events.get(i).split(" ");
            String action = eventToArray[0];
            String id = eventToArray[1];

            if ( action.equals("ACQUIRE")  )
            {
                if ( hs.contains(id) ) return i + 1;
                hs.add(id);
                stack.push(id);
            }else
            {
                if ( !hs.contains(id) || !id.equals( stack.peek() ) ) return i + 1;
                stack.pop();
                hs.remove(id);
            }
        }

        return  ( stack.size() > 0 ) ?  events.size() + 1 : 0;
    }
    public static void main ( String[] args)
    {
        List<String> events = new ArrayList<>();
//        events.add("ACQUIRE 123");
//        events.add("ACQUIRE 364");
//        events.add("ACQUIRE 84");
//        events.add("RELEASE 84");
//        events.add("RELEASE 364");
//        events.add("ACQUIRE 789");
//        events.add("RELEASE 456");
//        events.add("RELEASE 123");

        events.add("ACQUIRE 364");
        events.add("ACQUIRE 84");
        events.add("ACQUIRE 364");
        events.add("RELEASE 364");

        System.out.println("Final result = " + check_log_history(events));

    }

}
