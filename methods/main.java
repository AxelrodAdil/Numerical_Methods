package A_NM_matrix;

import A_NM_matrix.Lagrange.function_Lagrange_interpolation;
import A_NM_matrix.Trapezoidal.Integral;

/**
 * @author Adil
 */

public class main {
    public static void main(String[] args) {
        //Inverse.doMethod();
        //Gaus.doMethod();
        //Cholesky.doMethod();
        //Iterative.doMethod();
        //Seidel.doMethod();
        //Half_division_method.doMethod();
        //Newtons_method_tangents.doMethod();
        //Newton_Raphson_Method.doMethod();

        function_Newton_interpolation.doMethod();
        function_Lagrange_interpolation.doMethod();
        Simpson_rule.doMethod();
        Integral.doMethod();
        //MonteCarlo.doMethod();  public static void main
    }
}