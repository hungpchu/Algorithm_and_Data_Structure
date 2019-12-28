package Array;

import java.util.HashMap;
import java.util.PriorityQueue;

public class reorderLogFiles {

    // time: O(N)
    // space: O(N) using PQ and HashMap
    public static  String[] reorderLogFiles(String[] logs) {
        HashMap<String,String> hm = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> a.compareTo(b));
        int index = 0;
        // process the string array
        for(int i = 0; i < logs.length; i++){
            String[] proLog = logs[i].trim().split(" ");
            if(Character.isDigit(proLog[1].charAt(0)))  index = i;
            else{
                int in = logs[i].indexOf(' ');
                String newS = logs[i].substring(in+1,logs[i].length()) + " " + logs[i].substring(0,in+1);
                hm.put(newS,logs[i]);
                pq.add(newS);
                logs[i] = null;
            }
        }
        int in = logs.length - 1;
        // process digit log
        for(int i = logs.length - 1; i >= 0; i--){
            if(logs[i] != null){
                logs[in] = logs[i];
                in--;
            }
        }

        for(int i = 0; i <= in; i++){
            String charLog = pq.remove();
            logs[i] =  hm.get(charLog);
        }


        return logs;
    }

    public static void main(String[] args){
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        for(String log: reorderLogFiles(logs) ) System.out.println(log);
    }
}
