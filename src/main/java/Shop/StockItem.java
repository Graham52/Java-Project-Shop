package Shop;

public class StockItem {

    private String item;
        private double sellPrice;
        private double buyPrice;

        public StockItem(String item, double sellPrice, double buyPrice) {
            this.item = item;
            this.sellPrice = sellPrice;
            this.buyPrice = buyPrice;
        }


        public String getItem() {
            return this.item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public double getSellPrice() {
            return this.sellPrice;
        }

        public void setSellPrice(double sellPrice) {
            this.sellPrice = sellPrice;
        }

        public double getBuyPrice() {
            return this.buyPrice;
        }

        public void setBuyPrice(double buyPrice) {
            this.buyPrice = buyPrice;
        }
}
