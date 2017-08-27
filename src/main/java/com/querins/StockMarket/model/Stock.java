package com.querins.StockMarket.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by roman on 25.08.17.
 */
@Entity
public class Stock {

    @Id
    private long id;

    @Column(unique=true, name="TITLE")
    private String title;

    @Column(name = "format", updatable = false)
    private final int precision;

    private Stock() { precision = 2; }

    public Stock(String title, int precision) {

        this.title = title;
        this.precision = precision;

    }

}
