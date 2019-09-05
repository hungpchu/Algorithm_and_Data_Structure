package Array;

import java.util.ArrayList;

public class dynamic_array_initialization {

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) +  ",");
        }

    }
}
