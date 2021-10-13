package A_NM_matrix;

public class Cholesky {
    // https://www.youtube.com/watch?v=cYzh_DVs5Q8&ab_channel=Let%27sFindtheValueof%22x%22

    /**
     *
     * { 4, 1,  1 }
     * { 1, 5,  3 }
     * { 1, 3, 15 }
     *
     */
    public static boolean isSymmetric(double[][] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                //System.out.println(A[i][j] +" != " + A[j][i] + " ::: " + i + "-" + j + " ::: " + j + "-" + i);
                if (A[i][j] != A[j][i]) return false;
            }
        }
        return true;
    }

    public static boolean isSquare(double[][] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            if (A[i].length != N) return false;
        }
        return true;
    }

    // return Cholesky factor L of psd matrix A = L L^T
    public static double[][] cholesky(double[][] A) {
        if (!isSquare(A)) {
            throw new RuntimeException("Matrix is not square");
        }
        if (!isSymmetric(A)) {
            throw new RuntimeException("Matrix is not symmetric");
        }


        int N  = A.length;
        double[][] L = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                double sum = 0.0;
                for (int k = 0; k < j; k++) {
                    sum += L[i][k] * L[j][k];
                }
                if (i == j) L[i][i] = Math.sqrt(A[i][i] - sum);
                else L[i][j] = 1.0 / L[j][j] * (A[i][j] - sum);
            }

            System.out.println("i: " + L[i][i]);
            if (L[i][i] <= 0) {
                throw new RuntimeException("Matrix is not positive definite");
            }
        }
        return L;
    }

    static void doMethod(){
        System.out.println("Cholesky method");
        int N = 3;
        double[][] A = { { 4, 1,  1 },
                         { 1, 5,  3 },
                         { 1, 3, 15 }
        };
        double[][] L = cholesky(A);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%8.5f ", L[i][j]);
            }
            System.out.println();
        }
        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty(){
        System.out.println("\n---------------------------------------------------\n");
    }
}