package Util;

public class CurrencyUtils {
    public static Double StringCurrencyToInt(String price){
        price = price.replace(".","").replace("TL","").replace(",",".").replace(" ","");
        System.out.println(price);
        return Double.parseDouble(price);
    }
}
