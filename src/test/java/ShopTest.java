import Shop.*;
import Customer.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private Shop shop;
    private StockItem item;
    private StockItem item2;
    private Customer customer;
    private Customer customer2;
    PaymentMethod paymentMethod;

    @Before
    public void before() {
        paymentMethod = new PaymentMethod("Visa", 330);
        shop = new Shop(500.00, 200, 100);
        customer = new Customer("Jack",  paymentMethod);
        customer2 = new Customer("John", paymentMethod);
        item = new StockItem("Shirt", 50.0, 25.0);
        item2 = new StockItem("Jeans", 60.0, 20.0);

    }

    @Test
    public void getTillValue() {
        assertEquals(500.00, shop.getTillValue(), 0.01);
    }

    @Test
    public void setTillValue() {
        shop.setTillValue(450.00);
        assertEquals(450.00, shop.getTillValue(), 0.01);
    }

    @Test
    public void canAddMoneyToTill() {
        shop.addMoneyToTill(500.00);
        assertEquals(1000.00, shop.getTillValue(), 0.01);
    }

    @Test
    public void canRemoveMoneyFromTill(){
        shop.removeMoneyFromTill(50.00);
        assertEquals(450.00, shop.getTillValue(), 0.01);
    }

    @Test
    public void canCheckOut() {
        customer.addItemToShoppingCart(item);
        shop.checkOut(customer, "Visa");
        assertEquals(280.00, customer.getPaymentMethod("Visa").getBalance(), 0.01);
        assertEquals(550.00, shop.getTillValue(), 0.01);
        assertEquals(0, customer.getShoppingCartItemCount());
    }

    @Test
    public void canRefundShoppingCart() {
        customer.addItemToShoppingCart(item);
        shop.refundShoppingCart(customer, "Visa");
        assertEquals(380.00, customer.getPaymentMethod("Visa").getBalance(), 0.01);
        assertEquals(450.00, shop.getTillValue(), 0.01);
        assertEquals(0, customer.getShoppingCartItemCount());

    }

    @Test
    public void salesMinusRefunds() {
        customer.addItemToShoppingCart(item);
        customer2.addItemToShoppingCart(item2);
        customer.removeItemFromShoppingCart(item);
        shop.checkOut(customer, "Visa");
        assertEquals(500.00, shop.getTillValue(), 0.01);
    }
}
