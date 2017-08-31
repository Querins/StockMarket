package com.querins.StockMarket.services;

import com.querins.StockMarket.model.Quote;
import com.querins.StockMarket.model.Stock;
import com.querins.StockMarket.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Created by roman on 26.08.17.
 */
@Service
public class StockService {

    private SimpMessageSendingOperations template;
    private StockRepository repository;
    private static final Random r = new Random();

    @Autowired
    public StockService(StockRepository repository, SimpMessageSendingOperations template) {

        this.repository = repository;
        this.template = template;

        if( this.repository.count() == 0 ) {

            this.repository.save(new Stock("Google", 2));

        }

    }

    @Scheduled(fixedDelay = 1000)
    public void generateQuote() {

        for( Stock stock: repository.findAll() ) {

            BigDecimal price = new BigDecimal(r.nextDouble() * 100).setScale(2, RoundingMode.FLOOR);
            Quote quote = new Quote(stock, price );
            template.convertAndSend("/topic.quotes", quote);

        }

    }

}
