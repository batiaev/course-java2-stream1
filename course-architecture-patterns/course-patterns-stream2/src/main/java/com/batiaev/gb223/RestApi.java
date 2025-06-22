package com.batiaev.gb223;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestApi
 *
 * @author anton
 * @since 16/07/19
 */
@RestController
public class RestApi {

    @GetMapping("/")
    public String root() {
        return "Hello world";
    }

    @GetMapping("/card/{id}")
    public BankCard card(@PathVariable("id") String id) {
        return new BankCard(id, 1000);
    }
}
