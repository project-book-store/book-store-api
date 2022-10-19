package vn.book.model;

import javax.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cardName;
    private String creditNumber;
    private int expirationDate;
    private int expirationMonth;
    private String codeCvv;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public Card() {
    }

    public Card(int id, String cardName, String creditNumber, int expirationDate, int expirationMonth, String codeCvv, Customer customer) {
        this.id = id;
        this.cardName = cardName;
        this.creditNumber = creditNumber;
        this.expirationDate = expirationDate;
        this.expirationMonth = expirationMonth;
        this.codeCvv = codeCvv;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getCodeCvv() {
        return codeCvv;
    }

    public void setCodeCvv(String codeCvv) {
        this.codeCvv = codeCvv;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
