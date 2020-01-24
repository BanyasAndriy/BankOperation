package Entity;


import org.decimal4j.util.DoubleRounder;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAccount;

    private String card;



    @Column(name = "uanWallet")
    private double walletUan;
    @Column(name = "usdWallet")
    private double walletUsd;
    @Column(name = "eurWallet")
    private double walletEur;


     @OneToOne( fetch = FetchType.EAGER,  mappedBy = "account")
    private User user;


    public Account(String card, double walletUan, double walletUsd, double walletEur) {
        this.card = card;
        this.walletUan = walletUan;
        this.walletUsd = walletUsd;
        this.walletEur = walletEur;

    }


    public Account() {
    }


    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public double getWalletUan() {
        return walletUan;
    }

    public void setWalletUan(double walletUan) {
        this.walletUan =  DoubleRounder.round(walletUan,2);
    }

    public double getWalletUsd() {
        return walletUsd;
    }

    public void setWalletUsd(double walletUsd) {
        this.walletUsd =  DoubleRounder.round(walletUsd,2);
    }

    public double getWalletEur() {
        return walletEur;
    }

    public void setWalletEur(double walletEur) {
        this.walletEur = DoubleRounder.round(walletEur,2);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("idAccount=").append(idAccount);
        sb.append(", card='").append(card).append('\'');
        sb.append(", walletUan=").append(walletUan);
        sb.append(", walletUsd=").append(walletUsd);
        sb.append(", waletEur=").append(walletEur);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();

    }
}
