package com.vivekchutke.microservices.gradlecurrencyconversionservice.controller;

import com.vivekchutke.microservices.gradlecurrencyconversionservice.bean.CurrencyConversionBean;
import com.vivekchutke.microservices.gradlecurrencyconversionservice.proxy.CurrencyExchangeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConverstionController {

    @Autowired
    public CurrencyExchangeProxy currencyExchangeProxy;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean retrieveCurrencyCoversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<String, String>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionBean.class, uriVariables);


        CurrencyConversionBean currencyConversionBean =  responseEntity.getBody();
        currencyConversionBean.setQuantity(quantity.intValue());
        currencyConversionBean.setTotalConvertedAmount(quantity.multiply(currencyConversionBean.getConversitionValue()));

        logger.info("Currency Conversion value is: {}", currencyConversionBean);
        return currencyConversionBean;
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean retrieveCurrencyConversionThroughProxy(@PathVariable String from,
                                                                         @PathVariable String to,
                                                                         @PathVariable BigDecimal quantity){
        CurrencyConversionBean currencyConversionBean = currencyExchangeProxy.retrieveExchangeValue(from,to);
        currencyConversionBean.setQuantity(quantity.intValue());
        currencyConversionBean.setTotalConvertedAmount(quantity.multiply(currencyConversionBean.getConversitionValue()));
        logger.info("Retrieved Exchange value is: "+currencyConversionBean);
        return currencyConversionBean;

    }
}
