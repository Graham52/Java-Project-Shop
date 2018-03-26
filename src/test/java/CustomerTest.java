import Customer.*;
import Shop.StockItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    StockItem item;
    PaymentMethod paymentMethod;


    @Before
    public void before(){
        paymentMethod = new PaymentMethod("Visa", 330.00);
        customer = new Customer("John Doe", paymentMethod);
        item = new StockItem("Jeans", 100.00, 50.00 );
    }

    @Test
    public void hasNumberOfEntries(){
        assertEquals(1, customer.getPaymentMethodsCount());
    }

    @Test
    public void canAddPaymentMethodToArray(){
        customer.addPaymentMethod(paymentMethod);
        assertEquals(2, customer.getPaymentMethodsCount());
    }

    @Test
    public void canGetFirstPaymentMethod(){
        customer.addPaymentMethod(paymentMethod);
        assertEquals("Visa", customer.getPaymentMethodsAtIndex(0).getType());
    }

    @Test
    public void canGetSpecificPaymentMethodByType(){
        PaymentMethod expected = customer.getPaymentMethod("Visa");
        assertEquals(expected, paymentMethod);
    }

    @Test
    public void getCustomerName() {
        assertEquals("John Doe", customer.getCustomerName());
    }

    @Test
    public void setCustomerName() {
        customer.setCustomerName("Jane Doe");
        assertEquals("Jane Doe", customer.getCustomerName());
    }

    @Test
    public void getShoppingCart() {
        ArrayList<StockItem> expected = new ArrayList<>();
        assertEquals(expected,customer.getShoppingCart());
    }

    @Test
    public void customersShoppingCartStartsEmpty(){
        assertEquals(0, customer.getShoppingCartItemCount());
    }

    @Test
    public void canAddItemToShoppingCart(){
        customer.addItemToShoppingCart(item);
        assertEquals(1, customer.getShoppingCartItemCount());
    }

    @Test
    public void canRemoveItemFromShoppingCart(){
        customer.addItemToShoppingCart(item);
        assertEquals(1, customer.getShoppingCartItemCount());
        customer.removeItemFromShoppingCart(item);
        assertEquals(0, customer.getShoppingCartItemCount());
    }

    @Test
    public void getShoppingCartItemCount() {
        customer.addItemToShoppingCart(item);
        assertEquals(1, customer.getShoppingCartItemCount());
    }

    @Test
    public void canPayWithSpecificPaymentMethod(){
        customer.pay(100.00, "Visa");
        // shop sell price is 100
        // Visa starts with 330 available
        assertEquals(230.00, customer.getPaymentMethod("Visa").getBalance(), 0.01);
    }
}
