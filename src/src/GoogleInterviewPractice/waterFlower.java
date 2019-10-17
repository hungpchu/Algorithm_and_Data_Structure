package GoogleInterviewPractice;

public class waterFlower {

    // time = O(n)
    // space = O(1)
    public static int waterFlower(int[] plants, int capacity1, int capacity2){
        if(plants.length == 0) return 0;
        // 2nd Base case: if there is only 1 plant and me or my friend can flower it then
        if((plants[0] <= Math.max(capacity1,capacity2)) && plants.length == 1 ) return 1;

        // initizalized value for refillTIme will be 2 since both of us
        // have to refill water at the beginning
        int canMe = capacity1, canFriend = capacity2, refillTime = 2;
        // me start at the index 0 and my friend start at the last index
        int me = 0, friend = plants.length - 1;
        // middle will be half the distance from my friends
        int middle = plants.length / 2;

        /*** Me and my friend will go to each portion of us
         *  to water out plants and stop when we reach to the middle
         */
        while(me < middle) {
            // check for my case
            // if myCan has enough water for the current plant
            // then water this plant and deduct the water used from
            // canMe(myCan)
            if (canMe >= plants[me]) canMe -= plants[me];
                // else if the plant need more water from canMe
            else{
                // refill canMe to my capacity
                canMe = capacity1;
                // deduct the water used from this can
                canMe -= plants[me];
                // increase the refillTime
                refillTime++;
            }
            // check for my friend case
            // same concept for my friend
            if (canFriend >= plants[friend]) canFriend -= plants[friend];
            else{
                canFriend = capacity2;
                canFriend -= plants[friend];
                refillTime++;
            }
            // I go up from the beginning to the middle
            me++;
            // my friend goes from bottom to the middle
            friend--;
        }

        System.out.println(" me = " + me);
        // check the middle plant if the garden size is odd
        // else if the garden size is even then we are done
        // if both canMe and canFriend has not enough water the one of us has
        // to go and refill the water
        if( plants.length % 2 != 0 && canFriend + canMe < plants[middle]) refillTime++;
        // return the refillTime for both me and my friend
        return refillTime;
    }



    public static void main(String[] args){
        int[] plants = {2,4,5,1,2};
        int[] plants2 = {15,15,15,2, 4, 5, 1, 1, 2,1,2,3,4,11,10,2,5,4,3,5,6,3,4};
        int capacity1 = 15, capacity2 = 12;
        System.out.println("Refilltime = "+ waterFlower(plants2,capacity1,capacity2));

    }
}
