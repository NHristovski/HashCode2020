package last.minute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private int id;
    private List<Book> books;
    private int signUpDays;
    private int booksPerDay;

    public Library(int id,int numBooks, int signUpDays, int booksPerDay) {
        this.id = id;
        this.books = new ArrayList<>(numBooks);
        this.signUpDays = signUpDays;
        this.booksPerDay = booksPerDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getSignUpDays() {
        return signUpDays;
    }

    public void setSignUpDays(int signUpDays) {
        this.signUpDays = signUpDays;
    }

    public int getBooksPerDay() {
        return booksPerDay;
    }

    public void setBooksPerDay(int booksPerDay) {
        this.booksPerDay = booksPerDay;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", books=" + books +
                ", signUpDays=" + signUpDays +
                ", booksPerDay=" + booksPerDay +
                '}';
    }

    public void sort() {
        this.books = this.books.stream()
        .sorted(Comparator.comparing(Book::getScore).reversed()).collect(Collectors.toList());

    }

    public int getScoreFromAll(){
        return books.stream()
                .mapToInt(Book::getScore)
                .sum();
    }

    public List<Integer> getScores(){
        return this.books.stream()
                .map(Book::getScore)
                .collect(Collectors.toList());
    }

    public int getBSFS(int days){

        //System.out.println("min of: " +  this.getBooks().size() +
        //        "  and days " + days +  " * getBooksPerDay " + this.getBooksPerDay()
       // + " = " + ( days * this.getBooksPerDay() ) );

        return Math.max(0,Math.min(this.getBooks().size(),days * this.getBooksPerDay()));
    }
}
