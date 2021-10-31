package A_NM_matrix;

/**
 * @author Adil
 */

public class Newtons_method_tangents {

    /**
     * https://www.youtube.com/watch?v=LhdvBdhWQ_g&t=173s&ab_channel=%D0%9F%D0%BE%D0%B4%D1%81%D0%BB%D1%83%D1%88%D0%B0%D0%BD%D0%BE%D0%BF%D0%BE%D0%98%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B5
     */

    static int count = 0;

    static double calculate(double x0) {
        return 5 * Math.cos(Math.pow(x0, 2)) - 3 * x0;
    }

    static double calculate_1(double x0) {
        return -10 * x0 * Math.sin(Math.pow(x0, 2)) - 3;
    }

    static double calculate_2(double x0) {
        return -10 * Math.sin(Math.pow(x0, 2)) - 20 * x0 * x0 * Math.cos(Math.pow(x0, 2));
    }

    public static double Half_Division_Method(double a0, double fx_a0, double fx_a1) {
        System.out.println("a0: " + a0);
        System.out.println("fx_a0: " + fx_a0);
        System.out.println("fx_a1: " + fx_a1);
        System.out.println();

        double x_step = a0 - (fx_a0/fx_a1);
        double fx_now = calculate(x_step);
        count++;
        if (Math.abs(fx_now) < 0.0001) {
            System.out.println("Iteration: " + count);
            System.out.println("Answer: " + x_step + " корень уравнения с точностью 0.0001");
            return 1;
        } else {
            Half_Division_Method(x_step, fx_now, calculate_1(x_step));
        }

        //throw new IllegalArgumentException("no match found!");
        return 1;
    }

    static void doMethod() {
        System.out.println("Newtons_method_tangents:");  // для одномерного случая
        double[] ans_step_method = new double[]{0.8, 1.1};  // {a, b}
        double fx_a0 = calculate(ans_step_method[0]);
        double fx_a2 = calculate_2(ans_step_method[0]);

        boolean temp_if_fxa = true;
        if(fx_a0*fx_a2 > 0) {
            temp_if_fxa = false;
            Half_Division_Method(ans_step_method[0], fx_a0, calculate_1(ans_step_method[0]));
        }
        if(temp_if_fxa){  // 71-дегі кондишион орындалмаса, 76-82 код аралыгы орындалады.
            fx_a0 = calculate(ans_step_method[1]);
            fx_a2 = calculate_2(ans_step_method[1]);
            if(fx_a0*fx_a2 > 0){
                Half_Division_Method(ans_step_method[1], fx_a0, calculate_1(ans_step_method[1]));
            }
        }
        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty(){
        System.out.println("\n---------------------------------------------------\n");
    }
}