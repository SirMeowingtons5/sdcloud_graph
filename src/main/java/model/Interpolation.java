package model;

import com.sun.istack.internal.NotNull;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.*;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionNewtonForm;
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
    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;

    /**
     * @param funcValues array of x and y pairs; [i][0] is X and [i][1] is Y
     */
    public Interpolation(double[][] funcValues){
        x = new double[funcValues.length];
        y = new double[funcValues.length];
        for (int i = 0; i < funcValues.length; i++){
            x[i] = funcValues[i][0];
            y[i] = funcValues[i][1];
            //find min and max for array
            min = Double.min(min, x[i]);
            max = Double.max(max, x[i]);
        }
    }

    /**
     * @param funcValues array of x and y pairs; [i][0] is X and [i][1] is Y
     * @param step value between each x value for interpolation
     */
    public Interpolation(@NotNull double[][] funcValues, double step){
        this(funcValues);
        setStep(step);
    }

    private void setStep(double value){
        if (value > 0){
            step = value;
        }else{
            step = 0.1;
        }
    }

    /**
     * Interpolates with splines
     * @return array of x and y pairs, [i][0] is X and [i][1] is Y.
     */
    public double[][] splineInterpolation(){
        SplineInterpolator interpolator = new SplineInterpolator();
        PolynomialSplineFunction function = interpolator.interpolate(x, y);

        return getInterpolatedValues(function);
    }

    /**
     * Interpolates with divided difference algorithm.
     * @return array of x and y pairs, [i][0] is X and [i][1] is Y.
     */
    public double[][] dividedDifferenceInterpolation(){
        DividedDifferenceInterpolator interpolator = new DividedDifferenceInterpolator();
        PolynomialFunctionNewtonForm function = interpolator.interpolate(x, y);

        return getInterpolatedValues(function);
    }

    /**
     * linear function for interpolation of real univariate functions.
     * @return array of x and y pairs, [i][0] is X and [i][1] is Y.
     */
    public double[][] linearInterpolation(){
        LinearInterpolator interpolator = new LinearInterpolator();
        PolynomialSplineFunction function = interpolator.interpolate(x, y);

        return getInterpolatedValues(function);
    }

    /**
     * Implements the Neville's Algorithm for interpolation of real univariate functions.
     * @return array of x and y pairs, [i][0] is X and [i][1] is Y.
     */
    public double[][] nevilleInterpolation(){
        NevilleInterpolator interpolator = new NevilleInterpolator();
        PolynomialFunctionLagrangeForm function = interpolator.interpolate(x, y);

        return getInterpolatedValues(function);
    }


    private double[][] getInterpolatedValues(UnivariateFunction function){
        int steps = (int) ((max - min) / step);
        double[][] res = new double[steps][2];
        double pointer = min;
        for (int i = 0; i < res.length; i++){
            res[i][0] = pointer;
            res[i][1] = function.value(pointer);
            pointer+=step;
        }
        return res;
    }
}
