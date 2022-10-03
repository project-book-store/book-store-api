package vn.book.dto;

import vn.book.model.Category;
import vn.book.model.Promotion;

import java.time.LocalDate;
import java.util.Objects;

public class BookDto {
    private int id;
    private String bookCode;
    private String nameBook;
    private String images;
    private String publishingCompany;
    private String translator;
    private String author;
    private int numberPages;
    private String size;
    private LocalDate releaseDate;
    private int amount;
    private double price;
    private boolean isDelete;
    private Category category;
    private Promotion promotion;

    public BookDto() {
    }

    public BookDto(int id, String bookCode, String nameBook, String images, String publishingCompany, String translator, String author, int numberPages, String size, LocalDate releaseDate, int amount, double price, boolean isDelete, Category category, Promotion promotion) {
        this.id = id;
        this.bookCode = bookCode;
        this.nameBook = nameBook;
        this.images = images;
        this.publishingCompany = publishingCompany;
        this.translator = translator;
        this.author = author;
        this.numberPages = numberPages;
        this.size = size;
        this.releaseDate = releaseDate;
        this.amount = amount;
        this.price = price;
        this.isDelete = isDelete;
        this.category = category;
        this.promotion = promotion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return id == bookDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
