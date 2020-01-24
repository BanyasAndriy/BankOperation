package ado;

import Entity.Account;
import Entity.User;
import adoImp.AccountImpl;

import java.util.List;

public interface AccountAdo {

public void addAccount(Account account);
    public List<AccountImpl> getAllAccount();
    public Account getAccountByCard(String card);
    public boolean addMoneyToTheCard( String card ,String currency , double amount);
    public boolean sendMoneyToAnotherCard(String yourCard, String anotherCard,String currency ,double amount);
    public boolean isEnoughMoneyToSend(String card , double amount,String currency);
    public User getUserByCard(String card);
    public boolean convertCurrency(String fromWhichCurrency , String toWhichCurrency , double amount,String card);
    public double getAllMoneyInUan(String card);
}
