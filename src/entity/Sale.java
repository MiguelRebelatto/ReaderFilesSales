package entity;

import java.math.BigDecimal;

public class Sale {
    private Long id;
    private BigDecimal total;
    private String seller;

    public Sale(Long id, BigDecimal total, String seller) {
        this.id = id;
        this.total = total;
        this.seller = seller;
    }

    public void increaseAmount(BigDecimal amount) {
        this.total = this.total.add(amount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }


}
