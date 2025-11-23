package pizzana;
import pizzana.payments.*;
import pizzana.bills.*;
import pizzana.discounts.*;
import pizzana.observers.*;
import pizzana.payments.*;

public class Pizzana {
    public static void main(String[] args) {
        System.out.println("Welcome to Pizzana!");

        PaymentMethod payment = new MobileWalletPayment("123-456-7890");
        payment.pay(25.0);

        MenuDisplaySystem menuDisplay = new MenuDisplaySystem();
        menuDisplay.showMainMenu();
        
    }
}
