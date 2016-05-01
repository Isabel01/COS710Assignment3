package org.uma.jmetal.problem.multiobjective.cec2010;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.util.JMetalException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by Hanrich Potgieter on 2016-05-01.
 */
public class SEF extends AbstractDoubleProblem {

    /** Constructor. Creates default instance of problem ZDT1 (30 decision variables) */
    public SEF() {
        this(30);
    }

    /**
     * Creates a new instance of problem ZDT1.
     *
     * @param numberOfVariables Number of variables.
     */
    public SEF(Integer numberOfVariables) {
        setNumberOfVariables(numberOfVariables);
        setNumberOfObjectives(2);
        setName("SEF");

        List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
        List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

        for (int i = 0; i < getNumberOfVariables(); i++) {
            lowerLimit.add(-100.0);
            upperLimit.add(100.0);
        }

        setLowerLimit(lowerLimit);
        setUpperLimit(upperLimit);
    }

    /** Evaluate() method */
    public void evaluate(DoubleSolution solution) {
        double[] x = new double[getNumberOfVariables()];
        for (int i = 0; i < solution.getNumberOfVariables(); i++) {
            x[i] = solution.getVariableValue(i) ;
        }
        double yj;
        double sum1 = 0.0;
        double sum2 = 0.0;
        double o = 0.0;


        for (int j = 0 ; j < getNumberOfVariables(); j++) {
            yj = Math.pow((Math.pow(10, 6)),(j-1)/(getNumberOfVariables()-1))*Math.pow(x[j] - o,2);
            sum1 += yj;
        }
        o++;
        for (int j = 0 ; j < getNumberOfVariables(); j++) {
            yj = Math.pow((Math.pow(10, 6)),(j-1)/(getNumberOfVariables()-1))*Math.pow(x[j] - o,2);
            sum2 += yj;
        }

        solution.setObjective(0, sum1);
        solution.setObjective(1, sum2);
    }

    /**
     * Returns the value of the ZDT1 function G.
     *
     * @param solution Solution
     */
    private double evalG(DoubleSolution solution) {
        double g = 0.0;
        for (int i = 1; i < solution.getNumberOfVariables(); i++) {
            g += solution.getVariableValue(i);
        }
        double constant = 9.0 / (solution.getNumberOfVariables() - 1);
        g = constant * g;
        g = g + 1.0;
        return g;
    }

    /**
     * Returns the value of the ZDT1 function H.
     *
     * @param f First argument of the function H.
     * @param g Second argument of the function H.
     */
    public double evalH(double f, double g) {
        double h ;
        h = 1.0 - Math.sqrt(f / g);
        return h;
    }
    /*
    public SEF() {
        this(30);
    }


    public SEF(int numberOfVariables) {
        setNumberOfVariables(numberOfVariables) ;
        setNumberOfObjectives(2) ;
        setNumberOfConstraints(0);

        setName("SEF") ;

        List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
        List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

        for (int i = 1; i < getNumberOfVariables(); i++) {
            lowerLimit.add(-100.0);
            upperLimit.add(100.0);
        }

        setLowerLimit(lowerLimit);
        setUpperLimit(upperLimit);
    }



    public void evaluate(DoubleSolution solution) {

        double[] x = new double[getNumberOfVariables()];
        for (int i = 0; i < solution.getNumberOfVariables(); i++) {
            x[i] = solution.getVariableValue(i) ;
        }
        double yj;
        double sum1 = 0.0;
        double sum2 = 0.0;
        double o = 0.0;


        for (int j = 2 ; j <= getNumberOfVariables(); j++) {
            yj = Math.pow((Math.pow(10, 6)),(j-1)/(getNumberOfVariables()-1))*Math.pow(x[j] - o,2);
            sum1 += yj;
        }
        o++;
        for (int j = 2 ; j <= getNumberOfVariables(); j++) {
            yj = Math.pow((Math.pow(10, 6)),(j-1)/(getNumberOfVariables()-1))*Math.pow(x[j] - o,2);
            sum2 += yj;
        }


        solution.setObjective(0, sum1);
        solution.setObjective(1, sum2);
    }
    */
}
