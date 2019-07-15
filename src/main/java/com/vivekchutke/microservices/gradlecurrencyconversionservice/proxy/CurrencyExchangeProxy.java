package com.vivekchutke.microservices.gradlecurrencyconversionservice.proxy;

import com.vivekchutke.microservices.gradlecurrencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="CFGradleCurrencyExchangeService", url="localhost:8000")
@FeignClient(name="CFGradleCurrencyExchangeService")
@RibbonClient(name="CFGradleCurrencyExchangeService")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}