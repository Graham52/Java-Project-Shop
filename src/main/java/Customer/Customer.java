package Customer;

import Shop.StockItem;

import java.util.ArrayList;

public class Customer {
    private ArrayList<PaymentMethod> paymentMethods;
    private String customerName;
    private ArrayList<StockItem> shoppingCart;
    private PaymentMethod wallet;


    public Customer(String customerName, PaymentMethod paymentMethod){
        this.customerName = customerName;
        this.shoppingCart = new ArrayList<>();
        this.paymentMethods = new ArrayList<>();
        paymentMethods.add(paymentMethod);
    }

    public int getPaymentMethodsCount() {
        return this.paymentMethods.size();
    }

    public void addPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethods.add(paymentMethod);
    }

    public PaymentMethod getPaymentMethodsAtIndex(int index){
        return this.paymentMethods.get(index);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getShoppingCartItemCount() {
        return shoppingCart.size();
    }

    public void clearShoppingCart() {
        this.shoppingCart.clear();
    }

    public void addItemToShoppingCart(StockItem item){
        this.shoppingCart.add(item);
    }

    public void removeItemFromShoppingCart(StockItem item) {
        this.shoppingCart.remove(item);
    }

    public ArrayList<StockItem> getShoppingCart() {
        return shoppingCart;
    }

    public PaymentMethod getPaymentMethod(String paymentMethodType) {
        for (PaymentMethod paymentMethod: paymentMethods){
            if (paymentMethod.getType().equals(paymentMethodType)){
                return paymentMethod;
            }
        }
        return null;
    }

    public void pay(double price, String paymentMethodType) {
        PaymentMethod paymentMethod = getPaymentMethod(paymentMethodType);
        if (paymentMethod.getBalance() >= price){
            paymentMethod.debit(price);
        }


    }
}
