package A_NM_matrix;

import java.lang.String;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.Math;

public class MonteCarlo {
    private AtomicInteger total_points = new AtomicInteger(0);
    private AtomicInteger points_inside_circle = new AtomicInteger(0);

    class MonteCarloThread extends Thread {
        private int iterations;

        public MonteCarloThread(int iter) {
            iterations = iter;
            start();
        }
        public void run() {
            for (int i = 0; i < iterations; i++) {
                double x = 2 * Math.random() - 1;
                double y = 2 * Math.random() - 1;
                if (x * x + y * y <= 1) {
                    points_inside_circle.addAndGet(1);
                }
                total_points.addAndGet(1);
            }
        }
    }

    public void count(String[] args) {
        int num_of_threads = Integer.parseInt(args[0]);
        int total_iters = 1000000;
        int temp_iter = total_iters / num_of_threads;

        MonteCarloThread threads[] = new MonteCarloThread[num_of_threads];
        for (int i = 0; i < num_of_threads; i++) {
            if (i < total_iters % num_of_threads) {
                threads[i] = new MonteCarloThread(temp_iter + 1);
            } else {
                threads[i] = new MonteCarloThread(temp_iter);
            }
        }
        for (int i = 0; i < num_of_threads; i++) {
            while (threads[i].isAlive());
        }
        calculatePI(num_of_threads);
    }

    public void calculatePI(int num_of_threads) {
        double d = 4.0 * points_inside_circle.doubleValue() / total_points.doubleValue();
        System.out.println("Total number of points generated: " + total_points);
        System.out.println("Total number of points inside unit circle: " + points_inside_circle);
        System.out.println("Calculated value of PI is " + d);
        System.out.println(
                "Difference between calculated value and value in Math library is " + String.valueOf(d - Math.PI));
    }

    public static void main(String[] args) {
        for_the_sake_of_beauty();
        try {
            MonteCarlo assignment1q1 = new MonteCarlo();
            if (Integer.parseInt(args[0]) < 4 || Integer.parseInt(args[0]) > 16) {
                throw new Exception();
            }
            System.out.println("Number of threads created " + args[0]);
            assignment1q1.count(args);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Number of threads to be generated was not provided.");
        } catch (Exception e) {
            System.out.println("Number of threads should be between 4 to 16. Error while executing the program.");
        }
        for_the_sake_of_beauty();
    }

    /*static void doMethod() {
        for_the_sake_of_beauty();
        System.out.println("MonteCarlo_solve: ");
        MonteCarlo_solve();
        for_the_sake_of_beauty();
    }*/

    static void for_the_sake_of_beauty() {
        System.out.println("\n---------------------------------------------------\n");
    }
}