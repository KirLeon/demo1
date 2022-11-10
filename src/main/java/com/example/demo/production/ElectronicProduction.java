package com.example.demo.production;

import java.util.Objects;

public class ElectronicProduction implements Production{
    private ElectronicProduction(){

    }

    public ElectronicProduction(int id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    private Integer id;

    private String title;

    private String author;

    private int publicationYear;

    public Integer getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String getPublishingCompany() {
        return getAuthor();
    }

    @Override
    public void setPublishingCompany(String publishingCompany) {
        setAuthor(publishingCompany);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicProduction that = (ElectronicProduction) o;
        return publicationYear == that.publicationYear && title.equals(that.title) && author.equals(that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, publicationYear);
    }

    @Override
    public String toString() {
        return "ElectronicProduction{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
