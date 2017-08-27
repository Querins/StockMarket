package com.querins.StockMarket.repositories;

import com.querins.StockMarket.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by roman on 26.08.17.
 */
public interface StockRepository extends CrudRepository<Stock, Long> {
}
