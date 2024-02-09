package ru.otus.hw28datajdbc.dtos;

import ru.otus.hw28datajdbc.entities.Book;

import java.util.List;

public class PageDtoPagination{
    private String sizePage;
    private  int countPagesBook;
//    private int size;
//    private int totalPages;

    public PageDtoPagination() {
    }

    public PageDtoPagination(List<PageDtoPagination> collect) {
    }

    public PageDtoPagination(int count) {
        this.countPagesBook = count;
    }


    public String getPage() {
        return sizePage;
    }

    public void setPage(String sizePage) {
        this.sizePage = sizePage;
    }

    public void setCountPagesBook(int countPagesBook) {
        this.countPagesBook = countPagesBook;
    }

    public int getCountPagesBook() {
        return countPagesBook;
    }
}
