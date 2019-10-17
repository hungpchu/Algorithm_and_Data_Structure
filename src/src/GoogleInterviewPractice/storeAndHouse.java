package GoogleInterviewPractice;

import java.util.Arrays;

public class storeAndHouse {

    public static int searchStore(int[] store, int lo,int hi,int house){
        int location = 9999;
        int minDistance = 9999;
        while(lo <= hi){
            int middle = (hi - lo)/2 + lo;
            if (minDistance > Math.abs(house - store[middle])){
                if(minDistance == Math.abs(house - store[lo]) && location > store[middle]) location = store[middle];
                else {
                    minDistance = Math.abs(house - store[middle]);
                    location = store[middle];
                }
//                System.out.println("a[hi] tr right = " + store[hi]);
            }
            // house go to the left
            if(store[middle] > house){
                if (minDistance > Math.abs(house - store[hi])) {
                    if(minDistance == Math.abs(house - store[hi]) && location > store[hi]) location = store[hi];
                    else{
                        minDistance = Math.abs(house - store[hi]);
                        location = store[hi];
                    }
                    // System.out.println("a[hi] tr right = " + store[hi]);
                }
                hi = middle - 1;
                // house go to the right
            }else if(store[middle] < house){
                if (minDistance >= Math.abs(house - store[lo])){
                    if(minDistance == Math.abs(house - store[lo]) && location > store[lo]) location = store[lo];
                    else {
                        minDistance = Math.abs(house - store[lo]);
                        location = store[lo];
                    }
//                System.out.println("Min= " + minDistance + "location = " + location);

                }
                lo = middle + 1;

            }else return house;
//            System.out.println("a[hi] tr right = " + store[hi] + " store[lo] = " + store[lo] + " house = " + house);






        }

        return location;
    }

    public static int[] storeAndHouse(int[] house, int[] store){

        Arrays.sort(store);
        int[] result = new int[house.length];
        for(int i = 0; i < house.length; i++){
            result[i] = searchStore(store,0,store.length - 1,house[i]);
        }

        return result;
    }

    public static void main(String[] args){
        int[] house = {5,10,17};
        int[] store = {1, 5, 20, 11, 16};

        for(int location: storeAndHouse(house,store))System.out.print(location + " ");
    }
}
