package hw;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

public class Main {
    public static void main(String[] args) {

        double[] x = {1, 5, 4, 8};
        double[] y = {2, 4, 8, 16};
        double corr = new PearsonsCorrelation().correlation(y, x);  //функциональный подход

        System.out.println(corr);
        System.out.println(imperativeCorrelation(x, y)); // императивный подход
    }

    public static double imperativeCorrelation(double[] xs, double[] ys) {
        //TODO: check here that arrays are not null, of the same length etc

        double sx = 0.0;
        double sy = 0.0;
        double sxx = 0.0;
        double syy = 0.0;
        double sxy = 0.0;

        int n = xs.length;

        for (int i = 0; i < n; ++i) {
            double x = xs[i];
            double y = ys[i];

            sx += x;
            sy += y;
            sxx += x * x;
            syy += y * y;
            sxy += x * y;
        }

        // covariation
        double cov = sxy / n - sx * sy / n / n;
        // standard error of x
        double sigmax = Math.sqrt(sxx / n - sx * sx / n / n);
        // standard error of y
        double sigmay = Math.sqrt(syy / n - sy * sy / n / n);

        // correlation is just a normalized covariation
        return cov / sigmax / sigmay;
    }
}