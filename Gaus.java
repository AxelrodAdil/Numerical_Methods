package A_NM_matrix;

import java.util.Arrays;

public class Gaus {
    // https://ru.onlinemschool.com/math/assistance/equation/gaus/
    // https://www.youtube.com/watch?v=Yl_I4iYlyus&ab_channel=numericalmethodsguy

    /**
     *
     *  { 0, 1,  1 }
     *  { 2, 4, -2 }
     *  { 0, 3, 15 }
     *
     */
    public static double[] solve(double[][] A, double[] b) {
        int n = b.length;
        for (int p = 0; p < n; p++) {
            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }

            double[] temp = A[p];
            //System.out.println("temp " + Arrays.toString(temp));
            A[p] = A[max];
            A[max] = temp;
            //System.out.println("Amax:" + Arrays.deepToString(A));
            double t = b[p];
            b[p] = b[max];
            b[max] = t;
            System.out.println("\n" + p + ": " + Arrays.deepToString(A));

            // pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                System.out.println(A[i][p] + " " + A[p][p] + " " + alpha);
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        System.out.println("\nResult: " + Arrays.deepToString(A));

        // back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }

    static void doMethod(){
        int n = 3;
        double[][] A = {
                { 0, 1,  1 },
                { 2, 4, -2 },
                { 0, 3, 15 }
        };
        double[] b = { 4, 2, 36 };
        double[] x = solve(A, b);
        for (int i = 0; i < n; i++) {
            System.out.println(x[i]);
        }

        System.out.print("\n2) ---------");
        double[][] AA = {
                { 0, 1,  1, 7 },
                { 2, 4, -2, 4 },
                { 0, 3, 15, 2 },
                { 4, 2, 6, -1 }
        };
        double[] bb = { 4, 2, 36, 5 };
        double[] xx = solve(AA, bb);
        for (int i = 0; i < n+1; i++) {
            System.out.println(xx[i]);
        }
        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty(){
        System.out.println("\n---------------------------------------------------\n");
    }
}