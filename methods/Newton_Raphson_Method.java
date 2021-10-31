package A_NM_matrix;

/**
 * @author Adil
 */

public class Newton_Raphson_Method {

    /**
     * http://mathhelpplanet.com/static.php?p=metody-resheniya-sistem-nelineynykh-uravneniy
     * https://en.wikipedia.org/wiki/Newton%27s_method
     */

    public static final double exc = 0.001;

    static double function(double x) {  // Bisection Method
        return x * x * x - x * x + 2;
    }

    static double DerivativeFunction(double x) {
        return 3 * x * x - 2 * x;
    }

    static void NewtonRaphson(double x) {
        double division = function(x) / DerivativeFunction(x);
        while (Math.abs(division) >= exc) {
            division = function(x) / DerivativeFunction(x);
            x = x - division;
        }
        System.out.print("Newton-Raphson: " + Math.round(x * 100.0) / 100.0);
    }

    static void doMethod() {
        System.out.println("Newton_Raphson_Method: ");
        double x0 = -25;
        NewtonRaphson(x0);
        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty() {
        System.out.println("\n---------------------------------------------------\n");
    }
}