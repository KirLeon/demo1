package com.example.demo.production;

import java.util.Objects;

public class Newspaper implements Production{
    private Newspaper(){

    }

    public Newspaper(int id, String title, String publishingCompany, int publicationYear) {
        this.title = title;
        this.publishingCompany = publishingCompany;
        this.publicationYear = publicationYear;
    }

    private int id;

    private String title;

    private String publishingCompany;

    private int publicationYear;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
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
    public String getPublishingCompany() {
        return publishingCompany;
    }

    @Override
    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    @Override
    public String getAuthor() {
        return getPublishingCompany();
    }

    @Override
    public void setAuthor(String author) {
        setPublishingCompany(author);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newspaper newspaper = (Newspaper) o;
        return publicationYear == newspaper.publicationYear && title.equals(newspaper.title) && publishingCompany.equals(newspaper.publishingCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, publicationYear);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "title='" + title + '\'' +
                ", publishingCompany='" + publishingCompany + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
