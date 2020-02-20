package last.minute;

import java.math.*;

public class CalculateScoreForLibrary {
    public double calculateScoreForBooks(int signUpTime, int nBooks, int booksPerDay, int duplicates, int score, double x, double y, double z,double r){
        return signUpTime*x + ((1.0*nBooks)/(1.0*booksPerDay)) * y + z*((1.0*score)/(1.0*booksPerDay)) + duplicates*r;
    }

    public static double median(double[] m, double percentile) {
        if(m.length == 1) {
            return m[0];
        }
        else if(m.length == 2) {
            return m[0] + m[1] / 2.0;
        }
        else {
            double selected = m.length * percentile;
            int num = (int) (Math.floor(selected));
            return (m[num + 1] + m[num]) / 2.0;
        }
    }
}
