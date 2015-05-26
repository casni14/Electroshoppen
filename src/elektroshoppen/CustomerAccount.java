package elektroshoppen;

/**
 *
 * @author Bogs
 */
public class CustomerAccount {
   static int ACCOUNTS = 0;
   private ShoppingCart cart;
   private int accountNumber;
   
   // Try Push

public CustomerAccount() {
    accountNumber = ACCOUNTS;
    incrementACCOUNTS();
    cart = new ShoppingCart();
}
private static void incrementACCOUNTS() {
    ACCOUNTS++;
}
public ShoppingCart getCart() {
    return cart;
}
    
}
