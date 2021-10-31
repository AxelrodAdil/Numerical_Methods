package A_NM_matrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Adil
 */

public class Half_division_method {

    /**
     * https://www.youtube.com/watch?v=TtcdAd2WVr0&ab_channel=%D0%9F%D0%BE%D0%B4%D1%81%D0%BB%D1%83%D1%88%D0%B0%D0%BD%D0%BE%D0%BF%D0%BE%D0%98%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B5
     */

    static int count = 0;
    static double answer_exc = 0;
    static double answer_x = 0;

    static double calculate(double x0){
        return 5*Math.cos(Math.pow(x0,2)) - 3*x0;
    }

    public static double Half_Division_Method(double a0, double b0) {
        double fx_a = calculate(a0);
        double fx_b = calculate(b0);
        double x0 = (a0 + b0) / 2;
        double fx_x = calculate(x0);

        System.out.println("fx_a ___ a0: " + fx_a + "  " + a0);
        System.out.println("fx_b ___ b0: " + fx_b + "  " + b0);
        System.out.println("fx_x ___ x0: " + fx_x + "  " + x0);
        System.out.println();

        count++;
        if(count < 4){
            answer_exc = Math.abs(fx_x);
            answer_x = x0;
        }

        if (Math.abs(fx_x) < 0.0001) {
            System.out.println("Iteration: " + count);
            System.out.println("Answer: " + x0 + " корень уравнения с точностью 0.0001");
            return 1;
        }

        if (fx_a * fx_x < 0) {
            Half_Division_Method(a0, x0);  // recursion if non-positive
        } else {
            Half_Division_Method(x0, b0);  // recursion if positive
        }

        //throw new IllegalArgumentException("no match found!");
        return 1;
    }

    static void doMethod() {
        System.out.println("Half division method:");
        double[] ans_step_method = new double[]{0.8, 1.1};  // {a, b}
        double fx_a = calculate(ans_step_method[0]);
        double fx_b = calculate(ans_step_method[1]);
        if(fx_a*fx_b < 0) {
            Half_Division_Method(ans_step_method[0], ans_step_method[1]);
        }
        for_the_sake_of_beauty();
        System.out.println("Answer: " + answer_x + " корень уравнения с точностью " + round(answer_exc, 2));
        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty(){
        System.out.println("\n---------------------------------------------------\n");
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}