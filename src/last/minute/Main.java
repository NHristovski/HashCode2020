package last.minute;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<Integer, Book> books; // id -> score
        HashMap<Integer, Library> libraries;
        int daysForScaning;
        int numberOfBooks;
        int numberOfLibraries;

        FileInputStream fileInputStream = new FileInputStream(
                new File("C:\\Users\\hp\\Downloads\\a_example.txt"));

        // write your code here
        FastReader reader = new FastReader(fileInputStream);


//        String[] parts = firstLine.split(" ");

        numberOfBooks = reader.nextInt();
        numberOfLibraries = reader.nextInt();
        daysForScaning = reader.nextInt();

//        System.out.println("noBooks: " + numberOfBooks + " noLibraries: " + numberOfLibraries
//                + " daysForScanning: " + daysForScaning);

        books = new HashMap<>(numberOfBooks);

        for (int i = 0; i < numberOfBooks; i++){
            int score = reader.nextInt();
            books.put(i,new Book(i,score));
        }



        libraries = new HashMap<>(numberOfLibraries);

        int currNumBooks;
        int currSignUp;
        int currBooksPerDay;
        for (int i = 0; i < numberOfLibraries; i++){
            currNumBooks = reader.nextInt();
            currSignUp = reader.nextInt();
            currBooksPerDay = reader.nextInt();

            Library l = new Library(currNumBooks,currSignUp,currBooksPerDay);

            for (int j = 0; j < currNumBooks; j++){
                int currBookId = reader.nextInt();
                l.getBooks().add(books.get(currBookId));
            }

            l.sort();
            libraries.put(i,l);
        }


        CalculateScoreForLibrary calculator = new CalculateScoreForLibrary();
        Library currentLibrary;
        for (int i = 0; i < libraries.size(); i++){

            currentLibrary = libraries.get(i);
            double currScore = calculator.calculateScoreForBooks(
                    currentLibrary.getSignUpDays(),
                    currentLibrary.getBooks().size(),
                    currentLibrary.getBooksPerDay(),
                    0,
                    currentLibrary.getScoreFromAll(),
                    20, 20, 20, 20,
                    currentLibrary.getScores(),
                    0.5,
                    20
            );

            System.out.println("for l: " + i + " score: " + currScore);
        }
        
    }
}
