package A_NM_matrix;

import java.util.Arrays;
import java.util.Scanner;

public class function_Newton_interpolation {
    static Scanner scan = new Scanner(System.in);
    private static int n = 4;

    private static double[] multiplePolinom(double[] a, double[] b) {
        double[] res = new double[a.length + b.length - 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                res[i + j] += a[i] * b[j];
            }
        }
        return res;
    }

    private static double[] countRes(double[] aCoef, double[] x) {
        double[] res = new double[aCoef.length];
        for (int i = 0; i < aCoef.length; i++) {
            double[] temp = copeWithBrackets(Arrays.copyOfRange(x, 0, i));
            for (int u = 0; u < temp.length; u++) {
                res[n - temp.length + u] += temp[u] * aCoef[i];
            }
        }
        return res;
    }

    private static double[] copeWithBrackets(double[] x) {
        double[] res = new double[1];
        res[0] = 1;
        double[] temp = new double[2];
        temp[0] = 1;
        for (double v : x) {
            temp[1] = -v;
            res = multiplePolinom(res, temp);
        }
        return res;
    }

    private static double[] findCoef(double[] x, double[] y) {
        double[] aCoef = new double[n];
        for (int j = 0; j < aCoef.length; j++) {
            double temp = y[j];
            double tempX = x[j];
            for (int i = 0; i < j; i++) {
                double tem2 = 1;
                for (int f = 0; f < i; f++)
                    tem2 *= (tempX - x[f]);
                temp -= aCoef[i] * tem2;
            }
            double tem3 = 1;
            for (int f = 0; f < j; f++) {
                tem3 *= (tempX - x[f]);
            }
            if (tem3 == 0) {
                if (temp != 0) {
                    aCoef[j] = 0;
                    continue;
                } else {
                    throw new IllegalArgumentException("the abscissas are not distinct");
                }
            }
            aCoef[j] = temp / tem3;
        }
        return aCoef;
    }

    private static double count(double[] polinom) {
        double res = 0;
        for (int i = 0; i < polinom.length; i++) {
            res += polinom[i] * Math.pow(5, n - 1 - i);
        }
        return res;
    }

    static void function_interpolation_solve() {
        System.out.println("What is the number of the points?");
        n = scan.nextInt();
        System.out.println("Enter x values:");
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = scan.nextDouble();

        }
        double[] y = new double[n];
        System.out.println("Enter y values:");
        for (int i = 0; i < n; i++) {
            y[i] = scan.nextDouble();

        }
        double[] aCoef = findCoef(x, y);
        double[] res = countRes(aCoef, x);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i] + "*x^" + (res.length - 1 - i));
        }
        System.out.println(count(res));
    }

    static void doMethod() {
        for_the_sake_of_beauty();
        System.out.println("function_Newton_interpolation_solve: ");
        function_interpolation_solve();
        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty() {
        System.out.println("\n---------------------------------------------------\n");
    }
}