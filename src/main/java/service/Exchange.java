package service;

import Entity.ExchangeRate;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Exchange {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("bank")
    @Expose
    private String bank;
    @SerializedName("baseCurrency")
    @Expose
    private Integer baseCurrency;
    @SerializedName("baseCurrencyLit")
    @Expose
    private String baseCurrencyLit;
    @SerializedName("exchangeRate")
    @Expose
    private List<ExchangeRate> exchangeRate = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Exchange withDate(String date) {
        this.date = date;
        return this;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Exchange withBank(String bank) {
        this.bank = bank;
        return this;
    }

    public Integer getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Integer baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Exchange withBaseCurrency(Integer baseCurrency) {
        this.baseCurrency = baseCurrency;
        return this;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
    }

    public Exchange withBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
        return this;
    }

    public List<ExchangeRate> getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(List<ExchangeRate> exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Exchange withExchangeRate(List<ExchangeRate> exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Exchange{");
        sb.append("date='").append(date).append('\'');
        sb.append(", bank='").append(bank).append('\'');
        sb.append(", baseCurrency=").append(baseCurrency);
        sb.append(", baseCurrencyLit='").append(baseCurrencyLit).append('\'');
        sb.append(", exchangeRate=").append(exchangeRate);
        sb.append('}');
        return sb.toString();
    }
}

