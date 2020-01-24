package adoImp;

import Entity.Account;
import Entity.ExchangeRate;
import Entity.Transaction;
import Entity.User;
import ado.AccountAdo;
import ado.ExchangeRateAdo;
import org.decimal4j.util.DoubleRounder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements AccountAdo {

   private EntityManagerFactory enf = Persistence.createEntityManagerFactory("bank");
   private EntityManager en = enf.createEntityManager();
   private EntityTransaction tr = en.getTransaction();


    @Override
    public void addAccount(Account account) {

            tr.begin();
            en.persist(account);
            tr.commit();

    }

    public List<AccountImpl> getAllAccount(){
        List<AccountImpl> result = new ArrayList<>();

        tr.begin();
        result =en.createQuery("Select a from Account a").getResultList();
        tr.commit();


        return result;
    }





    @Override
    public Account getAccountByCard(String card) {
        Account acc = null;


        tr.begin();
        acc = (Account) en.createQuery("Select acc From Account acc where acc.card='" + card + "'").getSingleResult();
        tr.commit();

        return acc;

    }
    @Override
    public boolean addMoneyToTheCard( String card ,String currency, double amount) {

        Account acc = getAccountByCard(card);



            switch (currency.toLowerCase()) {

                case ("usd"): {
                    tr.begin();
                    acc.setWalletUsd(amount + acc.getWalletUsd());
                    tr.commit();
                    break;
                }
                case ("eur"): {
                    tr.begin();
                    acc.setWalletEur(amount + acc.getWalletEur());
                    tr.commit();
                    break;
                }
                case ("uan"): {
                    tr.begin();
                    acc.setWalletUan(amount + acc.getWalletUan());
                    tr.commit();
                    break;
                }
                default:
                    System.out.println("You inputed wrong data");

            }




        return true;
    }

    @Override
    public boolean sendMoneyToAnotherCard(String yourCard, String anotherCard,String currency,double amount) {

        Account senderCard = getAccountByCard(yourCard);
        User user = getUserByCard(yourCard);
        Account recipientCard = getAccountByCard(anotherCard);
        Transaction transaction =null;
        if(isEnoughMoneyToSend(yourCard,amount,currency)){

        tr.begin();

        switch (currency.toLowerCase()){

            case("usd"):{

                senderCard.setWalletUsd(senderCard.getWalletUsd()-amount);
                recipientCard.setWalletUsd(amount+recipientCard.getWalletUsd());
                transaction = new Transaction(anotherCard,yourCard,currency,amount,LocalDate.now(),LocalTime.now(),user);
                en.persist(transaction);
                tr.commit();
                break;
            }
            case("eur"):{
                senderCard.setWalletEur(senderCard.getWalletEur()-amount);
                recipientCard.setWalletEur(amount+recipientCard.getWalletEur());
                transaction = new Transaction(anotherCard,yourCard,currency,amount,LocalDate.now(),LocalTime.now(),user);
                en.persist(transaction);
                tr.commit();
                break;
            }
            case("uan"):{
                senderCard.setWalletUan(senderCard.getWalletUan()-amount);
                recipientCard.setWalletUan(amount+recipientCard.getWalletUan());
                transaction = new Transaction(anotherCard,yourCard,currency,amount,LocalDate.now(),LocalTime.now(),user);
                en.persist(transaction);
                tr.commit();
                break;
            } default:
                System.out.println("You inputed wrong data");

                tr.commit();


        }

      }else {
            System.out.println("not money.....go to do something to get this fucking money");
        return false;
        }

return true;

    }

    @Override
    public boolean isEnoughMoneyToSend(String card , double amount,String currency) {

        Account account = getAccountByCard(card);

        switch (currency.toLowerCase()){

            case ("usd"):{
                if (account.getWalletUsd()>=amount){
                    return true;
                }else return false;
            }
            case ("eur"):{
                if (account.getWalletEur()>=amount){
                    return true;
                }else return false;

            }
            case ("uan"):{
                if (account.getWalletUan()>=amount){
                    return true;
                }else return false;
            }
        }

    return true;
    }

    @Override
    public User getUserByCard(String card) {

     User user= null;


     tr.begin();

     user= (User) en.createQuery("Select u from User u where u.account.card='"+card+"'").getSingleResult();
     tr.commit();


        return user;
    }

    @Override
    public boolean convertCurrency(String fromWhichCurrency, String toWhichCurrency, double amount,String card) {

        ExchangeRateAdo ado = new ExchangeRateAdoImpl();
        ado.updateData();
        ExchangeRate exchangeRate= (ExchangeRate) ado.getAllDate();
        Account account = getAccountByCard(card);

    if (fromWhichCurrency.toLowerCase().equals("uan") && (toWhichCurrency.toLowerCase().equals("usd"))) {
        tr.begin();
        account.setWalletUan(account.getWalletUan() - amount);
        account.setWalletUsd((account.getWalletUsd() + amount / Double.parseDouble(exchangeRate.getUsd())));
        tr.commit();
    } else if (fromWhichCurrency.toLowerCase().equals("usd") && (toWhichCurrency.toLowerCase().equals("uan"))) {
        tr.begin();
        account.setWalletUsd(account.getWalletUsd() - amount);
        account.setWalletUan((account.getWalletUan() + amount * Double.parseDouble(exchangeRate.getUsd())));
        tr.commit();
    } else if (fromWhichCurrency.toLowerCase().equals("eur") && (toWhichCurrency.toLowerCase().equals("uan"))) {
        tr.begin();
        account.setWalletEur(account.getWalletEur() - amount);
        account.setWalletUan((account.getWalletUan() + amount * Double.parseDouble(exchangeRate.getEur())));
        tr.commit();
    } else if (fromWhichCurrency.toLowerCase().equals("uan") && (toWhichCurrency.toLowerCase().equals("eur"))) {
        tr.begin();
        account.setWalletUan(account.getWalletUan() - amount);
        account.setWalletEur((account.getWalletEur() + amount / Double.parseDouble(exchangeRate.getEur())));
        tr.commit();
    } else if (fromWhichCurrency.toLowerCase().equals("eur") && (toWhichCurrency.toLowerCase().equals("usd"))) {
        tr.begin();
        account.setWalletEur(account.getWalletEur() - amount);
        account.setWalletUsd(account.getWalletUsd() + ((amount / (Double.parseDouble(exchangeRate.getUsd())) * Double.parseDouble(exchangeRate.getEur()))));
        tr.commit();
    } else if (fromWhichCurrency.toLowerCase().equals("usd") && (toWhichCurrency.toLowerCase().equals("eur"))) {
        tr.begin();
        account.setWalletUsd(account.getWalletUsd() - amount);
        account.setWalletEur(account.getWalletEur() + ((amount / (Double.parseDouble(exchangeRate.getEur())) * Double.parseDouble(exchangeRate.getUsd()))));
        tr.commit();
    } else return false;

        return true;
    }

    @Override
    public double getAllMoneyInUan(String card) {
        Account account = getAccountByCard(card);
        ExchangeRateAdo ado = new ExchangeRateAdoImpl();
        ado.updateData();
        ExchangeRate ex=ado.getAllDate();
        double sum=0.0;


        sum = account.getWalletUan()+account.getWalletEur()*Double.parseDouble(ex.getEur()) +account.getWalletUsd()*Double.parseDouble(ex.getUsd());

        return DoubleRounder.round(sum,2);
    }


}
