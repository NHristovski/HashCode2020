package last.minute;

import java.util.List;

public class CalculateScoreForLibrary {
    public double calculateScoreForBooks(int signUpTime, int nBooks, int booksPerDay, int duplicates, int score, double x, double y, double z, double r, List<Integer> m, double percentile, int k) {
        return signUpTime * x + ((1.0 * nBooks) / (1.0 * booksPerDay)) * y + z * ((1.0 * score) / (1.0 * booksPerDay)) + duplicates * r + median(m, percentile) * k;
    }

    public static double median(List<Integer> m, double percentile) {
        if (m.size() == 1) {
            return m.get(0);
        } else if (m.size() == 2) {
            return m.get(0) + m.get(1) / 2.0;
        } else {
            double selected = m.size() * percentile;
            int num = (int) (Math.floor(selected));
            return (m.get(num + 1) + m.get(num)) / 2.0;
        }
    }
}
