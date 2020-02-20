package last.minute;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Integer> bookIds;
    private int signUpDays;
    private int booksPerDay;

    public Library(int numBooks, int signUpDays, int booksPerDay) {
        this.bookIds = new ArrayList<>(numBooks);
        this.signUpDays = signUpDays;
        this.booksPerDay = booksPerDay;
    }

    public List<Integer> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Integer> bookIds) {
        this.bookIds = bookIds;
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
                "bookIds=" + bookIds +
                ", signUpDays=" + signUpDays +
                ", booksPerDay=" + booksPerDay +
                '}';
    }
}
