package effectivejava.chapter9.item60;

import java.math.BigDecimal;

public class BigDecimalChange {
    public static void main(String[] args) {
        var TEN_CENTS = new BigDecimal(".10");

        var itemsBought = 0;
        var funds = new BigDecimal("1.00");
        for (var price = TEN_CENTS;
             funds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Money left over: $" + funds);
    }
}
