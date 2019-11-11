package DynamicProgramming;

import java.util.HashMap;

public class knapsackProb {

    public HashMap<Integer,Pair> hm;
    public static int max;

    class Pair{
        public int value;
        public int weight;

        Pair(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }

    public knapsackProb(int numberItem,int weight){
        //initialize value pair item number with array of value and weight
        hm = new HashMap<>();
        hm.put(1,new Pair(1,1));
        hm.put(2,new Pair(6,2));
        hm.put(3,new Pair(18,5));
        hm.put(4,new Pair(444,6));
        hm.put(5,new Pair(28,7));
        System.out.println("Max total value is " + maxTotalValue(numberItem,weight,0));
        System.out.println("Max total value using dynamic is " + maxTotalValueDynamic(numberItem,weight));
    }

    /***
     * Bottom up algorithm -> fill from the base case with 0 value and 0 weight
     */
    public int maxTotalValueDynamic(int numberItem, int weight){

        int[][] knapSack = new int[numberItem+1][weight+1];
        // 0 item then 0 weight and 0 value
        for(int i = 0; i <= numberItem;i++) knapSack[i][0] = 0;
        // 0 weight then 0 value and 0 item
        for(int j = 0; j <= weight;j++) knapSack[0][j] = 0;
        // loop through all the item
        for( int i = 1; i <= numberItem;i++ ){
            // take the currentValue from the hm
            int currentValue = hm.get(i).value;
            // take the currentWeight from the hm
            int currentWeight = hm.get(i).weight;
            for(int j = 1; j <= weight;j++){
                // if the current weight is not bigger then the item weight then take value from
                // previous set of item
                if(j < currentWeight) knapSack[i][j] = knapSack[i - 1][j];
                // if the weight of current item is bigger then the current weight then take it into consider
                // with value of this item + the previous value at this weight without this item
                // then take the max value with the previous value at this weight without new item
                else knapSack[i][j] = Math.max(currentValue + knapSack[i][j - currentWeight],knapSack[i-1][j]);
            }
        }
        return knapSack[numberItem][weight];
    }

    /***
     * Bottom-up recursive -> post order traverse from the bottom up
     * -> choose from item 1 to 5
     */
    public int maxTotalValue(int item, int weight,int max){
        // base case
        if(item == 0) return max;
        // traverse all the way down to the item 0
        int maxSmall = maxTotalValue(item - 1,weight,max);
        int currentMax = 0;
        // check if we can build currentMax with value of this item
        if(weight - hm.get(item).weight >= 0) currentMax = hm.get(item).value + maxTotalValue(item - 1,weight - hm.get(item).weight,max);
        // check max between current Max and maxSmall
        max = Math.max(maxSmall,currentMax);
        // return max
        return max;
    }

    public static void main(String[] args){
        knapsackProb kn = new knapsackProb(5,11);
    }

}
