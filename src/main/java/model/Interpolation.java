package model;

import com.sun.istack.internal.NotNull;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

/**
 * class for Interpolation methods
 * @author Viacheslav Tarannikov
 * @version 0.1a
 */
public class Interpolation {
    private double x[];
    private double y[];
    private double step;

    /**
     * @param funcValues array of x and y pairs; [i][0] is X and [i][1] is Y
     */
    public Interpolation(double[][] funcValues){
        x = new double[funcValues.length];
        y = new double[funcValues.length];
        for (int i = 0; i < funcValues.length; i++){
            x[i] = funcValues[i][0];
            y[i] = funcValues[i][1];
        }
    }

    /**
     * @param funcValues array of x and y pairs; [i][0] is X and [i][1] is Y
     * @param step value between each x value for interpolation
     */
    public Interpolation(@NotNull double[][] funcValues, double step){
        setStep(step);
        x = new double[funcValues.length];
        y = new double[funcValues.length];
        for (int i = 0; i < funcValues.length; i++){
            x[i] = funcValues[i][0];
            y[i] = funcValues[i][1];
        }
    }

    public void setStep(double value){
        if (value > 0){
            step = value;
        }else{
            step = 0.1;
        }
    }

    /**
     * Interpolates with splines
     * @param start starting X coordinates
     * @param end ending X coordinates
     * @see Interpolation#setStep
     * @return array of x and y pairs, [i][0] is X and [i][1] is Y;
     * size depends on starting and end points and step size
     */
    public double[][] splineInterpolation(double start, double end){
        if (start > end){
            double temp = start;
            start = end;
            end = temp;
        }
        int steps = (int) Math.ceil((end - start) / step);
        double[][] res = new double[steps][2];
        SplineInterpolator interpolator = new SplineInterpolator();
        PolynomialSplineFunction function = interpolator.interpolate(x, y);

        for (int i = 0; i < res.length; i++){
            res[i][0] = start;
            res[i][1] = function.value(start);
            start+=step;
        }
        return res;
    }
}
