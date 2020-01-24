package ado;

import Entity.ExchangeRate;

public interface ExchangeRateAdo {

     public ExchangeRate getRateByDate(String data);
    public boolean updateData();
    public ExchangeRate getAllDate();

}
