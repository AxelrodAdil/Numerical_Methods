package A_NM_matrix;

/**
 * @author Adil
 */

public class Seidel {
    /**
     * https://www.youtube.com/watch?v=F6J3ZmXkMj0&ab_channel=GreggWaterman
     */

    public static double[] seidel(double[][] A) {
        double exc = 0.0001;
        int t = 0;
        double[] I = new double[]{0, 0, 0};
        double[] I2 = new double[]{0, 0, 0};
        double[] recent = new double[]{0, 0, 0};
        while (t++ < 100) {
            I2[0] = (A[0][3] - (A[0][1]*recent[1]) - (A[0][2]*recent[2])) / A[0][0];
            recent[0] = I2[0];
            I2[1] = (A[1][3] - (A[1][0]*recent[0]) - (A[1][2]*recent[2])) / A[1][1];
            recent[1] = I2[1];
            I2[2] = (A[2][3] - (A[2][0]*recent[0]) - (A[2][1]*recent[1])) / A[2][2];
            recent[2] = I2[2];

            System.out.println(t + ": " + I[0] + " " + I[1] + " " + I[2]);
            System.out.println(t + ": " + I2[0] + " " + I2[1] + " " + I2[2]);
            System.out.println("Recent-" + t + ": " + recent[0] + " " + recent[1] + " " + recent[2]);

            if (Math.abs(I2[0] - I[0]) <= exc && Math.abs(I2[1] - I[1]) <= exc && Math.abs(I2[2] - I[2]) <= exc) {
                return new double[]{I2[0], I2[1], I2[2]};
            }
            I[0] = I2[0];
            I[1] = I2[1];
            I[2] = I2[2];
            System.out.println("After IF: " + t + ": " + I[0] + " " + I[1] + " " + I[2]);
            System.out.println();
        }
        throw new IllegalArgumentException("no match found!");
    }

    static void doMethod() {
        System.out.println("Seidel method");
        double[][] A = {{5, -1,  2,  12},
                {3,  8, -2, -25},
                {1,  1,  4,   6}
        };

        double[] I = seidel(A);
        System.out.print("\nAnswer: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(I[i] + " ");
        }
        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty(){
        System.out.println("\n---------------------------------------------------\n");
    }
}