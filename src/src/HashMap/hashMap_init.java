package HashMap;

import java.util.HashMap;
import java.util.Map;



public class hashMap_init {



    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("hung", 1997);
        hm.put("chu", 1998);
        hm.remove("hung");
        hm.size();

        for(Map.Entry<String,Integer> entry: hm.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
            if(hm.containsKey("hung")) System.out.println(hm.get("hung"));
        }

        System.out.println("number = " +  (-21 & Integer.MAX_VALUE));
        System.out.println("int max = " + Integer.MAX_VALUE);
        System.out.println("pow = " + Math.pow(2,31));
    }
}
