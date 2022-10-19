package vn.book.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;
    private String phoneNumber;
    private String note;
    private String city;
    private String district;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Card> cards;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<BooksSold> booksSolds;

    public Customer() {
    }

    public Customer(int id, String customerName, String phoneNumber, String note, String city, String district, String address, List<Card> cards) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.city = city;
        this.district = district;
        this.address = address;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<BooksSold> getBooksSolds() {
        return booksSolds;
    }

    public void setBooksSolds(List<BooksSold> booksSolds) {
        this.booksSolds = booksSolds;
    }
}
