import Shop.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockItemTest {

    Shop shop;
    Stock stock;
    private StockItem item;


    @Before
    public void before() {
        item = new StockItem("JEANS",100,50);
        stock = new Stock();
    }

    @Test
    public void getItem() {
        assertEquals("JEANS", item.getItem());
    }

    @Test
    public void setItem() {
        item.setItem("POLO SHIRT");
        assertEquals("POLO SHIRT", item.getItem());
    }

    @Test
    public void hasSellPrice(){
        assertEquals(100.00, item.getSellPrice(), 0.01);
    }

    @Test
    public void setSellPrice(){
        item.setSellPrice(150.00);
        assertEquals(150.00, item.getSellPrice(),0.01);
    }

    @Test
    public void hasBuyPrice(){
        assertEquals(50.00, item.getBuyPrice(),0.01);
    }

    @Test
    public void setBuyPrice(){
        item.setBuyPrice(75.00);
        assertEquals(75.00, item.getBuyPrice(),0.01);
    }

    @Test
    public void customersStockStartsEmpty(){
        assertEquals(0, stock.getStockItemCount());
    }

    @Test
    public void canAddStockToShop() {
        stock.addStock(item);
        assertEquals(1, stock.getStockItemCount());
    }

    @Test
    public void canRemoveStockFromShop() {
        stock.addStock(item);
        assertEquals(1, stock.getStockItemCount());
        stock.removeStock(item);
        assertEquals(0, stock.getStockItemCount());
    }
}
