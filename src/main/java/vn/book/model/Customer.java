package vn.book.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;
    private String phoneNumber;
    private String note;
    private String address;
    private String images;
    private LocalDate dateOfBirth;

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

    public Customer(int id, String customerName, String phoneNumber, String note, String address, String images, LocalDate dateOfBirth, AppUser appUser, List<Card> cards, List<BooksSold> booksSolds) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.address = address;
        this.images = images;
        this.dateOfBirth = dateOfBirth;
        this.appUser = appUser;
        this.cards = cards;
        this.booksSolds = booksSolds;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
