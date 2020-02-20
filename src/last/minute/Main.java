package last.minute;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<Integer, Integer> books; // id -> score
        HashMap<Integer, Library> libraries;
        int daysForScaning;
        int numberOfBooks;
        int numberOfLibraries;

        FileInputStream fileInputStream = new FileInputStream(
                new File("C:\\Users\\hp\\dev\\hashCode\\src\\last\\minute\\a_example.txt"));

        // write your code here
        FastReader reader = new FastReader(fileInputStream);

        
//        String[] parts = firstLine.split(" ");
//


        numberOfBooks = reader.nextInt();
        numberOfLibraries = reader.nextInt();
        daysForScaning = reader.nextInt();

        System.out.println("noBooks: " + numberOfBooks + " noLibraries: " + numberOfLibraries
                + " daysForScanning: " + daysForScaning);

        books = new HashMap<>(numberOfBooks);

        for (int i = 0; i < numberOfBooks; i++){
            int score = reader.nextInt();
            books.put(i,score);
        }
        System.out.println(books);


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
                l.getBookIds().add(currBookId);
            }

            libraries.put(i,l);
        }

        System.out.println("libraries: " + libraries);
//        String scores = reader.nextLine();
//        String[] scoresParts = scores.split(" ");
//        for (int i = 0; i < scoresParts.length; i++){
//
//        }
//
//        libraries = new HashMap<>(numberOfLibraries);
//
//        String currLibrary;
//        int lBooks;
//        for (int i = 0; i < numberOfLibraries; i++){
//            currLibrary = reader.nextLine();
//
//            String[] lParts = currLibrary.split(" ");
//            lBooks = Integer.parseInt()
//        }
    }
}
