package googleTechChallenge;

public class divide {

    public static void main(String[] args){
        int count = 0;
        for(int i = 1; i < 5001; i++){
            if(i %3 == 0 ||i %7 == 0|| i % 11  ==0 ) count++;
        }

        System.out.println(count);
    }
}
