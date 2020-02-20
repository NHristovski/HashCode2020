package last.minute;

public class LibraryWithScore {
    private Library library;
    private double score;

    public LibraryWithScore(Library library, double score) {
        this.library = library;
        this.score = score;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "LibraryWithScore{" +
                "library=" + library +
                ", score=" + score +
                '}';
    }


}
