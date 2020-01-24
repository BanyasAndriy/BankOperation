package Entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "transaction")
public class Transaction {




    @Id
    @GeneratedValue
    private int idTransaction;

    @Column(name = "cardOfTheSender")
    private String to;
    @Column(name = "cardOfTheRecipient")
    private String from;
    private String currency;
    private double amount;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "userId")
    private User user;


    public Transaction(String to, String from, String currency, double amount, LocalDate date ,LocalTime time , User user) {
        this.to = to;
        this.from = from;
        this.currency = currency;
        this.amount = amount;
        this.date=date;
        this.time=time;
        this.user = user;
    }


    public Transaction() {
    }


    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time.toString();
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return idTransaction == that.idTransaction &&
                amount == that.amount &&
                Objects.equals(to, that.to) &&
                Objects.equals(from, that.from) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaction, to, from, currency, amount, user);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("idTransaction=").append(idTransaction);
        sb.append(", To='").append(to).append('\'');
        sb.append(", From='").append(from).append('\'');
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();

    }
}
