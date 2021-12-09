package A_NM_matrix.Trapezoidal;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Integral {
    public static double result = 0;
    public static Semaphore mutex = new Semaphore(1);
    public static Semaphore Mutex_barrier = new Semaphore(1);
    public static Semaphore barrier = new Semaphore(0);
    public static int counter = 0;
    public static int p;
    public static long startTime;
    public static long endTime;

    static void trapezoidal() {
        Scanner scanner = new Scanner(System.in);

        /*System.out.print("a:");
        double a = scanner.nextDouble();
        System.out.print("\nb:");
        double b = scanner.nextDouble();
        System.out.print("\nn:");
        int n = scanner.nextInt();*/

        double a = 1;
        double b = 2;
        double n = 100000000;

        System.out.print("Enter the number of threads to use:");
        p = scanner.nextInt();
        Thread[] threads = new Thread[p];
        double pR = n / p;
        double h = (b - a) / n;
        double aux = a;

        for (int i = 0; i < p; ++i) {
            threads[i] = new Thread(new Calculator(
                    pR,
                    h,
                    aux,
                    i
            ));
            aux += (pR * h);
        }
        startTime = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void doMethod() {
        for_the_sake_of_beauty();
        System.out.println("Trapezoidal: ");
        trapezoidal();
        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty() {
        System.out.println("\n---------------------------------------------------\n");
    }
}