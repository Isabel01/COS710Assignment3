package org.uma.jmetal.algorithm.multiobjective.Cultural;

import org.uma.jmetal.algorithm.impl.AbstractGeneticAlgorithm;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.operator.SelectionOperator;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;
import org.uma.jmetal.util.solutionattribute.Ranking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanrich Potgieter on 2016-04-30.
 */
public class CulturalAlgoritm<S extends Solution<?>> extends AbstractGeneticAlgorithm<S, List<S>> {

    public CulturalAlgoritm(Problem<S> problem, int maxEvaluations, SolutionListEvaluator<S> evaluator) {
        super(problem);
        this.maxEvaluations = maxEvaluations;
        this.evaluator = evaluator;
    }

    protected final int maxEvaluations;

    protected final SolutionListEvaluator<S> evaluator;

    protected int evaluations;

    @Override protected void initProgress() {
        evaluations = getMaxPopulationSize();
    }

    @Override protected void updateProgress() {
        evaluations += getMaxPopulationSize() ;
    }

    @Override protected boolean isStoppingConditionReached() {
        return evaluations >= maxEvaluations;
    }

    @Override protected List<S> evaluatePopulation(List<S> population) {
        Problem tmp = getProblem();

        return population;
    }

    @Override protected List<S> replacement(List<S> population, List<S> offspringPopulation) {

        return population;
    }

    @Override public List<S> getResult() {
        return null;
    }

    @Override public String getName() {
        return "Cultural Algoritm" ;
    }

    @Override public String getDescription() {
        return "Cutural Algoritm" ;
    }
}
