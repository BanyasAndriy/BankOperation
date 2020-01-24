package service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;


@Entity
@Table(name="exchangerate")
public class ExchangeRate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idRate;

        private String date;
        private String baseCurrency;
        private Double saleRateNB;
        private Double purchaseRateNB;
        private String currency;
        private Double saleRate;
        private Double purchaseRate;


    public ExchangeRate() {
    }

    public Integer getIdRate() {
        return idRate;
    }

    public void setIdRate(Integer idRate) {
        this.idRate = idRate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
        public String getBaseCurrency() {
            return baseCurrency;
        }

        public void setBaseCurrency(String baseCurrency) {
            this.baseCurrency = baseCurrency;
        }

        public ExchangeRate withBaseCurrency(String baseCurrency) {
            this.baseCurrency = baseCurrency;
            return this;
        }

        public Double getSaleRateNB() {
            return saleRateNB;
        }

        public void setSaleRateNB(Double saleRateNB) {
            this.saleRateNB = saleRateNB;
        }

        public ExchangeRate withSaleRateNB(Double saleRateNB) {
            this.saleRateNB = saleRateNB;
            return this;
        }

        public Double getPurchaseRateNB() {
            return purchaseRateNB;
        }

        public void setPurchaseRateNB(Double purchaseRateNB) {
            this.purchaseRateNB = purchaseRateNB;
        }

        public ExchangeRate withPurchaseRateNB(Double purchaseRateNB) {
            this.purchaseRateNB = purchaseRateNB;
            return this;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public ExchangeRate withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Double getSaleRate() {
            return saleRate;
        }

        public void setSaleRate(Double saleRate) {
            this.saleRate = saleRate;
        }

        public ExchangeRate withSaleRate(Double saleRate) {
            this.saleRate = saleRate;
            return this;
        }

        public Double getPurchaseRate() {
            return purchaseRate;
        }

        public void setPurchaseRate(Double purchaseRate) {
            this.purchaseRate = purchaseRate;
        }

        public ExchangeRate withPurchaseRate(Double purchaseRate) {
            this.purchaseRate = purchaseRate;
            return this;
        }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExchangeRate{");
        sb.append(" date='").append(date).append('\'');
        sb.append(", baseCurrency='").append(baseCurrency).append('\'');
        sb.append(", saleRateNB=").append(saleRateNB);
        sb.append(", purchaseRateNB=").append(purchaseRateNB);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", saleRate=").append(saleRate);
        sb.append(", purchaseRate=").append(purchaseRate);
        sb.append('}');
        return sb.toString();
    }
}

