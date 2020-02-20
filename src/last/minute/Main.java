package last.minute;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static String A_EXAMPLE = "src/last/minute/a_example.txt";
    private static String B_READ_ON = "src/last/minute/b_read_on.txt";
    private static String C_INCUNANBULA = "src/last/minute/c_incunabula.txt";
    private static String D_TOUGH_CHOICES = "src/last/minute/d_tough_choices.txt";
    private static String E_SO_MANY_BOOKS = "src/last/minute/e_so_many_books.txt";
    private static String F_LIBRARIES_OF_THE_WORLD = "src/last/minute/f_libraries_of_the_world.txt";

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        HashMap<Integer, Book> books; // id -> score
        HashMap<Integer, Library> libraries;
        int daysForScaning;
        int numberOfBooks;
        int numberOfLibraries;
        int dayForScaningBackup;

        int counter = 0;
        List<String> outputStrings = new ArrayList<>();


        String path = new File(A_EXAMPLE).getAbsolutePath();
        FileInputStream fileInputStream = new FileInputStream(path);

        PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/dshkokl/Desktop/results/a_example.txt"),true);
        // write your code here
        FastReader reader = new FastReader(fileInputStream);



//        String[] parts = firstLine.split(" ");

        numberOfBooks = reader.nextInt();
        numberOfLibraries = reader.nextInt();
        daysForScaning = reader.nextInt();

//        System.out.println("noBooks: " + numberOfBooks + " noLibraries: " + numberOfLibraries
//                + " daysForScanning: " + daysForScaning);

        books = new HashMap<>(numberOfBooks);

        for (int i = 0; i < numberOfBooks; i++) {
            int score = reader.nextInt();
            books.put(i, new Book(i, score));
        }


        libraries = new HashMap<>(numberOfLibraries);

        int currNumBooks;
        int currSignUp;
        int currBooksPerDay;
        for (int i = 0; i < numberOfLibraries; i++) {
            currNumBooks = reader.nextInt();
            currSignUp = reader.nextInt();
            currBooksPerDay = reader.nextInt();

            Library l = new Library(i, currNumBooks, currSignUp, currBooksPerDay);

            for (int j = 0; j < currNumBooks; j++) {
                int currBookId = reader.nextInt();
                l.getBooks().add(books.get(currBookId));
            }

            l.sort();
            libraries.put(i, l);
        }


        CalculateScoreForLibrary calculator = new CalculateScoreForLibrary();
        Library currentLibrary;

        List<LibraryWithScore> allScores = new ArrayList<>(numberOfLibraries);

        for (int i = 0; i < libraries.size(); i++) {

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
            allScores.add(new LibraryWithScore(currentLibrary, currScore));
        }

        allScores = allScores.stream()
                .sorted(Comparator.comparing(LibraryWithScore::getScore).reversed())
                .collect(Collectors.toList());


       // System.out.println(allScores);

        //daysForScaning;


        LibraryWithScore l;
        boolean shouldFinish = false;

        int idx = 0;

        List<Library> toScan = new ArrayList<>();


        //////
        // ds = 7
        //     l  8  2 5

        dayForScaningBackup = daysForScaning;

        while (daysForScaning > 0) {

            if (shouldFinish || idx >= allScores.size()) {
             //   System.out.println("Break;");
                break;
            }

         //   System.out.println("getting for idx: " + idx);
            l = allScores.get(idx);

            //
            while (l.getLibrary().getSignUpDays() > daysForScaning) {

             //   System.out.println(l.getLibrary().getSignUpDays() + " is bigger than " + daysForScaning);
                idx++;

                if (idx < allScores.size()) {

                    //
                    //
                    //
                    //System.out.println("Index is smaller than size");
                    //System.out.println("curr idx: " + idx + " allScores.size: " + allScores.size());

                    l = allScores.get(idx);
                    //System.out.println("CUrent l: "  + l);

                } else {
                    //System.out.println("SHOULD FINISH");
                    shouldFinish = true;
                    break;
                }
            }

            if (!shouldFinish) {
                daysForScaning = daysForScaning - l.getLibrary().getSignUpDays();

                toScan.add(l.getLibrary());

                idx++;
            }
        }

        //pw.println(toScan.size());
//        System.out.println(toScan.size());


        int currentDay = 0;
        //System.out.println("currentDay is: " + currentDay);


        for (int i = 0; i < toScan.size(); i++){
            Library currentScanning = toScan.get(i);
            //System.out.println(currentScanning);

            int numOfBooksScanned = currentScanning.getBSFS(
                    dayForScaningBackup - (currentScanning.getSignUpDays()) - currentDay);

//            System.out.println("numOfBooks that can be scanned: " + numOfBooksScanned);

            if(numOfBooksScanned != 0) {
                outputStrings.add(currentScanning.getId() + " " + numOfBooksScanned);
//                pw.println(currentScanning.getId() + " " + numOfBooksScanned);
            }else{
                continue;
            }
//            System.out.println(currentScanning.getId() + " " + numOfBooksScanned);
            currentDay = currentDay + currentScanning.getSignUpDays();

            //System.out.println("currentDays now is: " + currentDay);

            String concat = "";
            for (int j = 0; j < numOfBooksScanned; j++){
                Book book = currentScanning.getBooks().get(j);
                //pw.print(book.getId() + " ");
                concat += book.getId() + " ";
//                outputStrings.add(book.getId() + " ");

//                System.out.print(book.getId() + " ");
            }
            outputStrings.add(concat);
//            System.out.println();
            if (numOfBooksScanned != 0) {

                //outputStrings.add("");
                counter++;
                //pw.println();
            }

        }

        pw.println(counter);

        for (String str: outputStrings){
            pw.println(str);
        }

    }
}
