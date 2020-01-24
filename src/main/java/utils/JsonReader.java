package utils;

import Entity.ExchangeRate;
import com.google.gson.Gson;
import service.Exchange;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class JsonReader {








    public ExchangeRate parseJson(String lastDate) throws IOException {









        ExchangeRate exchangeRate = new ExchangeRate();
        URL url = new URL("https://api.privatbank.ua/p24api/exchange_rates?json&date="+lastDate);

       
        InputStreamReader reader = new InputStreamReader(url.openStream());


        Exchange exchange = new Gson().fromJson(reader, Exchange.class);
      //  System.out.println(exchange);


        int indexUSD = 1;
        for (int j = 0; j < exchange.getExchangeRate().size(); j++) {
            if (exchange.getExchangeRate().get(j).getCurrency() != null && exchange.getExchangeRate().get(j).getCurrency().equals("USD")) {
                indexUSD = j;
                break;
            }
        }

        int indexEur = 1;
        for (int j = 0; j < exchange.getExchangeRate().size(); j++) {
            if (exchange.getExchangeRate().get(j).getCurrency() != null && exchange.getExchangeRate().get(j).getCurrency().equals("EUR")) {
                indexEur = j;
                break;
            }
        }

         exchangeRate.setUsd(String.valueOf(exchange.getExchangeRate().get(indexUSD).getSaleRateNB()));
         exchangeRate.setEur(String.valueOf(exchange.getExchangeRate().get(indexEur).getSaleRateNB()));






        return exchangeRate;
    }

}
