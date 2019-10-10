package GoogleInterviewPractice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CurrencyExchange {
    public HashMap<String,Boolean> marked;
    public HashMap<String,Currency> currencyTo;

    public CurrencyExchange(CurrencyList currencyList, String currencyName,String currencyResultName){
        marked = new HashMap<>();
        currencyTo = new HashMap<>();
        bfsCurrencyExchange(currencyList,currencyName,currencyResultName);
    }

    public void bfsCurrencyExchange(CurrencyList currencyList, String currencyName, String currencyResultName){
        marked.put(currencyName,true);
        Queue<String> queue = new LinkedList<>();
        queue.add(currencyName);
        while(!queue.isEmpty()){
            currencyName = queue.remove();
            if(currencyName.compareTo(currencyResultName) == 0 && marked.containsKey(currencyName)) return;

            if  (currencyList.adjacency.get(currencyName) == null) return;
                for (Currency currAdj : currencyList.adjacency.get(currencyName)) {

                    if (!marked.containsKey(currAdj.name)) {
                        marked.put(currAdj.name, true);
                        Currency start = new Currency(currencyName,currAdj.ratio);
                        currencyTo.put(currAdj.name,start);
                        queue.add(currAdj.name);
                    }
                }

        }

    }

    public boolean canExchange(String currency){
        if(currencyTo.containsKey(currency)) return true;
        else return false;
    }

    public double exchangeCurrencyFrom(String currencyName,String currencyResultName){
        if (currencyName.compareTo(currencyResultName) == 0) return 1.0;
        if(!canExchange(currencyResultName)) return -1;
        double result = currencyTo.get(currencyResultName).ratio;
        Currency curr = currencyTo.get(currencyResultName);
        if(curr.name.compareTo(currencyName) == 0) return result;
        do{
            curr = currencyTo.get(curr.name);
            if(curr == null) return -1;
            result *= curr.ratio;
        }
        while(curr.name.compareTo(currencyName) != 0);

        return result;
    }
}
