package GoogleInterviewPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyList {

    public HashMap<String,List<Currency>> adjacency;


    public CurrencyList(){
        adjacency = new HashMap<>();
    }

    public void addRatio(String c1Name,String c2Name, double ratio){
        Currency c1 = new Currency(c1Name,1/ratio);
        Currency c2 = new Currency(c2Name, ratio);
        if(!adjacency.containsKey(c1Name)){
            List<Currency> listC1 = new ArrayList<>();
            listC1.add(c2);
            adjacency.put(c1Name,listC1);
        }else{
            List<Currency> listC1  = adjacency.get(c1Name);
            listC1.add(c2);
            adjacency.put(c1Name,listC1);
        }

        if(!adjacency.containsKey(c2Name)){
            List<Currency> listC2 = new ArrayList<>();
            listC2.add(c1);
            adjacency.put(c2Name,listC2);
        }else{
            List<Currency> listC2  = adjacency.get(c2Name);
            listC2.add(c1);
            adjacency.put(c2Name,listC2);
        }

    }

    public void show(CurrencyList list){
        System.out.println("Currency List is: ");
        for(Map.Entry currency: list.adjacency.entrySet()){
            String curren = (String) currency.getKey();
            List<Currency> listCurren = (List<Currency>) currency.getValue();
            System.out.print(curren + ": ");
            for(Currency c: listCurren){
                System.out.print("(" + c.name + "," + c.ratio + ")" + "  ");
            }
            System.out.println();
        }
    }

    public void exchange(CurrencyList list, String inputCurrency, String outputCurrency){
        CurrencyExchange currencyExchange = new CurrencyExchange(list,inputCurrency,outputCurrency);
        System.out.println("The currency exchange from "+ inputCurrency  + " to " + outputCurrency + " is "
                + currencyExchange.exchangeCurrencyFrom(inputCurrency,outputCurrency));
    }



    public static void main(String[] args){
        CurrencyList list = new CurrencyList();
        list.addRatio("USD","GBP",0.69);
        list.addRatio("Meter","Yard",1.09);
        list.addRatio("YEN","EUR",0.0077);
        list.addRatio("YEN","GBP",0.0059);
        list.addRatio("HorsePower","Watt",745.7);
        list.addRatio("VND","USD",22);
        list.addRatio("VND","YEN",10);
        list.show(list);
        list.exchange(list,"VND","EUR");
    }
}
