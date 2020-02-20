package last.minute;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private int signUpDays;
    private int booksPerDay;

    public Library(int numBooks, int signUpDays, int booksPerDay) {
        this.books = new ArrayList<>(numBooks);
        this.signUpDays = signUpDays;
        this.booksPerDay = booksPerDay;
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
                "books=" + books +
                ", signUpDays=" + signUpDays +
                ", booksPerDay=" + booksPerDay +
                '}';
    }

    public void sort() {
        this.books.sort(Comparator.comparing(Book::getScore));
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
}
