package com.vivekchutke.microservices.gradlecurrencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {

    private long id;

    private String from;

    private String to;

    private BigDecimal conversitionValue;

    private int portNumber;

    private int quantity;

    private BigDecimal totalConvertedAmount;

    public CurrencyConversionBean() {

    }

    public CurrencyConversionBean(String from, String to, BigDecimal conversitionValue, int portNumber, int quantity, BigDecimal totalConvertedAmount) {
        this.from = from;
        this.to = to;
        this.conversitionValue = conversitionValue;
        this.portNumber = portNumber;
        this.quantity = quantity;
        this.totalConvertedAmount = totalConvertedAmount;
    }

    @Override
    public String toString() {
        return "CurrencyConversionBean{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversitionValue=" + conversitionValue +
                ", portNumber=" + portNumber +
                ", quantity=" + quantity +
                ", totalConvertedAmount=" + totalConvertedAmount +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversitionValue() {
        return conversitionValue;
    }

    public void setConversitionValue(BigDecimal conversitionValue) {
        this.conversitionValue = conversitionValue;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalConvertedAmount() {
        return totalConvertedAmount;
    }

    public void setTotalConvertedAmount(BigDecimal totalConvertedAmount) {
        this.totalConvertedAmount = totalConvertedAmount;
    }
}
