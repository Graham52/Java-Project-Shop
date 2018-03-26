package Shop;

import java.util.ArrayList;

public class Stock<I> {
        private StockItem stockItem;
        private ArrayList<StockItem> stock;


    public Stock() {
        this.stock = new ArrayList<>();
    }

    public void addStock(StockItem item) {
        this.stock.add(item);
    }

    public void removeStock(StockItem item) {
        this.stock.remove(item);
    }

    public int getStockItemCount() {
        return this.stock.size();
    }
}
