package com.querins.StockMarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by roman on 03.07.17.
 */
@Controller
public class MainController {

    @GetMapping({"/", "/home"})
    String home() {
        return "index";
    }

}
