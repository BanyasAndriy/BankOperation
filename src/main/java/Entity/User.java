package Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private int idUser;
    private String pib;
    private String phone;
    private String email;


    @OneToMany( cascade = CascadeType.ALL,mappedBy = "user",orphanRemoval = true )
    private List<Transaction> transaction = new ArrayList<>();

    public int getIdUser() {
        return idUser;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAccount")
    private Account account ;


    public User() {
    }


    public User(String pib, String phone, String email,  Account account) {
        this.pib = pib;
        this.phone = phone;
        this.email = email;
        this.account = account;
    }


    public void addTransaction(Transaction tr) {
        transaction.add(tr);
        tr.setUser(this);
    }

    public void removeComment(Transaction tr) {
        transaction.remove(tr);
        tr.setUser(null);
    }


    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser &&
                Objects.equals(pib, user.pib) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(transaction, user.transaction) &&
                Objects.equals(account, user.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, pib, phone, email, transaction, account);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("idUser=").append(idUser);
        sb.append(", pib='").append(pib).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
//        sb.append(", transaction=").append(transaction);
//      sb.append(", account=").append(account);
        sb.append('}');
        return sb.toString();
    }
}
