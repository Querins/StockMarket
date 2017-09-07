package com.querins.StockMarket.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by roman on 25.08.17.
 */
@Entity
public class Quote {

    @Id
    long Id;

    @Column(nullable = false, updatable = false)
    private BigDecimal price;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_time", nullable = false, updatable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Stock.class)
    @JoinColumn(name="stock_id")
    private Stock stock;

    private Quote() {}

    public Quote(Stock stock, BigDecimal price) {
        this.price = price;
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Stock getStock() {
        return stock;
    }
}
