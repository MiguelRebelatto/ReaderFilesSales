package entity;

import java.math.BigDecimal;

public class ItemSale {

    private Long id;
    private Long id_sale;
    private int amountItem;
    private BigDecimal itemPrice;
    private String sellerName;
    private BigDecimal total;

    public ItemSale(Long id, Long id_sale, int amountItem, BigDecimal itemPrice, String sellerName, BigDecimal total) {
        this.id = id;
        this.id_sale = id_sale;
        this.amountItem = amountItem;
        this.itemPrice = itemPrice;
        this.sellerName = sellerName;
        this.total = total;
    }

    public ItemSale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_sale() {
        return id_sale;
    }

    public void setId_sale(Long id_sale) {
        this.id_sale = id_sale;
    }

    public int getAmountItem() {
        return amountItem;
    }

    public void setAmountItem(int amountItem) {
        this.amountItem = amountItem;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
