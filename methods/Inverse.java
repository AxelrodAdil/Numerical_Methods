package A_NM_matrix;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * @author Adil
 */

public class Inverse {

    static double getSome(int i1, int j1, double[][] matrix){
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i!=i1 && j!=j1){
                    temp.add(matrix[i][j]);
                }
            }
        }
        double a1 = temp.get(0)*temp.get(4)*temp.get(8);
        double a2 = temp.get(1)*temp.get(5)*temp.get(6);
        double a3 = temp.get(2)*temp.get(3)*temp.get(7);
        double a4 = temp.get(2)*temp.get(4)*temp.get(6);
        double a5 = temp.get(1)*temp.get(3)*temp.get(8);
        double a6 = temp.get(0)*temp.get(5)*temp.get(7);
        double ans = a1+a2+a3-a4-a5-a6;
        return ans;
    }

    static ArrayList<Double> getMatrix(double[][] matrix){
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrayList.add(getSome(i, j, matrix));
            }
        }
        return arrayList;
    }

    static void printArrayList(ArrayList<Double> arrayList){
        int i=0;
        for(Double d : arrayList) {
            if (i == 4) {
                i = 0;
                System.out.println();
            }
            i++;
            System.out.print(d + "  -----  ");
        }
        System.out.println("\n");
    }

    static void matrixMulti(double[][]a, double[][]b) {
        double[][] resultMatrix = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    resultMatrix[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("\n---------------------------------------------------\nE-matrix: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(resultMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void doMethod() {
        System.out.println("Main method");
        double[][] matrix = new double[][]{
                {14.4, -5.3, 14.3, -12.7},
                {23.4, -14.2, -5.4, 2.1},
                {6.3, -13.2, -6.5, 14.3},
                {5.4, 8.8, -6.7, -23.8}
        };

        System.out.println("Matrix: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<Double> arrayList = getMatrix(matrix);
        System.out.println("\n---------------------------------------------------\n");
        double detA = matrix[0][0]*arrayList.get(0) - matrix[0][1]*arrayList.get(1) + matrix[0][2]*arrayList.get(2) - matrix[0][3]*arrayList.get(3);
        System.out.println("detA: " + detA);

        ArrayList<Double> arrayList_1 = new ArrayList<>();  // 0 4 8 12 --- 1 5 9 13
        ArrayList<Double> arrayList_2 = new ArrayList<>();
        for(int i=0; i<4; i++){
            arrayList_1.add(arrayList.get(i)/detA);
            arrayList_1.add(arrayList.get(i+4)/detA);
            arrayList_1.add(arrayList.get(i+8)/detA);
            arrayList_1.add(arrayList.get(i+12)/detA);

            arrayList_2.add(arrayList.get(i));
            arrayList_2.add(arrayList.get(i+4));
            arrayList_2.add(arrayList.get(i+8));
            arrayList_2.add(arrayList.get(i+12));
        }

        System.out.println("\n---------------------------------------------------\n\nAllied Matrix: ");
        printArrayList(arrayList_2);
        System.out.println("\n---------------------------------------------------\n\nInverse Matrix: ");
        printArrayList(arrayList_1);

        int k1=0;
        for(Double k : arrayList_1){
            arrayList_1.set(k1, round(k, 3));
            k1++;
        }
        System.out.println("\n---------------------------------------------------\n\nInverse Matrix after round: ");
        printArrayList(arrayList_1);

        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty(){
        System.out.println("\n---------------------------------------------------\n");
    }

    static double[][] createMatrix(ArrayList<Double> arrayList){
        double[][] matrix = new double[4][4];
        int k=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = arrayList.get(k);
                k++;
            }
        }
        return matrix;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}