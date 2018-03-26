import Shop.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockTest {
    Shop shop;
    Stock<ItemName> stock;
    private StockItem item;


    @Before
    public void before() {
        item = new StockItem("JEANS",10,5);
        stock = new Stock();
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
